package com.khealth.user.pojo;

import com.khealth.user.util.PageParameter;

public class Order {
	Integer id;
	Integer doctorId;
	Integer userId;
	String appointmentDate;
	Integer appointmentTime;
	String appointmentPlace; 
	Integer type; 
	Integer price;
	Integer status;
	String comment;
	
	public PageParameter page;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Integer getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Integer appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getAppointmentPlace() {
		return appointmentPlace;
	}

	public void setAppointmentPlace(String appointmentPlace) {
		this.appointmentPlace = appointmentPlace;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public PageParameter getPage() {
		return page;
	}

	public void setPage(PageParameter page) {
		this.page = page;
	}

	public String toString(){
		String result = "";
		result = "{\"id\":\""+id+"\", \"doctorId\":\""+doctorId+"\", \"userId\":\""+userId+"\", \"appointmentDate\":\""+appointmentDate+"\","
				+ "\"appointmentTime\":\""+appointmentTime+"\",\"appointmentPlace\":\""+appointmentPlace+"\",\"type\":\""+type+ "\","
				+ "\"price\":\""+price+"\", \"status\":\""+status+"\", \"comment\":\""+comment+ "\"}";
		
		return result;
	}
}
