
package com.youying.western.service;

import java.util.List;

import com.youying.western.entity.User;

public interface UserService {
	//添加用户
	public void addUser(User user);
	//修改用户
	public void updUser(User user); 
	//查询用户
	public List<User> searchUser();
	//根据用户名得到用户
	public User queryByName(String name);
	//根据ID得到用户
	public User queryByID(String id);
}
