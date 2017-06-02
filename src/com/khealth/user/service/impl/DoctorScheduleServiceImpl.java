package com.khealth.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khealth.user.dao.IDoctorScheduleDao;
import com.khealth.user.pojo.DoctorSchedule;
import com.khealth.user.service.IDoctorScheduleService;

@Service("doctorScheduleService")
public class DoctorScheduleServiceImpl implements IDoctorScheduleService {
	@Resource
	private IDoctorScheduleDao doctorScheduleDao;

	public int addDoctorSchedule(DoctorSchedule doctorSchedule){
		return doctorScheduleDao.insert(doctorSchedule);
	}
	
	public int removeDoctorScheduleByID(int id){
		return doctorScheduleDao.deleteById(id);
	}

	public int modifyDoctorSchedule(DoctorSchedule doctorSchedule){
		return doctorScheduleDao.update(doctorSchedule);
	}
    
	public int modifyDoctorScheduleAppointmentTime(DoctorSchedule doctorSchedule){
		return doctorScheduleDao.updateAppointmentTime(doctorSchedule);
	}

	public List<DoctorSchedule> getDoctorScheduleByID(int doctorId){
		return doctorScheduleDao.selectById(doctorId);
	}
    
	public DoctorSchedule getDoctorScheduleByDoctorIdApTime(int doctorId, String appointmentTime){
		return doctorScheduleDao.selectByDoctorIdApTime(doctorId, appointmentTime);
	}
}
