package com.khealth.user.pojo;

import com.khealth.user.util.PageParameter;

public class City {
	Integer id;
	String name;
	Integer parentid;
	String shortname;
	Integer leveltype;
	String citycode;
	String zipcode;
	String lng;
	String lat;
	String pinyin;
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

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public Integer getLeveltype() {
		return leveltype;
	}

	public void setLeveltype(Integer leveltype) {
		this.leveltype = leveltype;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String toString(){
		String result ="";
		
		result = "{\"id\":\""+id+"\", \"name\":\""+name+"\", \"parentid\":\""+parentid+"\", \"shortname\":\""+shortname+"\","
				+ "\"leveltype\":\""+leveltype+"\", \"citycode\":\""+citycode+"\", \"zipcode\":\""+zipcode+"\","
				+ "\"lng\":\""+lng+"\", \"lat\":\""+lat+"\", \"pinyin\":\""+pinyin+"\", \"status\":\""+status+"\"}";
		
		return result;
	}
}
