package com.khealth.user.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.khealth.user.pojo.ResultData;
import com.khealth.user.pojo.ResultJson;
import com.khealth.user.pojo.User;
import com.khealth.user.service.IUserService;
import com.khealth.user.util.AES256;
import com.khealth.user.util.CardMaker;
import com.khealth.user.util.HXUtil;
import com.khealth.user.util.Md5;
import com.khealth.user.util.MessageUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;	
	
	private static Logger logger = Logger.getLogger(UserController.class);  
			
	@RequestMapping (value = "/login")
	@ResponseBody
	public ResultJson login (HttpServletRequest request) {
		
		ResultData data = new ResultData();
		User user = null;
		String result = "fail";
	    data.setRetCode(400);
	    String checkPwd = "";
	    ResultJson rj = new ResultJson();
	    
	    String encryptResultStr = request.getParameter("jsonData");	
		byte[] decryptFrom = AES256.parseHexStr2Byte(encryptResultStr);  
		byte[] decryptResult = AES256.decrypt(decryptFrom); 
		String jsonData = new String(decryptResult);
		JSONObject paraObject = JSONObject.parseObject(jsonData);		
		
		String password = paraObject.getString("password"); 
		String cellphone = paraObject.getString("cellphone");
		
		Pattern phonePattern = Pattern.compile("^1\\d{10}$");
		Matcher phoneMatcher = phonePattern.matcher(cellphone);
		if(phoneMatcher.find()){
			user = userService.getUserByCellphone(cellphone);
		}
		
		if(user != null) checkPwd = user.getPassword();
		if(checkPwd.equals(password)) {
			result = "success";
		    data.setRetCode(200);
			data.setData(user);
		}else{
			data.setData("\"password wrong\"");
		}
		
		data.setRetDesc(result);
		 
		byte[] encryptResult = AES256.encrypt(data.getAll());  
		encryptResultStr = AES256.parseByte2HexStr(encryptResult);  
		rj.setJson(encryptResultStr);
		
		return rj;
	}
	
	@RequestMapping (value = "/register/phone")
	@ResponseBody
	public ResultJson registByPhone (HttpServletRequest request) {
			
		ResultData data = new ResultData();
		int result = -1;
	    ResultJson rj = new ResultJson();
   
	    String jsonData = request.getParameter("jsonData");
		byte[] decryptFrom = AES256.parseHexStr2Byte(jsonData);
		byte[] decryptResult = AES256.decrypt(decryptFrom);  
		try {
			jsonData = new String(decryptResult, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("中文转换报错"); 
		}
		JSONObject paraObject = JSONObject.parseObject(jsonData);		
		
		String cellphone = paraObject.getString("cellphone");
		String password = paraObject.getString("password"); 
		
		Pattern phonePattern = Pattern.compile("^1\\d{10}$");
		Matcher matcher = phonePattern.matcher(paraObject.getString("cellphone"));		
		
		if(matcher.find()) {
			User user = null;
			
			user  = userService.getUserByCellphone(cellphone);
			if (user == null){				
				HXUtil hXUtil = HXUtil.getHXUtil();
				Md5 md5 = Md5.getMd5();
				String token = hXUtil.getToken();
				Map<String, String> params = new HashMap<String, String>();
				String name = "ky"+cellphone.substring(1);
				params.put("username", name);
				String pwd = md5.EncryptionStr(cellphone,"MD5");
				params.put("password", pwd);
				String hxReg = hXUtil.hxRegister(params, token);
				
				if(hxReg.equals("true")){
					user = new User();
					user.setCellphone(cellphone);
					user.setPassword(password);
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					String time = df.format(new Date());// new Date()为获取当前系统时间
					user.setRegTime(time);
					user.setUsername("未设置");
					user.setHXname(name);
					user.setHXpwd(pwd);
					
					result = userService.addUser(user);
				}
				if(result == 1) {
					data.setRetCode(200);
					data.setRetDesc("success");
				} else{
				    data.setRetCode(400);
					data.setRetDesc("fail");				
				}
			} else {
				data.setRetCode(407);
				data.setRetDesc("This phone number has all ready been registed");
			}
		}
		
		data.setData("\"\"");
		byte[] encryptResult = AES256.encrypt(data.getAll());  
		String encryptResultStr = AES256.parseByte2HexStr(encryptResult);  	
		rj.setJson(encryptResultStr);
		
		return rj;
	}
	
	@RequestMapping (value = "/register/phone/verification")
	@ResponseBody
	public ResultJson getVerification (HttpServletRequest request) {
		
		ResultData data = new ResultData();
	    data.setRetCode(410);
		data.setRetDesc("already send");
		User user = null;
	    MessageUtil mu = new MessageUtil();
	    int result = -1;
	    ResultJson rj = new ResultJson();
	    CardMaker cm = new CardMaker();
	    String verification = cm.getRandCardNo(6);
		String encryptResultStr = request.getParameter("jsonData");	    
		byte[] decryptFrom = AES256.parseHexStr2Byte(encryptResultStr);  
		byte[] decryptResult = AES256.decrypt(decryptFrom); 
		String jsonData = new String(decryptResult);
		JSONObject paraObject = JSONObject.parseObject(jsonData);		
		
		String cellphone = paraObject.getString("cellphone");
				
		Pattern phonePattern = Pattern.compile("^1\\d{10}$");
		Matcher matcher = phonePattern.matcher(cellphone);
		if(matcher.find()) {
			user = userService.getUserByCellphone(cellphone);
			if(user == null){
				result = mu.sendVerification(cellphone, verification);
			} else {
				data.setRetDesc("already exist");
			    data.setRetCode(402);
			}
			if(result == 1){
				data.setRetDesc("send");
			    data.setRetCode(201);
			}
		} else{
			data.setRetDesc("not match");
			data.setRetCode(401);		
		}
		data.setData("{\"verification\":\""+verification+"\"}");
		byte[] encryptResult = AES256.encrypt(data.getAll());  
		encryptResultStr = AES256.parseByte2HexStr(encryptResult);  
		rj.setJson(encryptResultStr);
		
		return rj;
	}
	
	public String getRandCardNo(int length) {
		String charValue = "";
	    for (int i = 0; i < length; i++){
			char temp = '0';
			int tempInt = randomInt(0,9);
			temp += tempInt;
		    charValue += String.valueOf(temp);
	    }
		return charValue;
	}	
	
	public int randomInt(int from, int to){
		  Random r = new Random();
		  return from + r.nextInt(to - from);
	}
}
