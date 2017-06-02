package com.khealth.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;










import com.alibaba.fastjson.JSONObject;
import com.khealth.user.constant.Constant;
import com.khealth.user.pojo.Article;
import com.khealth.user.pojo.Banner;
import com.khealth.user.pojo.Doctor;
import com.khealth.user.pojo.SpecialMix;
import com.khealth.user.pojo.Notice;
import com.khealth.user.pojo.ResultData;
import com.khealth.user.pojo.ResultJson;
import com.khealth.user.pojo.SpecialistTeam;
import com.khealth.user.service.IArticleService;
import com.khealth.user.service.IBannerService;
import com.khealth.user.service.IDoctorService;
import com.khealth.user.service.INoticeService;
import com.khealth.user.service.ISpecialistTeamService;
import com.khealth.user.util.AES256;
import com.khealth.user.util.PageParameter;

@Controller
@RequestMapping("/procedure")
public class MainController {

	private static Logger logger = Logger.getLogger(MainController.class);  

	@Resource
	private IBannerService bannerService;	
	@Resource
	private IDoctorService doctorService;	
	@Resource
	private ISpecialistTeamService specialistTeamService;	
	@Resource
	private IArticleService articleService;	
	@Resource
	private INoticeService noticeService;	
	
	@RequestMapping (value = "/mainPage")
	@ResponseBody
    public ResultJson mainPage(HttpServletRequest request,HttpServletResponse response){  		

		ResultData data = new ResultData();
	    ResultJson rj = new ResultJson();  	

		String result = "{";
	    //top banners
	    int num = Constant.MAINPAGETOPBANNERS;
	    List<Banner> bannerList = bannerService.getBannerByType(1);	
	    result = result + "\"bannerList\":[";
	    if(bannerList != null){
	    	Banner banner;
			for(int i=0; i < bannerList.size(); i++){
				banner = new Banner();
				banner = bannerList.get(i);
				result = result + banner.toString();
				if(i+1 != bannerList.size()){
					result = result + ",";
				}
			}
		} 
		result = result + "]";
	    
		String doctorImg = bannerService.getBannerById(0).getImgURL();
		result = result + ", \"doctorImg\":" + doctorImg;
		
		result = result + ", \"specialTeamList\":[";
		List<Banner> specialTeamList = bannerService.getBannerByType(2);	
		if(specialTeamList != null){
			for(int i=0; i < specialTeamList.size(); i++){
				Banner banner = new Banner();
				banner = specialTeamList.get(i);
				result = result + banner.toString();
				if(i+1 != specialTeamList.size()){
					result = result + ",";
				}
			}
		} 
		result = result + "]";

		result = result + ", \"doctorList\":[";
		List<Doctor> doctorList = doctorService.getDoctorByStatus(2);	
		if(doctorList != null){
			for(int i=0; i < doctorList.size(); i++){
				Doctor doctor = new Doctor();
				doctor = doctorList.get(i);
				result = result + doctor.toShortString();
				if(i+1 != doctorList.size()){
					result = result + ",";
				}
			}
		} 
		result = result + "]";
		
		Article article = articleService.getProfessionalArticle();
		result = result + ", \"professionalArticle\":" + article.getArticleImg();
		
		Notice tip = noticeService.getTopNotice();
		result = result + ", \"tip\":" + tip.getContent();
		
		num = Constant.MAINPAGETOPARTICLES;
		List<Article> articleList = articleService.getTopArticles(num);
		result = result + ", \"articleList\":[";
		if(articleList != null){
			for(int i=0; i < articleList.size(); i++){
				article = new Article();
				article = articleList.get(i);
				result = result + article.toShortString();
				if(i+1 != articleList.size()){
					result = result + ",";
				}
			}
		}
		result = result + "]";
		
		result = result + "]}";
		if(result.equals("{}")){
			result = "\"{}\"";
			data.setRetCode(400);
			data.setRetDesc("fail");
			logger.error("main page error!!!!!!!!!!!!");
		}else {
			data.setRetCode(200);
			data.setRetDesc("success");
			logger.debug("main page success~~~~~~~~~~~~");
		}
		
		data.setData(result);
		
		byte[] encryptResult = AES256.encrypt(data.getAll());  
		String encryptResultStr = AES256.parseByte2HexStr(encryptResult);          
		rj.setJson(encryptResultStr);
		
		return rj;   
    }
	
	@RequestMapping (value = "/doctorList")
	@ResponseBody
    public ResultJson doctorList(HttpServletRequest request,HttpServletResponse response){  		

		ResultData data = new ResultData();
	    ResultJson rj = new ResultJson();  	

		String result = "{";
	    
	    
	    Doctor doctor = new Doctor();
	    List<SpecialMix> specialMixList = new ArrayList<SpecialMix>();
	    SpecialMix specialMix;
	    PageParameter page = new PageParameter();

	    int num = Constant.DOCTORRANKSIZE;
	    page.setPageSize(num);
	    page.setCurrentPage(0);
	    doctor.setPage(page);
	    
	    //doctorList -- rank
	    List<Doctor> doctorList = doctorService.getDoctorByPage(doctor);	
	    int size = doctorList.size();
	    if(doctorList != null){
			for(int i=0; i < size; i++){
				specialMix = new SpecialMix();
				doctor = doctorList.get(i);
				specialMix.setId(doctor.getId());
				specialMix.setDepartment(doctor.getDepartment());
				specialMix.setHospital(doctor.getHospital());
				specialMix.setImgURL(doctor.getImgURL());
				specialMix.setJobTitle(doctor.getJobTitle());
				specialMix.setName(doctor.getName());
				specialMix.setPoint(doctor.getPoint());
				specialMix.setRank(doctor.getRank());
				specialMix.setSkillDesc(doctor.getSkillDesc());
				specialMix.setType(0);
				specialMixList.add(specialMix);
			}
		} 
	    
	    num = Constant.DOCTORPAGESIZE;
	    if(size < Constant.DOCTORRANKSIZE) num = num + Constant.DOCTORRANKSIZE - size;
	    page = new PageParameter();
	    page.setPageSize(num);
	    page.setCurrentPage(0);
	    doctor.setPage(page);
	    
	    //doctorList
	    doctorList = doctorService.getDoctorByPage(doctor);	
	    if(doctorList != null){
			for(int i=0; i < doctorList.size(); i++){
				specialMix = new SpecialMix();
				doctor = doctorList.get(i);
				specialMix.setId(doctor.getId());
				specialMix.setDepartment(doctor.getDepartment());
				specialMix.setHospital(doctor.getHospital());
				specialMix.setImgURL(doctor.getImgURL());
				specialMix.setJobTitle(doctor.getJobTitle());
				specialMix.setName(doctor.getName());
				specialMix.setPoint(doctor.getPoint());
				specialMix.setRank(doctor.getRank());
				specialMix.setSkillDesc(doctor.getSkillDesc());
				specialMix.setType(0);
				specialMixList.add(specialMix);
			}
		} 

	    num = Constant.TEAMRANKSIZE;
	    page = new PageParameter();
		page.setPageSize(num);
	    page.setCurrentPage(0);
	    
	    SpecialistTeam specialistTeam = new SpecialistTeam();
	    specialistTeam.setPage(page);
	    List<SpecialistTeam> specialistTeamList = specialistTeamService.getSpecialistTeamRankByPage(specialistTeam);
		
	    //specialistTeamList--rank
		specialistTeamList = specialistTeamService.getSpecialistTeamByPage(specialistTeam);
		size = specialistTeamList.size();
		if(specialistTeamList != null){
			for(int i=0; i < size; i++){
				specialMix = new SpecialMix();
				specialistTeam = specialistTeamList.get(i);
				specialMix.setId(specialistTeam.getId());
				specialMix.setHospital(specialistTeam.getHospital());
				specialMix.setImgURL(specialistTeam.getImgURL());
				specialMix.setName(specialistTeam.getName());
				specialMix.setPoint(specialistTeam.getPoint());
				specialMix.setRank(specialistTeam.getRank());
				specialMix.setSkillDesc(specialistTeam.getSkillDesc());
				specialMix.setType(0);
				specialMixList.add(specialMix);
			}
		} 
	    
	    num = Constant.TEAMPAGESIZE; 
	    if(size < Constant.TEAMRANKSIZE) num = num + Constant.TEAMRANKSIZE - size;
		page.setPageSize(num);
	    page.setCurrentPage(0);
	    specialistTeam.setPage(page);
		//specialistTeamList
		specialistTeamList = specialistTeamService.getSpecialistTeamByPage(specialistTeam);
		if(specialistTeamList != null){
			for(int i=0; i < specialistTeamList.size(); i++){
				specialMix = new SpecialMix();
				specialistTeam = specialistTeamList.get(i);
				specialMix.setId(specialistTeam.getId());
				specialMix.setHospital(specialistTeam.getHospital());
				specialMix.setImgURL(specialistTeam.getImgURL());
				specialMix.setName(specialistTeam.getName());
				specialMix.setPoint(specialistTeam.getPoint());
				specialMix.setRank(specialistTeam.getRank());
				specialMix.setSkillDesc(specialistTeam.getSkillDesc());
				specialMix.setType(0);
				specialMixList.add(specialMix);
			}
		} 
		
		result = result + "\"doctorList\":[";
		if(specialistTeamList != null){
			for(int i=0; i < specialistTeamList.size(); i++){
				specialMix = new SpecialMix();
				specialMix = specialMixList.get(i);
				result = result + specialMix.toString();
				if(i+1 != specialMixList.size()){
					result = result + ",";
				}
			}
		}
		result = result + "]}";
		if(result.equals("{}")){
			result = "\"{}\"";
			data.setRetCode(400);
			data.setRetDesc("fail");
			logger.error("main page error!!!!!!!!!!!!");
		}else {
			data.setRetCode(200);
			data.setRetDesc("success");
			logger.debug("main page success~~~~~~~~~~~~");
		}
		
		data.setData(result);
		
		byte[] encryptResult = AES256.encrypt(data.getAll());  
		String encryptResultStr = AES256.parseByte2HexStr(encryptResult);          
		rj.setJson(encryptResultStr);
		
		return rj;   
    }
	
	@RequestMapping (value = "/doctorPage")
	@ResponseBody
    public ResultJson doctorPage(HttpServletRequest request,HttpServletResponse response){  		

		ResultData data = new ResultData();
	    ResultJson rj = new ResultJson();  	
	    
	    String encryptResultStr = request.getParameter("jsonData");	
		byte[] decryptFrom = AES256.parseHexStr2Byte(encryptResultStr);  
		byte[] decryptResult = AES256.decrypt(decryptFrom); 
		String jsonData = new String(decryptResult);
		JSONObject paraObject = JSONObject.parseObject(jsonData);		
		
		int doctorId = Integer.parseInt(paraObject.getString("doctorId")); 
		String result = "{";
	    
		
		
		
		
		
		
	    
	    Doctor doctor = new Doctor();
	    List<SpecialMix> specialMixList = new ArrayList<SpecialMix>();
	    SpecialMix specialMix;
	    PageParameter page = new PageParameter();

	    int num = Constant.DOCTORRANKSIZE;
	    page.setPageSize(num);
	    page.setCurrentPage(0);
	    doctor.setPage(page);
	    
	    //doctorList -- rank
	    List<Doctor> doctorList = doctorService.getDoctorByPage(doctor);	
	    int size = doctorList.size();
	    if(doctorList != null){
			for(int i=0; i < size; i++){
				specialMix = new SpecialMix();
				doctor = doctorList.get(i);
				specialMix.setId(doctor.getId());
				specialMix.setDepartment(doctor.getDepartment());
				specialMix.setHospital(doctor.getHospital());
				specialMix.setImgURL(doctor.getImgURL());
				specialMix.setJobTitle(doctor.getJobTitle());
				specialMix.setName(doctor.getName());
				specialMix.setPoint(doctor.getPoint());
				specialMix.setRank(doctor.getRank());
				specialMix.setSkillDesc(doctor.getSkillDesc());
				specialMix.setType(0);
				specialMixList.add(specialMix);
			}
		} 
	    
	    num = Constant.DOCTORPAGESIZE;
	    if(size < Constant.DOCTORRANKSIZE) num = num + Constant.DOCTORRANKSIZE - size;
	    page = new PageParameter();
	    page.setPageSize(num);
	    page.setCurrentPage(0);
	    doctor.setPage(page);
	    
	    //doctorList
	    doctorList = doctorService.getDoctorByPage(doctor);	
	    if(doctorList != null){
			for(int i=0; i < doctorList.size(); i++){
				specialMix = new SpecialMix();
				doctor = doctorList.get(i);
				specialMix.setId(doctor.getId());
				specialMix.setDepartment(doctor.getDepartment());
				specialMix.setHospital(doctor.getHospital());
				specialMix.setImgURL(doctor.getImgURL());
				specialMix.setJobTitle(doctor.getJobTitle());
				specialMix.setName(doctor.getName());
				specialMix.setPoint(doctor.getPoint());
				specialMix.setRank(doctor.getRank());
				specialMix.setSkillDesc(doctor.getSkillDesc());
				specialMix.setType(0);
				specialMixList.add(specialMix);
			}
		} 

	    num = Constant.TEAMRANKSIZE;
	    page = new PageParameter();
		page.setPageSize(num);
	    page.setCurrentPage(0);
	    
	    SpecialistTeam specialistTeam = new SpecialistTeam();
	    specialistTeam.setPage(page);
	    List<SpecialistTeam> specialistTeamList = specialistTeamService.getSpecialistTeamRankByPage(specialistTeam);
		
	    //specialistTeamList--rank
		specialistTeamList = specialistTeamService.getSpecialistTeamByPage(specialistTeam);
		size = specialistTeamList.size();
		if(specialistTeamList != null){
			for(int i=0; i < size; i++){
				specialMix = new SpecialMix();
				specialistTeam = specialistTeamList.get(i);
				specialMix.setId(specialistTeam.getId());
				specialMix.setHospital(specialistTeam.getHospital());
				specialMix.setImgURL(specialistTeam.getImgURL());
				specialMix.setName(specialistTeam.getName());
				specialMix.setPoint(specialistTeam.getPoint());
				specialMix.setRank(specialistTeam.getRank());
				specialMix.setSkillDesc(specialistTeam.getSkillDesc());
				specialMix.setType(0);
				specialMixList.add(specialMix);
			}
		} 
	    
	    num = Constant.TEAMPAGESIZE; 
	    if(size < Constant.TEAMRANKSIZE) num = num + Constant.TEAMRANKSIZE - size;
		page.setPageSize(num);
	    page.setCurrentPage(0);
	    specialistTeam.setPage(page);
		//specialistTeamList
		specialistTeamList = specialistTeamService.getSpecialistTeamByPage(specialistTeam);
		if(specialistTeamList != null){
			for(int i=0; i < specialistTeamList.size(); i++){
				specialMix = new SpecialMix();
				specialistTeam = specialistTeamList.get(i);
				specialMix.setId(specialistTeam.getId());
				specialMix.setHospital(specialistTeam.getHospital());
				specialMix.setImgURL(specialistTeam.getImgURL());
				specialMix.setName(specialistTeam.getName());
				specialMix.setPoint(specialistTeam.getPoint());
				specialMix.setRank(specialistTeam.getRank());
				specialMix.setSkillDesc(specialistTeam.getSkillDesc());
				specialMix.setType(0);
				specialMixList.add(specialMix);
			}
		} 
		
		result = result + "\"doctorList\":[";
		if(specialistTeamList != null){
			for(int i=0; i < specialistTeamList.size(); i++){
				specialMix = new SpecialMix();
				specialMix = specialMixList.get(i);
				result = result + specialMix.toString();
				if(i+1 != specialMixList.size()){
					result = result + ",";
				}
			}
		}
		result = result + "]}";
		if(result.equals("{}")){
			result = "\"{}\"";
			data.setRetCode(400);
			data.setRetDesc("fail");
			logger.error("main page error!!!!!!!!!!!!");
		}else {
			data.setRetCode(200);
			data.setRetDesc("success");
			logger.debug("main page success~~~~~~~~~~~~");
		}
		
		data.setData(result);
		
		byte[] encryptResult = AES256.encrypt(data.getAll());  
		String encryptResultStr = AES256.parseByte2HexStr(encryptResult);          
		rj.setJson(encryptResultStr);
		
		return rj;   
    }
	
	@RequestMapping (value = "/specialistTeamPage")
	@ResponseBody
    public ResultJson specialistTeamPage(HttpServletRequest request,HttpServletResponse response){  		

		ResultData data = new ResultData();
	    ResultJson rj = new ResultJson();  	

		String result = "{";
	    
	    
	    Doctor doctor = new Doctor();
	    List<SpecialMix> specialMixList = new ArrayList<SpecialMix>();
	    SpecialMix specialMix;
	    PageParameter page = new PageParameter();

	    int num = Constant.DOCTORRANKSIZE;
	    page.setPageSize(num);
	    page.setCurrentPage(0);
	    doctor.setPage(page);
	    
	    //doctorList -- rank
	    List<Doctor> doctorList = doctorService.getDoctorByPage(doctor);	
	    int size = doctorList.size();
	    if(doctorList != null){
			for(int i=0; i < size; i++){
				specialMix = new SpecialMix();
				doctor = doctorList.get(i);
				specialMix.setId(doctor.getId());
				specialMix.setDepartment(doctor.getDepartment());
				specialMix.setHospital(doctor.getHospital());
				specialMix.setImgURL(doctor.getImgURL());
				specialMix.setJobTitle(doctor.getJobTitle());
				specialMix.setName(doctor.getName());
				specialMix.setPoint(doctor.getPoint());
				specialMix.setRank(doctor.getRank());
				specialMix.setSkillDesc(doctor.getSkillDesc());
				specialMix.setType(0);
				specialMixList.add(specialMix);
			}
		} 
	    
	    num = Constant.DOCTORPAGESIZE;
	    if(size < Constant.DOCTORRANKSIZE) num = num + Constant.DOCTORRANKSIZE - size;
	    page = new PageParameter();
	    page.setPageSize(num);
	    page.setCurrentPage(0);
	    doctor.setPage(page);
	    
	    //doctorList
	    doctorList = doctorService.getDoctorByPage(doctor);	
	    if(doctorList != null){
			for(int i=0; i < doctorList.size(); i++){
				specialMix = new SpecialMix();
				doctor = doctorList.get(i);
				specialMix.setId(doctor.getId());
				specialMix.setDepartment(doctor.getDepartment());
				specialMix.setHospital(doctor.getHospital());
				specialMix.setImgURL(doctor.getImgURL());
				specialMix.setJobTitle(doctor.getJobTitle());
				specialMix.setName(doctor.getName());
				specialMix.setPoint(doctor.getPoint());
				specialMix.setRank(doctor.getRank());
				specialMix.setSkillDesc(doctor.getSkillDesc());
				specialMix.setType(0);
				specialMixList.add(specialMix);
			}
		} 

	    num = Constant.TEAMRANKSIZE;
	    page = new PageParameter();
		page.setPageSize(num);
	    page.setCurrentPage(0);
	    
	    SpecialistTeam specialistTeam = new SpecialistTeam();
	    specialistTeam.setPage(page);
	    List<SpecialistTeam> specialistTeamList = specialistTeamService.getSpecialistTeamRankByPage(specialistTeam);
		
	    //specialistTeamList--rank
		specialistTeamList = specialistTeamService.getSpecialistTeamByPage(specialistTeam);
		size = specialistTeamList.size();
		if(specialistTeamList != null){
			for(int i=0; i < size; i++){
				specialMix = new SpecialMix();
				specialistTeam = specialistTeamList.get(i);
				specialMix.setId(specialistTeam.getId());
				specialMix.setHospital(specialistTeam.getHospital());
				specialMix.setImgURL(specialistTeam.getImgURL());
				specialMix.setName(specialistTeam.getName());
				specialMix.setPoint(specialistTeam.getPoint());
				specialMix.setRank(specialistTeam.getRank());
				specialMix.setSkillDesc(specialistTeam.getSkillDesc());
				specialMix.setType(0);
				specialMixList.add(specialMix);
			}
		} 
	    
	    num = Constant.TEAMPAGESIZE; 
	    if(size < Constant.TEAMRANKSIZE) num = num + Constant.TEAMRANKSIZE - size;
		page.setPageSize(num);
	    page.setCurrentPage(0);
	    specialistTeam.setPage(page);
		//specialistTeamList
		specialistTeamList = specialistTeamService.getSpecialistTeamByPage(specialistTeam);
		if(specialistTeamList != null){
			for(int i=0; i < specialistTeamList.size(); i++){
				specialMix = new SpecialMix();
				specialistTeam = specialistTeamList.get(i);
				specialMix.setId(specialistTeam.getId());
				specialMix.setHospital(specialistTeam.getHospital());
				specialMix.setImgURL(specialistTeam.getImgURL());
				specialMix.setName(specialistTeam.getName());
				specialMix.setPoint(specialistTeam.getPoint());
				specialMix.setRank(specialistTeam.getRank());
				specialMix.setSkillDesc(specialistTeam.getSkillDesc());
				specialMix.setType(0);
				specialMixList.add(specialMix);
			}
		} 
		
		result = result + "\"doctorList\":[";
		if(specialistTeamList != null){
			for(int i=0; i < specialistTeamList.size(); i++){
				specialMix = new SpecialMix();
				specialMix = specialMixList.get(i);
				result = result + specialMix.toString();
				if(i+1 != specialMixList.size()){
					result = result + ",";
				}
			}
		}
		result = result + "]}";
		if(result.equals("{}")){
			result = "\"{}\"";
			data.setRetCode(400);
			data.setRetDesc("fail");
			logger.error("main page error!!!!!!!!!!!!");
		}else {
			data.setRetCode(200);
			data.setRetDesc("success");
			logger.debug("main page success~~~~~~~~~~~~");
		}
		
		data.setData(result);
		
		byte[] encryptResult = AES256.encrypt(data.getAll());  
		String encryptResultStr = AES256.parseByte2HexStr(encryptResult);          
		rj.setJson(encryptResultStr);
		
		return rj;   
    }
}
