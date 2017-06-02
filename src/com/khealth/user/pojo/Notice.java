package com.khealth.user.pojo;

import com.khealth.user.util.AES256;
import com.khealth.user.util.PageParameter;

public class Notice{
	public Integer id;
	public String content;
	public String pDate; // 发布日期
	public Integer type; // 0-系统 1-贴士
	public Integer status; // 0-过期 1-通过审核
	
	public PageParameter page;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getpDate() {
		return pDate;
	}
	public void setpDate(String pDate) {
		this.pDate = pDate;
	}
	public PageParameter getPage() {
		return page;
	}
	public void setPage(PageParameter page) {
		this.page = page;
	}
	
	public String toString(){
		String result ="";		

		String articleStr = "";
		if(content!= null & !content.equals(""))  articleStr = AES256.parseByte2HexStr(AES256.encrypt(content));
		result = "{\"id\":\""+id+"\", \"content\":\""+articleStr+"\",\"type\":\""+type+"\","
				+ "\"status\":\""+status+"\", \"pDate\":\""+pDate+"\"}";
		
		return result;
	}
}
