package com.khealth.user.service;

import java.util.List;

import com.khealth.user.pojo.DoctorSchedule;

public interface IDoctorScheduleService {

	public int addDoctorSchedule(DoctorSchedule doctorSchedule);
	
	public int removeDoctorScheduleByID(int id);

	public int modifyDoctorSchedule(DoctorSchedule doctorSchedule);
    
	public int modifyDoctorScheduleAppointmentTime(DoctorSchedule doctorSchedule);

	public List<DoctorSchedule> getDoctorScheduleByID(int doctorId);
    
	public DoctorSchedule getDoctorScheduleByDoctorIdApTime(int doctorId, String appointmentTime);
}
