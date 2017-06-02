package com.khealth.user.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.khealth.user.util.PageParameter;

public class Favorite {
	Integer id;
	Integer userId;
	String favId;
	String favTitle;
	String time;
	
	public PageParameter page;
	
	public Favorite(){
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFavId() {
		return favId;
	}
	public void setFavId(String favId) {
		this.favId = favId;
	}
	public String getFavTitle() {
		return favTitle;
	}
	public void setFavTitle(String favTitle) {
		this.favTitle = favTitle;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String toString(){
		String result ="";
		
		result = "{\"id\":\""+id+"\", \"userid\":\""+userId+"\","
				+ "\"favId\":\""+favId+"\", \"favTitle\":\""+favTitle+"\","
				+ "\"time\":\""+time+"\"}";
		
		return result;
	}
}
