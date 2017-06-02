package com.khealth.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khealth.user.dao.ICityDao;
import com.khealth.user.pojo.City;
import com.khealth.user.service.ICityService;

@Service("cityService")
public class CityServiceImpl implements ICityService {
	@Resource
	private ICityDao cityDao;

	public int addCity(City city){
		return cityDao.insert(city);
	}
	
	public int removeCityById(int id){
		return cityDao.deleteById(id);
	}

	public int modifyCity(City city){
		return cityDao.update(city);
	}

	public City getCityById(int id){
		return cityDao.selectById(id);
	}
    
	public List<City> getProvinces(){
		return cityDao.selectProvinces();
	}

	public List<City> getCitys(int parentid){
		return cityDao.selectCitys(parentid);
	}

	public List<City> getDistrictions(int parentid){
		return cityDao.selectDistrictions(parentid);
	}
}
