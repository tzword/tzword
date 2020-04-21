package com.youying.western.service;

import java.util.List;
import java.util.Map;

import com.youying.western.entity.Menu;

public interface LoginService {
	//查询菜单
	public List<Menu> searchMenu();
	//根据用户名查询所具有的角色
	public List<Map<String, Object>> getRoleByname(String name);
	//根据用户名和角色ID查询权限菜单
	public List<Menu> searchMenuByUSRO(String name,Integer roleId);
}
