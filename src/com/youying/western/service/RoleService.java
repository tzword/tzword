package com.youying.western.service;

import java.util.List;

import com.youying.western.entity.Role;
import com.youying.western.entity.UsRo;

public interface RoleService {
	//添加角色
	public void addRole(Role role);
	//修改角色
	public void updRole(Role role); 
	//查询角色
	public List<Role> searchRole();
	//根据ID得到角色
	public Role queryByID(String id);
	//给用户绑定角色
	public void addUsro(UsRo usRo);
}
