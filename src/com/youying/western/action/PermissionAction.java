package com.youying.western.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.youying.western.entity.Permission;
import com.youying.western.entity.RoPer;
import com.youying.western.service.PermissionService;
@Controller
@SuppressWarnings("serial")
public class PermissionAction extends ActionSupport implements ServletRequestAware{
	@Resource
	private PermissionService permissionService;
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	private Permission permission;
	public Permission getPermission() {
		return permission;
	}
	
	public void setPermission(Permission Permission) {
		this.permission = Permission;
	}
	
	//添加权限
	public void addPermission(){
		permissionService.addPermission(permission);
	}
	//跳转修改权限
	public String toUpdatePermission() {
		String id=request.getParameter("id");
		Permission permission=permissionService.queryByID(id);
		request.setAttribute("permission", permission);
		return "toUpdatePermission";
	}
	//修改权限
	public void updatePermission(){
		permissionService.updPermission(permission);
	}
	//查询权限
	public String searchPermission(){
		@SuppressWarnings("unused")
		List<Permission> list=permissionService.searchPermission();
		return "success";
	}
	//为角色分配权限
	public String roleAddPer() {
		Integer roleId=Integer.valueOf(request.getParameter("roleId"));
		Integer perId=Integer.valueOf(request.getParameter("perId"));
		RoPer roPer=new RoPer();
		roPer.setRoleId(roleId);
		roPer.setPermissionId(perId);
		permissionService.addRoper(roPer);
		return "roper";
	}

}
