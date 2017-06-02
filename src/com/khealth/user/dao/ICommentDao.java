package com.khealth.user.dao;

import java.util.List;

import com.khealth.user.pojo.Comment;

public interface ICommentDao {
	
	int deleteById(int id);

    int insert(Comment comment);

    int update(Comment comment);

    Comment selectById(int id);
    
	List<Comment> selectByTargetId(String targetId);

	List<Comment> selectTopByTargetId(String targetId, int num);
}
