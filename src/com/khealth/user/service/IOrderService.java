package com.khealth.user.service;

import java.util.List;

import com.khealth.user.pojo.Order;

public interface IOrderService {

	public int addOrder(Order order);
	
	public int removeOrderById(int id);

	public int modifyOrder(Order order);

	public Order getOrderById(int id);
    
	public List<Order> getOrderByUserId(int userId);
    
	public List<Order> getOrderByDoctorId(int doctorId);
    
	public List<Order> getOrderByAppointmentDate(String appoinmentDate);
    
	public List<Order> getOrderByParaId(Order order);
}
