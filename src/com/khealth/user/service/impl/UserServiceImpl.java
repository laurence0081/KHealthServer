package com.khealth.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khealth.user.dao.IUserDao;
import com.khealth.user.pojo.User;
import com.khealth.user.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	
	public int addUser(User user){
		return userDao.insert(user);
	}
    
	public int removeUserByID(Integer id){
		return userDao.deleteById(id);
	}

	public int modifyUser(User user){
		return userDao.update(user);
	}
    
	public int modifyNickname(int id, String nickname){
		return userDao.updateNickname(id, nickname);
	}
    
	public int modifyImg(int id, String imgURL){
		return userDao.updateImg(id, imgURL);
	}
    
	public int modifyFavNum(int id){
		return userDao.updateFavNum(id);
	}
    
	public int minusFavNum(int id){
		return userDao.minusFavNum(id);
	}
    
	public int modifyArticleNum(int id){
		return userDao.updateArticleNum(id);
	}
    
	public int minusArticleNum(int id){
		return userDao.minusArticleNum(id);
	}

	public int modifyCommentNum(int id){
		return userDao.updateCommentNum(id);
	}
	
	public int depositMoney(int id, int amount){
		return userDao.depositMoney(id, amount);
	}
	
	public int depositCoin(int id, int amount){
		return userDao.depositCoin(id, amount);
	}
	
	public int withdrawMoney(int id, int amount){
		return userDao.withdrawMoney(id, amount);
	}
	
	public int withdrawCoin(int id, int amount){
		return userDao.withdrawCoin(id, amount);
	}

	public User getUserById(Integer id){
		return userDao.selectById(id);
	}
    
	public User getUserByCellphone(String cellphone){
		return userDao.selectByCellphone(cellphone);
	}
    
	public User getUserByCellphonePWD(String cellphone, String password){
		return userDao.selectByCellphonePWD(cellphone, password);
	}
    
	public String getUserImgById(int id){
		return userDao.selectImgById(id);
	}
}
