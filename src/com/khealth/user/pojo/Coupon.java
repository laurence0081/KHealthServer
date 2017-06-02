package com.khealth.user.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.khealth.user.util.PageParameter;

public class Coupon {
	Integer id;
	String name;
	Double amount;
	Integer type;
	String imgURL;
	String time;
	String beginTime;
	String endTime;
	Integer status;
	
	public PageParameter page;
	
	public Coupon(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time = df.format(new Date());
	}
	
	public PageParameter getPage() {
		return page;
	}

	public void setPage(PageParameter page) {
		this.page = page;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String toString(){
		String result ="";
		
		result = "{\"id\":\""+id+"\", \"name\":\""+name+"\", \"amount\":\""+amount+"\", \"type\":\""+type+"\","
				+ "\"imgURL\":\""+imgURL+"\", \"time\":\""+time+"\", \"beginTime\":\""+beginTime+"\","
				+ "\"endTime\":\""+endTime+"\", \"status\":\""+status+"\"}";
		
		return result;
	}
}
