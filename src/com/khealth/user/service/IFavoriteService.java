package com.khealth.user.service;

import com.khealth.user.pojo.Favorite;

public interface IFavoriteService {

	public int addFavorite(Favorite favorite);
	
	public int removeFavoriteById(int id);

	public int modifyFavorite(Favorite favorite);

	public Favorite getFavoriteById(int id);
    
	public Favorite getFavoriteByUserIdByPage(Favorite favorite);
}
