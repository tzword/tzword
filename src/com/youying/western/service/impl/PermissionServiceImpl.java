package com.youying.western.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youying.western.dao.PermissionDao;
import com.youying.western.entity.Permission;
import com.youying.western.entity.RoPer;
import com.youying.western.service.PermissionService;
@Transactional
@Service
public class PermissionServiceImpl implements PermissionService{
	@Resource
	private PermissionDao permissionDao;
	//添加权限
	public void addPermission(Permission permission){
		permissionDao.addPermission(permission);
	};
	//修改权限
	public void updPermission(Permission permission){
		permissionDao.updPermission(permission);
	}; 
	//查询权限
	public List<Permission> searchPermission(){
		return permissionDao.searchPermission();
	};
	//根据ID得到权限
	public Permission queryByID(String id){
		return permissionDao.queryByID(id);
	};
	//为角色分配权限
	public void addRoper(RoPer roPer){
		permissionDao.addRoper(roPer);
	};
}
