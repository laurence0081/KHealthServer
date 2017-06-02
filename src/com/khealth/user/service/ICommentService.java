package com.khealth.user.service;

import java.util.List;

import com.khealth.user.pojo.Comment;

public interface ICommentService {

	public int addComment(Comment comment);
		
	public int removeCommentById(int id);

	public int modifyComment(Comment comment);

	public Comment getCommentById(int id);
	
	public List<Comment> getCommentByTargetId(String targetId);
	
	public List<Comment> getTopCommentByTargetId(String targetId, int num);	
}
