package com.youying.western.dao;

import java.util.List;
import java.util.Map;

import com.youying.western.entity.Menu;
import com.youying.western.entity.Permission;

public interface LoginDao {
	//查询菜单
	public List<Menu> searchMenu();
	//根据用户名查询所具有的角色
	public List<Map<String, Object>> getRoleByname(String name);
	//根据角色ID查询权限
	public List<Permission> searchPerByRoleId(Integer roleId);
	//根据角色ID查询菜单
	public List<Menu> searchMenuByRoleId(Integer roleId);
}
