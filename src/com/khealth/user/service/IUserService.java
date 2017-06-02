package com.khealth.user.service;

import com.khealth.user.pojo.User;

public interface IUserService {

	public int addUser(User user);
    
	public int removeUserByID(Integer id);

	public int modifyUser(User user);
    
	public int modifyNickname(int id, String nickname);
    
	public int modifyImg(int id, String imgURL);
    
	public int modifyFavNum(int id);
    
	public int minusFavNum(int id);
    
	public int modifyArticleNum(int id);
    
	public int minusArticleNum(int id);

	public int modifyCommentNum(int id);
	
	public int depositMoney(int id, int amount);
	
	public int depositCoin(int id, int amount);
	
	public int withdrawMoney(int id, int amount);
	
	public int withdrawCoin(int id, int amount);

	public User getUserById(Integer id);
    
	public User getUserByCellphone(String cellphone);
    
	public User getUserByCellphonePWD(String cellphone, String password);
    
	public String getUserImgById(int id);
}
