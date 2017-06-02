package com.khealth.user.service;

import java.util.List;

import com.khealth.user.pojo.Notice;

public interface INoticeService {

    public int addNotice(Notice notice);
	
	public int removeNoticeById(int id);

    public int modifyNotice(Notice notice);

    public Notice getNoticeById(int id);
    
	public Notice getTopNotice();

	public List<Notice> getNoticeByPage(Notice notice);
}
