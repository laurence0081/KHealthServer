package com.khealth.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khealth.user.dao.IOrderDao;
import com.khealth.user.pojo.Order;
import com.khealth.user.service.IOrderService;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {
	@Resource
	private IOrderDao orderDao;

	public int addOrder(Order order){
		return orderDao.insert(order);
	}
	
	public int removeOrderById(int id){
		return orderDao.deleteById(id);
	}

	public int modifyOrder(Order order){
		return orderDao.update(order);
	}

	public Order getOrderById(int id){
		return orderDao.selectById(id);
	}
    
	public List<Order> getOrderByUserId(int userId){
		return orderDao.selectByUserId(userId);
	}
    
	public List<Order> getOrderByDoctorId(int doctorId){
		return orderDao.selectByDoctorId(doctorId);
	}
    
	public List<Order> getOrderByAppointmentDate(String appoinmentDate){
		return orderDao.selectByAppointmentDate(appoinmentDate);
	}
    
	public List<Order> getOrderByParaId(Order order){
		return orderDao.selectByParaId(order);
	}
}
