package com.youying.western.dao;

import java.util.List;

import com.youying.western.entity.Permission;
import com.youying.western.entity.RoPer;

public interface PermissionDao {
	//添加权限
	public void addPermission(Permission permission);
	//修改权限
	public void updPermission(Permission permission); 
	//查询权限
	public List<Permission> searchPermission();
	//根据ID得到权限
	public Permission queryByID(String id);
	//为角色分配权限
	public void addRoper(RoPer roPer);
}
