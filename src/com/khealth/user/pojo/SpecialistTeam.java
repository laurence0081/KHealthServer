package com.khealth.user.pojo;

import com.khealth.user.util.AES256;
import com.khealth.user.util.PageParameter;

public class SpecialistTeam {
	Integer id;
	String name;
	String imgURL;
	String skillDesc;
	String description;
	String doctorIds;
	Integer coin;
	Double money;
	String owernId;
	String adminIds;
	String hospitalIds;
	String departmentIds;
	Integer jobId; 
	String appointmentAddr;
	Integer rank; // 优先排序 0-无 1-推荐
	Float point; // 评分 0-10
	//0-不出诊 1-出诊 2-置顶
	Integer status;
	String department; //数据库冗余存储
	String jobTitle; //数据库不存储
	String hospital; //数据库冗余存储
	
	public PageParameter page;
	
	public Integer getCoin() {
		return coin;
	}
	public void setCoin(Integer coin) {
		this.coin = coin;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getOwernId() {
		return owernId;
	}
	public void setOwernId(String owernId) {
		this.owernId = owernId;
	}
	public String getAdminIds() {
		return adminIds;
	}
	public void setAdminIds(String adminIds) {
		this.adminIds = adminIds;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public String getSkillDesc() {
		return skillDesc;
	}
	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}
	public String getDoctorIds() {
		return doctorIds;
	}
	public void setDoctorIds(String doctorIds) {
		this.doctorIds = doctorIds;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHospitalIds() {
		return hospitalIds;
	}
	public void setHospitalIds(String hospitalIds) {
		this.hospitalIds = hospitalIds;
	}
	public String getDepartmentIds() {
		return departmentIds;
	}
	public void setDepartmentIds(String departmentIds) {
		this.departmentIds = departmentIds;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public String getAppointmentAddr() {
		return appointmentAddr;
	}
	public void setAppointmentAddr(String appointmentAddr) {
		this.appointmentAddr = appointmentAddr;
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
	public PageParameter getPage() {
		return page;
	}
	public void setPage(PageParameter page) {
		this.page = page;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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
	public String toString(){
		String result ="";
		String replaceStr = "";
		if(description!= null & !description.equals(""))  replaceStr = AES256.parseByte2HexStr(AES256.encrypt(description));
		//1-科室主任， 2-科室副主任，3-主任医师，4-副主任医师，5-主治医师，6-副主治医师
		switch(jobId){
		case 1:
			jobTitle = "科室主任";
			break;
		case 2:
			jobTitle = "科室副主任";
			break;
		case 3:
			jobTitle = "主任医师";
			break;
		case 4:
			jobTitle = "副主任医师";
			break;
		case 5:
			jobTitle = "主治医师";
			break;
		case 6:
			jobTitle = "副主治医师";
			break;
		}
		result = "{\"id\":\""+id+"\", \"name\":\""+name+"\", \"imgURL\":\""+imgURL+"\", \"hospitalIds\":\""+hospitalIds+"\", \"status\":\""+status+"\","
				+ "\"description\":\""+replaceStr+"\", \"skillDesc\":\""+skillDesc+"\", \"departmentIds\":\""+departmentIds+"\","
				+ "\"doctorIds\":\""+doctorIds+"\", \"coin\":\""+coin+"\", \"jobId\":\""+jobId+"\", \"appointmentAddr\":\""+appointmentAddr+"\", "
				+ "\"money\":\""+money+"\", \"owernId\":\""+owernId+"\", \"adminIds\":\""+adminIds+"\", \"rank\":\""+rank+"\", \"point\":\""+point+"\", "
				+ "\"department\":\""+department+"\", \"jobTitle\":\""+jobTitle+"\", \"hospital\":\""+hospital+"\"}";
		
		return result;
	}
}
