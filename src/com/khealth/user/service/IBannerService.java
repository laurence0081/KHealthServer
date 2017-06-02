package com.khealth.user.service;

import java.util.List;

import com.khealth.user.pojo.Banner;

public interface IBannerService {

    public int addBanner(Banner banner);
	
    public int deleteBannerById(int id);

    public int updateBanner(Banner banner);
    
    public Banner getBannerById(int id);
    
    public List<Banner> getBannerByType(int type);
}
