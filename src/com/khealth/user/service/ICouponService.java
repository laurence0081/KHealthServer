package com.khealth.user.service;

import java.util.List;

import com.khealth.user.pojo.Coupon;

public interface ICouponService {

    public int addCoupon(Coupon coupon);
	
    public int removeCouponById(int id);

    public int modifyCoupon(Coupon coupon);

    public Coupon getCouponById(int id);
    
    public List<Coupon> getCouponsByPage(Coupon coupon);

    public List<Coupon> getCouponByTypeByPage(Coupon coupon);
}
