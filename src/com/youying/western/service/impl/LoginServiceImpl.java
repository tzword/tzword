package com.youying.western.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youying.western.dao.LoginDao;
import com.youying.western.entity.Menu;
import com.youying.western.entity.Permission;
import com.youying.western.service.LoginService;
@Transactional
@Service
public class LoginServiceImpl implements LoginService{
	@Resource
	private LoginDao loginDao;
	//查询菜单
	public List<Menu> searchMenu(){
		return loginDao.searchMenu();
	};
	//根据用户名查询所具有的角色
	public List<Map<String, Object>> getRoleByname(String name){
		return loginDao.getRoleByname(name);
	};
	//根据用户名和角色ID查询权限菜单
	public List<Menu> searchMenuByUSRO(String name,Integer roleId){
		List<Menu> list1=loginDao.searchMenuByRoleId(roleId);
		List<Permission> list2=loginDao.searchPerByRoleId(roleId);
		for (Menu menu : list1) {
			for (Permission permission : list2) {
				if (menu.getId().equals(permission.getMenuId())) {
					menu.getList().add(permission);
				}
			}
		}
		return list1;
	};
}
