package com.khealth.user.pojo;

import com.khealth.user.util.PageParameter;

public class Hospital {
	Integer id;
	String name;
	Integer cityId;
	Integer type;
	String mark;

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

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String toString(){
		String result ="";
		
		result = "{\"id\":\""+id+"\", \"name\":\""+name+"\", \"cityId\":\""+cityId+"\", \"type\":\""+type+"\", \"mark\":\""+mark+"\"}";
		
		return result;
	}
}
