package com.khealth.user.service;

import java.util.List;

import com.khealth.user.pojo.Doctor;

public interface IDoctorService {
	
	public int addDoctor(Doctor doctor);
	
	public int removeDoctorByID(int id);
   
	public int modifyDoctor(Doctor doctor);	
	
	public Doctor getDoctorById(int id);
    
	public Doctor getDoctorByCellphonePWD(String cellphone, String password);
	
	public List<Doctor> getDoctorByStatus(int status);
	
	public List<Doctor> getDoctorByParaByPage(Doctor doctor);
    
    List<Doctor> getDoctorByPage(Doctor doctor);
    
    List<Doctor> getRankDoctorByPage(Doctor doctor);
}
