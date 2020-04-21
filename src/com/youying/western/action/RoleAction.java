package com.youying.western.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.youying.western.entity.Role;
import com.youying.western.entity.UsRo;
import com.youying.western.service.RoleService;
@Controller
@SuppressWarnings("serial")
public class RoleAction extends ActionSupport implements ServletRequestAware{
	@Resource
	private RoleService roleService;
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	private Role role;
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role Role) {
		this.role = Role;
	}
	
	//添加角色
	public String addRole(){
		role.setState(1);
		roleService.addRole(role);
		return "addRole";
	}
	//跳转修改角色
	public String toUpdateRole() {
		String id=request.getParameter("id");
		Role role=roleService.queryByID(id);
		request.setAttribute("role", role);
		return "toUpdateRole";
	}
	//修改角色
	public String updateRole(){
		roleService.updRole(role);
		return "updateRole";
	}
	//查询角色
	public String searchRole(){
		List<Role> list=roleService.searchRole();
		request.setAttribute("list", list);
		return "list";
	}
	//给用户绑定角色
	public String userAddRole(){
		Integer userId=Integer.valueOf(request.getParameter("userId"));
		Integer roleId=Integer.valueOf(request.getParameter("roleId"));
		UsRo usRo=new UsRo();
		usRo.setUserId(userId);
		usRo.setRoleId(roleId);
		roleService.addUsro(usRo);
		return "usro";
	}
	
	
}
