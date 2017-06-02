package com.khealth.user.dao;

import java.util.List;

import com.khealth.user.pojo.Hospital;

public interface IHospitalDao {

    int insert(Hospital hospital);
	
	int deleteById(int id);

    int update(Hospital hospital);

    Hospital selectById(int id);
    
    List<Hospital> selectByCityId(Hospital hospital);
}
