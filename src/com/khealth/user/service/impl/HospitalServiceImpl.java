package com.khealth.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khealth.user.dao.IHospitalDao;
import com.khealth.user.pojo.Hospital;
import com.khealth.user.service.IHospitalService;

@Service("hostipalService")
public class HospitalServiceImpl implements IHospitalService {
	@Resource
	private IHospitalDao hospitalDao;

	public int addHospital(Hospital hospital){
		return hospitalDao.insert(hospital);
	}
	
	public int removeHospitalById(int id){
		return hospitalDao.deleteById(id);
	}

	public int modifyHospital(Hospital hospital){
		return hospitalDao.update(hospital);
	}

	public Hospital getHospitalById(int id){
		return hospitalDao.selectById(id);
	}
    
	public List<Hospital> getHospitalByCityId(Hospital hospital){
		return hospitalDao.selectByCityId(hospital);
	}
}
