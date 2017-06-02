package com.khealth.user.dao;

import com.khealth.user.pojo.User;

public interface IUserDao {

    int insert(User user);
    
	int deleteById(Integer id);

    int update(User user);
    
    int updateNickname(int id, String nickname);
    
    int updateImg(int id, String imgURL);
    
    int updateFavNum(int id);
    
    int minusFavNum(int id);
    
    int updateArticleNum(int id);
    
    int minusArticleNum(int id);

    int updateCommentNum(int id);
	
	int depositMoney(int id, int amount);
	
	int depositCoin(int id, int amount);
	
	int withdrawMoney(int id, int amount);
	
	int withdrawCoin(int id, int amount);

    User selectById(Integer id);
    
    User selectByCellphone(String cellphone);
    
    User selectByCellphonePWD(String cellphone, String password);
    
    String selectImgById(int id);
}
