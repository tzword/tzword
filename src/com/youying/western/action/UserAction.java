package com.youying.western.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.youying.western.entity.User;
import com.youying.western.service.UserService;

@Controller
@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ServletRequestAware{
	@Resource
	private UserService userService;
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	private User user;
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	//添加用户
	public String addUser(){
		user.setState(1);
		userService.addUser(user);
		return "addUser";
	}
	//跳转修改用户
	public String toUpdateUser() {
		String id=request.getParameter("id");
		User user=userService.queryByID(id);
		request.setAttribute("user", user);
		return "toUpdateUser";
	}
	//修改用户
	public String updateUser(){
		userService.updUser(user);
		return "updateUser";
	}
	//查询用户
	public String searchUser(){
		List<User> list=userService.searchUser();
		request.setAttribute("list", list);
		return "list";
	}
	//根据用户名得到用户
	public User queryByName() {
		String name=request.getParameter("name");
		return userService.queryByName(name);
	}
	
}
