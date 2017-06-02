package com.khealth.user.dao;

import java.util.List;

import com.khealth.user.pojo.Notice;

public interface INoticeDao {

    int insert(Notice notice);
	
	int deleteById(int id);

    int update(Notice notice);

    Notice selectById(int id);
    
	Notice selectTop();

	List<Notice> selectByPage(Notice notice);
}
