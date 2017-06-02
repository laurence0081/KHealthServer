package com.khealth.user.dao;

import java.util.List;

import com.khealth.user.pojo.Order;

public interface IOrderDao {

    int insert(Order order);
	
	int deleteById(int id);

    int update(Order order);

    Order selectById(int id);
    
    List<Order> selectByUserId(int userId);
    
    List<Order> selectByDoctorId(int doctorId);
    
    List<Order> selectByAppointmentDate(String appoinmentDate);
    
    List<Order> selectByParaId(Order order);
}
