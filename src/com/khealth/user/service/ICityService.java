package com.khealth.user.service;

import java.util.List;

import com.khealth.user.pojo.City;

public interface ICityService {

	public int addCity(City city);
	
	public int removeCityById(int id);

	public int modifyCity(City city);

	public City getCityById(int id);
    
	public List<City> getProvinces();

	public List<City> getCitys(int parentid);

	public List<City> getDistrictions(int parentid);
}
