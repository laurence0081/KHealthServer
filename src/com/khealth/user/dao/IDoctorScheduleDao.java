package com.khealth.user.dao;

import java.util.List;

import com.khealth.user.pojo.DoctorSchedule;

public interface IDoctorScheduleDao {

    int insert(DoctorSchedule doctorSchedule);
	
	int deleteById(int id);

    int update(DoctorSchedule doctorSchedule);
    
    int updateAppointmentTime(DoctorSchedule doctorSchedule);

    List<DoctorSchedule> selectById(int doctorId);
    
    DoctorSchedule selectByDoctorIdApTime(int doctorId, String appointmentTime);
}
