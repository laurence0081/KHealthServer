package com.khealth.user.pojo;

import com.khealth.user.util.AES256;
import com.khealth.user.util.PageParameter;

public class Comment {
	Integer id;
	String targetId; //被回复的载体，如：文章
	Integer userId;
	Integer commentedId; //被回复的评论ID
	String content;
	String time;
	String username; //评论人的信息
	String imgURL;
	String commentedName; //被回复人的名字

	public PageParameter page;
	
	public String getCommentedName() {
		return commentedName;
	}
	public void setCommentedName(String commentedName) {
		this.commentedName = commentedName;
	}
	public Integer getCommentedId() {
		return commentedId;
	}
	public void setCommentedId(Integer commentedId) {
		this.commentedId = commentedId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public PageParameter getPage() {
		return page;
	}
	public void setPage(PageParameter page) {
		this.page = page;
	}
	
	public String toStringNew(){
		String result ="";
		String articleStr = "";
		if(content!= null & !content.equals(""))  articleStr = AES256.parseByte2HexStr(AES256.encrypt(content));

		result = "{\"id\":\""+id+"\", \"targetid\":\""+targetId+"\",\"userid\":\""+userId+"\",\"content\":\""+articleStr+ "\","
				+ "\"time\":\""+time+ "\","+ "\"username\":\""+username+ "\","+ "\"imgURL\":\""+imgURL+ "\","
				+ "\"commentedName\":\""+commentedName+ "\","+ "\"commentedId\":\""+commentedId+"\"}";
		
		return result;
	}
}
