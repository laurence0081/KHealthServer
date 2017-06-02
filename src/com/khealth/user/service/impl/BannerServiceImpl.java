package com.khealth.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khealth.user.dao.IBannerDao;
import com.khealth.user.pojo.Banner;
import com.khealth.user.service.IBannerService;

@Service("doctorService")
public class BannerServiceImpl implements IBannerService {
	@Resource
	private IBannerDao bannerDao;
	
	private int result = 0;
	
	public int addBanner(Banner banner){
		result = this.bannerDao.insert(banner);
		return result;
	}
	
	public int deleteBannerById(int id){
		result = this.bannerDao.deleteById(id);
		return result;
	}
   
	public int updateBanner(Banner banner){
		result = this.bannerDao.update(banner);
		return result;
	}
	
	public Banner getBannerById(int bannerId){
		return this.bannerDao.selectById(bannerId);
	}
	
	public List<Banner> getBannerByType(int type){
		return bannerDao.selectByType(type);
	}
}
