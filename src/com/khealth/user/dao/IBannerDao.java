package com.khealth.user.dao;

import java.util.List;

import com.khealth.user.pojo.Banner;

public interface IBannerDao {

    int insert(Banner banner);
	
	int deleteById(Integer id);

    int update(Banner banner);

    Banner selectById(Integer id);
    
    List<Banner> selectByType(int type);
}
