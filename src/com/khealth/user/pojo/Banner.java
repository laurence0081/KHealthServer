package com.khealth.user.pojo;

import com.khealth.user.util.PageParameter;

public class Banner {
	//0-主页名医图片
	Integer id;
	String name;
	String imgURL;
	//1-主页顶部  2-主页医生团队  3-主页医生
	Integer type;
	Integer status;
	
	public PageParameter page;
	
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
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String toString(){
		String result ="";
		
		result = "{\"id\":\""+id+"\", \"name\":\""+name+ "\"imgURL\":\""+imgURL+"\", \"status\":\""+status+ "\"}";
		
		return result;
	}
}
