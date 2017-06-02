package com.khealth.user.pojo;

import com.khealth.user.util.PageParameter;

public class DoctorSchedule {
	Integer id;
	Integer doctorId;
	String appointmentDate;
	String appointmentTime;
	Integer type;

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

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String toString(){
		String result ="";
		
		result = "{\"id\":\""+id+"\", \"doctorId\":\""+doctorId+"\", \"appointmentDate\":\""+appointmentDate+"\", "
				+ "\"type\":\""+type+"\", \"appointmentTime\":\""+appointmentTime+"\"}";
		
		return result;
	}
}
