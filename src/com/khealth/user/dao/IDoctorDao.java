package com.khealth.user.dao;

import java.util.List;

import com.khealth.user.pojo.Doctor;

public interface IDoctorDao {

    int insert(Doctor doctor);
	
	int deleteById(Integer id);

    int update(Doctor doctor);

    Doctor selectById(Integer id);
    
    Doctor selectByCellphonePWD(String cellphone, String password);
    
    List<Doctor> selectByPage(Doctor doctor);
    
    List<Doctor> selectRankByPage(Doctor doctor);
    
    List<Doctor> selectByStatus(int status);
    
    List<Doctor> selectByParaByPage(Doctor doctor);
}
