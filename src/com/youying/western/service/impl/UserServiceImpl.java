package com.youying.western.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youying.western.dao.UserDao;
import com.youying.western.entity.User;
import com.youying.western.service.UserService;
@Transactional
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	
	// 添加用户
	public void addUser(User user) {
		userDao.addUser(user);
	}
	// 修改用户
	public void updUser(User user) {
		userDao.updUser(user);
	}
	//查询用户
	public List<User> searchUser(){
		return userDao.searchUser();
	}
	//根据用户名得到用户
	public User queryByName(String name){
		return userDao.queryByName(name);
	}
	//根据ID得到用户
	public User queryByID(String id){
		return userDao.queryByID(id);
	}
}
