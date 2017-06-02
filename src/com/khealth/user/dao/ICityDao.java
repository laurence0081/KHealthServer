package com.khealth.user.dao;

import java.util.List;

import com.khealth.user.pojo.City;

public interface ICityDao {

    int insert(City city);
	
	int deleteById(int id);

    int update(City city);

    City selectById(int id);
    
	List<City> selectProvinces();

	List<City> selectCitys(int parentid);

	List<City> selectDistrictions(int parentid);
}
