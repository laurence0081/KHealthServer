package com.khealth.user.dao;

import com.khealth.user.pojo.Favorite;

public interface IFavoriteDao {
	
	int deleteById(int id);

    int insert(Favorite favorite);

    int update(Favorite favorite);

    Favorite selectById(int id);
    
    Favorite selectByUserIdByPage(Favorite favorite);
}
