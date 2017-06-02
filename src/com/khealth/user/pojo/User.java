package com.khealth.user.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.khealth.user.util.PageParameter;

public class User {
	Integer id;
	String username;
	String password;
	String nickname;
	String imgURL;
	String birthday;
	Integer sex;
	String cellphone;
	Integer coin;
	Integer age;
	Double money;
	Integer couponNum;
	String couponIds;
	String email;
	Integer favNum;	
	Integer commentNum;	
	Integer articleNum;	
	String regTime;
	
	String HXname;
	String HXpwd;
	
	public PageParameter page;

	public User(){
		nickname = "未设置";
		imgURL = "http://101.201.43.202:20161/default.jpg";
		birthday = "2016-10-01";
		sex = 0;
		cellphone = "未设置";
		coin = 0;
		age = 20;
		money = 0.0;
		couponNum = 0;
		couponIds = "";
		email = "未设置";
		favNum = 0;	
		commentNum = 0;	
		articleNum = 0;	
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		regTime = df.format(new Date());// new Date()为获取当前系统时间
	}
	
	public Integer getCouponNum() {
		return couponNum;
	}

	public void setCouponNum(Integer couponNum) {
		this.couponNum = couponNum;
	}

	public String getCouponIds() {
		return couponIds;
	}

	public void setCouponIds(String couponIds) {
		this.couponIds = couponIds;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public Integer getArticleNum() {
		return articleNum;
	}

	public void setArticleNum(Integer articleNum) {
		this.articleNum = articleNum;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Integer getCoin() {
		return coin;
	}

	public void setCoin(Integer coin) {
		this.coin = coin;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getFavNum() {
		return favNum;
	}

	public void setFavNum(Integer favNum) {
		this.favNum = favNum;
	}

	public PageParameter getPage() {
		return page;
	}

	public void setPage(PageParameter page) {
		this.page = page;
	}

	public String getHXname() {
		return HXname;
	}

	public void setHXname(String hXname) {
		HXname = hXname;
	}

	public String getHXpwd() {
		return HXpwd;
	}

	public void setHXpwd(String hXpwd) {
		HXpwd = hXpwd;
	}

	public String toString(){
		String sexStr = "女";
		if(sex == 1) sexStr = "男";
		String result ="";
		
		result = "{\"id\":\""+id+"\", \"username\":\""+username+"\",\"nickname\":\""+nickname+ "\","
				+ "\"imgURL\":\""+imgURL+"\", \"cellphone\":\""+cellphone+"\",\"birthday\":\""+birthday+"\",\"age\":\"" +age+"\","
				+ "\"sex\":\""+sexStr+"\", \"money\":\""+money+"\", \"regTime\":\""+regTime+"\",\"email\":\""+email+"\","       
				+ "\"coin\":\""+coin+" \", \"favNum\":\""+favNum+" \", \"couponNum\":\""+couponNum+" \", \"couponIds\":\""+couponIds+"\","
				+ "\"commentNum\":\""+commentNum+"\", \"articleNum\":\""+articleNum+"\", \"HXname\":\""+HXname+"\", \"HXpwd\":\""+HXpwd+"\"}";
		
		return result;
	}
}
