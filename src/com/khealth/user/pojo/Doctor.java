package com.khealth.user.pojo;

import com.khealth.user.util.AES256;
import com.khealth.user.util.PageParameter;

public class Doctor {
	Integer id;
	String name;
	String cellphone;
	String password;
	String imgURL;
	String department; //数据库冗余存储
	String jobTitle; //数据库不存储
	String hospital; //数据库冗余存储
	String selfDesc;
	String skillDesc;
	String patientDesc;
	Integer serviceNum;
	Integer presentNum;
	Integer fanNum;
	Integer commentNum;
	//0-不出诊 1-出诊 2-置顶
	Integer status;
	Integer hospitalId;
	Integer departmentId;
	Integer jobId; //1-科室主任， 2-科室主任，3-主任医师，4-副主任医师，5-主治医师，6-副主治医师
	String appointmentAddr;
	String HXname;
	String HXpwd;
	Integer rank; // 优先排序 0-无 1-推荐
	Float point; // 评分 0-10
	
	public PageParameter page;
	
	public PageParameter getPage() {
		return page;
	}
	public void setPage(PageParameter page) {
		this.page = page;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPatientDesc() {
		return patientDesc;
	}
	public void setPatientDesc(String patientDesc) {
		this.patientDesc = patientDesc;
	}
	public Integer getServiceNum() {
		return serviceNum;
	}
	public void setServiceNum(Integer serviceNum) {
		this.serviceNum = serviceNum;
	}
	public Integer getPresentNum() {
		return presentNum;
	}
	public void setPresentNum(Integer presentNum) {
		this.presentNum = presentNum;
	}
	public Integer getFanNum() {
		return fanNum;
	}
	public void setFanNum(Integer fanNum) {
		this.fanNum = fanNum;
	}
	public Integer getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
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
	public String getSelfDesc() {
		return selfDesc;
	}
	public void setSelfDesc(String selfDesc) {
		this.selfDesc = selfDesc;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getAppointmentAddr() {
		return appointmentAddr;
	}
	public void setAppointmentAddr(String appointmentAddr) {
		this.appointmentAddr = appointmentAddr;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
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
	public String toString(){
		String result ="";
		String replaceStr1 = "";
		if(selfDesc!= null && !selfDesc.equals(""))  replaceStr1 = AES256.parseByte2HexStr(AES256.encrypt(selfDesc));
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
		
		result = "{\"id\":\""+id+"\", \"name\":\""+name+"\", \"cellphone\":\""+cellphone+"\", \"jobTitle\":\""+jobTitle+"\","
				+ "\"serviceNum\":\""+serviceNum+"\",\"hospital\":\""+hospital+"\", \"appointmentAddr\":\""+appointmentAddr+ "\","
				+ "\"selfDesc\":\""+replaceStr1+"\",\"skillDesc\":\""+skillDesc+"\",\"presentNum\":\""+presentNum+"\","
				+ "\"department\":\""+department+"\",\"hospitalId\":\""+hospitalId+"\",\"departmentId\":\""+departmentId+ "\","
				+ "\"imgURL\":\""+imgURL+"\", \"status\":\""+status+"\", \"commentNum\":\""+commentNum+"\", \"fanNum\":\""+fanNum+"\", "
				+ "\"patientDesc\":\""+patientDesc+"\", \"HXname\":\""+HXname+"\", \"HXpwd\":\""+HXpwd+"\", \"rank\":\""+rank+"\", \"point\":\""+point+ "\"}";
		
		return result;
	}
	
	public String toShortString(){
		String result ="";
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
		
		result = "{\"id\":\""+id+"\", \"name\":\""+name+"\", \"jobTitle\":\""+jobTitle+"\","
				+ "\"department\":\""+department+"\", \"imgURL\":\""+imgURL + "\"}";
		
		return result;
	}
}
