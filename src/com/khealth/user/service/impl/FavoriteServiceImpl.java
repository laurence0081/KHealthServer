package com.khealth.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khealth.user.dao.IFavoriteDao;
import com.khealth.user.pojo.Favorite;
import com.khealth.user.service.IFavoriteService;

@Service("favoriteService")
public class FavoriteServiceImpl implements IFavoriteService {
	@Resource
	private IFavoriteDao favoriteDao;

	public int addFavorite(Favorite favorite) {
		return favoriteDao.insert(favorite);
	}
	
	public int removeFavoriteById(int id) {
		return favoriteDao.deleteById(id);
	}

	public int modifyFavorite(Favorite favorite) {
		return favoriteDao.update(favorite);
	}

	public Favorite getFavoriteById(int id) {
		return favoriteDao.selectById(id);
	}

	public Favorite getFavoriteByUserIdByPage(Favorite favorite) {
		return favoriteDao.selectByUserIdByPage(favorite);
	}

	public IFavoriteDao getFavoriteDao() {
		return favoriteDao;
	}

	public void setFavoriteDao(IFavoriteDao favoriteDao) {
		this.favoriteDao = favoriteDao;
	}
}
