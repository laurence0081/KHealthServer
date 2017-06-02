package com.khealth.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khealth.user.dao.IArticleDao;
import com.khealth.user.pojo.Article;
import com.khealth.user.service.IArticleService;

@Service("articleService")
public class ArticleServiceImpl implements IArticleService {
	@Resource
	private IArticleDao articleDao;
	
	private int result = 0;
	
	public int addArticle(Article article){
		result = this.articleDao.insert(article);
		return result;
	}
	
	public int removeArticleByID(int id){
		return this.articleDao.deleteById(id);
	}
   
	public int modifyArticle(Article article){
		result = this.articleDao.update(article);
		return result;
	}
	
	public int modifyStatus(Article article){
		result = this.articleDao.updateStatus(article);
		return result;
	}
	
	public int modifyReplyNum(int id){
		result = this.articleDao.updateReplyNum(id);
		return result;
	}
	
	public int modifyFavNum(int id){
		result = this.articleDao.updateFavNum(id);
		return result;
	}
	
	public int minusFavNum(int id){
		result = this.articleDao.minusFavNum(id);
		return result;
	}
	
	public int modifyShareNum(int id){
		result = this.articleDao.updateShareNum(id);
		return result;
	}
	
	public int modifyPraiseNum(int id){
		result = this.articleDao.updatePraiseNum(id);
		return result;
	}
	
	public int modifyClickNum(int id){
		result = this.articleDao.updateClickNum(id);
		return result;
	}

	public List<Article> getTopArticles(int num) {
		return articleDao.selectTopArticles(num);
	}

	public List<Article> getArticlesByPage(Article article) {
		return articleDao.selectArticlesByPage(article);
	}

	public Article getProfessionalArticle() {
		return articleDao.selectProfessionalArticle();
	}

	public List<Article> getProfessionalArticlesByPage(Article article) {
		return articleDao.selectProfessionalArticlesByPage(article);
	}
	
	public Article getArticleById(int id){
		return this.articleDao.selectArticleById(id);
	}
	
	public void setArticleDao(IArticleDao articleDao) {
		this.articleDao = articleDao;
	}
}
