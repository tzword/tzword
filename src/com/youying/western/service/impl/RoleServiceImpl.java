package com.youying.western.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youying.western.dao.RoleDao;
import com.youying.western.entity.Role;
import com.youying.western.entity.UsRo;
import com.youying.western.service.RoleService;
@Transactional
@Service
public class RoleServiceImpl implements RoleService{
	@Resource
	private RoleDao roleDao;
	
	// 添加角色
	public void addRole(Role role) {
		roleDao.addRole(role);
	}
	// 修改角色
	public void updRole(Role role) {
		roleDao.updRole(role);
	}
	//查询角色
	public List<Role> searchRole(){
		return roleDao.searchRole();
	}
	//根据ID得到角色
	public Role queryByID(String id){
		return roleDao.queryByID(id);
	}
	//给用户绑定角色
	public void addUsro(UsRo usRo){
		roleDao.addUsro(usRo);
	};
}
