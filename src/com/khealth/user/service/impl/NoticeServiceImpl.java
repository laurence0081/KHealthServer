package com.khealth.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khealth.user.dao.INoticeDao;
import com.khealth.user.pojo.Notice;
import com.khealth.user.service.INoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements INoticeService {
	@Resource
	private INoticeDao noticeDao;

    public int addNotice(Notice notice){
    	return noticeDao.insert(notice);
    }
	
	public int removeNoticeById(int id){
		return noticeDao.deleteById(id);
	}

    public int modifyNotice(Notice notice){
    	return noticeDao.update(notice);
    }

    public Notice getNoticeById(int id){
    	return noticeDao.selectById(id);
    }
    
	public Notice getTopNotice(){
		return noticeDao.selectTop();
	}

	public List<Notice> getNoticeByPage(Notice notice){
		return noticeDao.selectByPage(notice);
	}
}
