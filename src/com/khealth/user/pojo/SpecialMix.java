package com.khealth.user.pojo;

public class SpecialMix {
	Integer id;
	String name;
	String imgURL;
	String department; 
	String jobTitle; 
	String hospital;
	String skillDesc;
	Integer rank; 
	Float point; // 评分 0-10
	Integer type;
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getSkillDesc() {
		return skillDesc;
	}
	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Float getPoint() {
		return point;
	}
	public void setPoint(Float point) {
		this.point = point;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String toString(){
		String result ="";
		
		result = "{\"id\":\""+id+"\", \"name\":\""+name+"\", \"jobTitle\":\""+jobTitle+"\","
				+ "\",\"hospital\":\""+hospital+ "\","
				+"\",\"skillDesc\":\""+skillDesc+"\","
				+ "\"department\":\""+department+"\", \"type\":\""+type+ "\","
				+ "\"imgURL\":\""+imgURL +"\", "
				+ "\", \"rank\":\""+rank+"\", \"point\":\""+point+ "\"}";
		
		return result;
	}
}
