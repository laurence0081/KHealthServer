package com.khealth.user.service;

import java.util.List;

import com.khealth.user.pojo.Hospital;

public interface IHospitalService {

	public int addHospital(Hospital hospital);
	
	public int removeHospitalById(int id);

	public int modifyHospital(Hospital hospital);

	public Hospital getHospitalById(int id);
    
	public List<Hospital> getHospitalByCityId(Hospital hospital);
}
