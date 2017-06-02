package com.khealth.user.dao;

import java.util.List;

import com.khealth.user.pojo.Coupon;

public interface ICouponDao {
	
	int deleteById(int id);

    int insert(Coupon coupon);

    int update(Coupon coupon);

    Coupon selectById(int id);
    
	List<Coupon> selectAllByPage(Coupon coupon);

	List<Coupon> selectByTypeByPage(Coupon coupon);
}
