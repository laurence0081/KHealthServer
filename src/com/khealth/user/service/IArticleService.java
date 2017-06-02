package com.khealth.user.service;

import java.util.List;

import com.khealth.user.pojo.Article;

public interface IArticleService {
	
	public int addArticle(Article article);
	
	public int removeArticleByID(int id);
   
	public int modifyArticle(Article article);
	
	public int modifyStatus(Article article);
	
	public int modifyShareNum(int id);

	public int modifyReplyNum(int id);

	public int modifyFavNum(int id);
	
	public int minusFavNum(int id);

	public int modifyPraiseNum(int id);
	
	public int modifyClickNum(int id);
	
	public Article getArticleById(int id);
	
	public List<Article> getTopArticles(int num);
	
	public List<Article> getArticlesByPage(Article article);
	
	public Article getProfessionalArticle();
	
	public List<Article> getProfessionalArticlesByPage(Article article);
}
