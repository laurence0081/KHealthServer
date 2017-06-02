package com.khealth.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khealth.user.dao.ICommentDao;
import com.khealth.user.pojo.Comment;
import com.khealth.user.service.ICommentService;

@Service("commentService")
public class CommentServiceImpl implements ICommentService {
	@Resource
	private ICommentDao commentDao;

	public int addComment(Comment comment) {
		return commentDao.insert(comment);
	}

	public int removeCommentById(int id) {
		return commentDao.deleteById(id);
	}

	public int modifyComment(Comment comment) {
		return commentDao.update(comment);
	}

	public Comment getCommentById(int id) {
		return commentDao.selectById(id);
	}

	public List<Comment> getCommentByTargetId(String targetId){
		return commentDao.selectByTargetId(targetId);
	}
	
	public List<Comment> getTopCommentByTargetId(String targetId, int num){
		return commentDao.selectTopByTargetId(targetId, num);
	}
		
	public void setCommentDao(ICommentDao commentDao) {
		this.commentDao = commentDao;
	}

	public ICommentDao getAdviseDao() {
		return commentDao;
	}
}
