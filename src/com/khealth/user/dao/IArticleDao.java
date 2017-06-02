package com.khealth.user.dao;

import java.util.List;

import com.khealth.user.pojo.Article;

public interface IArticleDao {

	int insert(Article article);
	
	int deleteById(int id);	
	
	int update(Article article);

	int updateShareNum(int id);

	int updateReplyNum(int id);

	int updateFavNum(int id);	
	
	int minusFavNum(int id);
	
	int updatePraiseNum(int id);	
	
	int updateClickNum(int id);	
	
	int updateStatus(Article article);
	
	Article selectArticleById(int id);
	
	List<Article> selectTopArticles(int num);
	
	List<Article> selectArticlesByPage(Article article);
	
	Article selectProfessionalArticle();
	
	List<Article> selectProfessionalArticlesByPage(Article article);
}
