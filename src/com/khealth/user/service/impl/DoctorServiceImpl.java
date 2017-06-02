package com.khealth.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khealth.user.dao.IDoctorDao;
import com.khealth.user.pojo.Doctor;
import com.khealth.user.service.IDoctorService;

@Service("doctorService")
public class DoctorServiceImpl implements IDoctorService {
	@Resource
	private IDoctorDao doctorDao;
	
	private int result = 0;
	
	public int addDoctor(Doctor doctor){
		result = this.doctorDao.insert(doctor);
		return result;
	}
	
	public int removeDoctorByID(int id){
		result = this.doctorDao.deleteById(id);
		return result;
	}
   
	public int modifyDoctor(Doctor doctor){
		result = this.doctorDao.update(doctor);
		return result;
	}
	
	public Doctor getDoctorById(int userId){
		return this.doctorDao.selectById(userId);
	}
	
	public Doctor getDoctorByCellphonePWD(String cellphone, String password){
		return doctorDao.selectByCellphonePWD(cellphone, password);
	}
	
	public List<Doctor> getDoctorByStatus(int status){
		return doctorDao.selectByStatus(status);
	}
	
	public List<Doctor> getDoctorByParaByPage(Doctor doctor){
		return doctorDao.selectByParaByPage(doctor);
	}
    
	public List<Doctor> getDoctorByPage(Doctor doctor){
		return doctorDao.selectByPage(doctor);
	}
    
	public List<Doctor> getRankDoctorByPage(Doctor doctor){
		return doctorDao.selectRankByPage(doctor);
	}
}
