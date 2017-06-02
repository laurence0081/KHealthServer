package com.khealth.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khealth.user.dao.ICouponDao;
import com.khealth.user.pojo.Coupon;
import com.khealth.user.service.ICouponService;

@Service("couponService")
public class CouponServiceImpl implements ICouponService {
	@Resource
	private ICouponDao couponDao;

	public int addCoupon(Coupon coupon){
    	return couponDao.insert(coupon);
    }
	
	public int removeCouponById(int id){
		return couponDao.deleteById(id);
	}

	public int modifyCoupon(Coupon coupon){
		return couponDao.update(coupon);
	}

	public Coupon getCouponById(int id){
		return couponDao.selectById(id);
	}
    
	public List<Coupon> getCouponsByPage(Coupon coupon){
		return couponDao.selectAllByPage(coupon);
	}

	public List<Coupon> getCouponByTypeByPage(Coupon coupon){
		return couponDao.selectByTypeByPage(coupon);
	}
}
