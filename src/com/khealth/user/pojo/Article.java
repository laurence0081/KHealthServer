package com.khealth.user.pojo;

import com.khealth.user.util.AES256;
import com.khealth.user.util.PageParameter;

public class Article{
	public Integer id;
	public String articleName;
	public String articleTime;
	public String articleWriter;
	public String articleFrom;
	public String articleContent = "";
	public Integer articleGroup; // 1-置顶
	public Integer articleType; // 0-文章 1-讲堂 2-论坛
	public Integer status; // 1-通过审核
	public Integer replyNum;
	public Integer favNum;
	public Integer shareNum;
	public Integer clickNum;
	public Integer praiseNum;
	public String articleDesc;
	public String articleImg;
	public PageParameter page;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public String getArticleTime() {
		return articleTime;
	}
	public void setArticleTime(String articleTime) {
		this.articleTime = articleTime;
	}
	public String getArticleWriter() {
		return articleWriter;
	}
	public void setArticleWriter(String articleWriter) {
		this.articleWriter = articleWriter;
	}
	public String getArticleFrom() {
		return articleFrom;
	}
	public void setArticleFrom(String articleFrom) {
		this.articleFrom = articleFrom;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public Integer getArticleGroup() {
		return articleGroup;
	}
	public void setArticleGroup(Integer articleGroup) {
		this.articleGroup = articleGroup;
	}
	public Integer getArticleType() {
		return articleType;
	}
	public void setArticleType(Integer articleType) {
		this.articleType = articleType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(Integer replyNum) {
		this.replyNum = replyNum;
	}
	public Integer getFavNum() {
		return favNum;
	}
	public void setFavNum(Integer favNum) {
		this.favNum = favNum;
	}
	public Integer getShareNum() {
		return shareNum;
	}
	public void setShareNum(Integer shareNum) {
		this.shareNum = shareNum;
	}
	public Integer getClickNum() {
		return clickNum;
	}
	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}
	public Integer getPraiseNum() {
		return praiseNum;
	}
	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}
	public String getArticleDesc() {
		return articleDesc;
	}
	public void setArticleDesc(String articleDesc) {
		this.articleDesc = articleDesc;
	}
	public String getArticleImg() {
		return articleImg;
	}
	public void setArticleImg(String articleImg) {
		this.articleImg = articleImg;
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
		if(articleContent!= null & !articleContent.equals(""))  articleStr = AES256.parseByte2HexStr(AES256.encrypt(articleContent));
		
		result = "{\"id\":\""+id+"\", \"articlename\":\""+articleName+"\",\"articletime\":\""+articleTime+"\",\"articlewriter\":\""+articleWriter+ "\","
				+ "\"articlefrom\":\""+articleFrom+"\", \"articlecontent\":\""+articleStr+"\",\"articlegroup\":\""+articleGroup+"\", \"praiseNum\":\""+praiseNum+"\","
				+ "\"articletype\":\""+articleType+ "\","+ "\"status\":\""+status+"\", \"replynum\":\""+replyNum+"\", \"clickNum\":\""+clickNum+"\","
				+ "\"favnum\":\""+favNum+ "\","+ "\"articledesc\":\""+articleDesc+ "\","+ "\"articleImg\":\""+articleImg+"\","+ "\"shareNum\":\""+shareNum+"\"}";
		
		return result;
	}
	
	public String toShortString(){
		String result ="";		

		result = "{\"id\":\""+id+"\", \"articlename\":\""+articleName+"\", \"articletype\":\""+articleType+"\", \"clickNum\":\""+clickNum+"\","
				+ "\"articledesc\":\""+articleDesc+ "\","+ "\"articleImg\":\""+articleImg+"\"}";
		
		return result;
	}
}
