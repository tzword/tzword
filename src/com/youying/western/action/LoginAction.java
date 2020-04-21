package com.youying.western.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.youying.western.entity.Menu;
import com.youying.western.entity.User;
import com.youying.western.service.LoginService;
import com.youying.western.service.UserService;
import com.youying.western.tools.CommonUtil;
@SuppressWarnings("serial")
@Controller
public class LoginAction extends ActionSupport implements ServletRequestAware{
	@Resource
	private UserService userService;
	@Resource
	private LoginService loginService;
	private HttpServletRequest request;
	private String msg;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	//跳转登录页面
	public String toLogin() {
		return "toLogin";
	}
	
	//登录
	public String login() {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String certCode=request.getParameter("certCode");
		Integer roleId=Integer.valueOf(request.getParameter("juese"));
		User user =userService.queryByName(name);
		if (user==null) {
			msg="用户名不存在";
			request.setAttribute("msg", msg);
			return "login";
		}
		if (!password.equals(user.getPassword())) {
			msg="密码错误";
			request.setAttribute("msg", msg);
			return "login";
		}
		if(!certCode.equalsIgnoreCase(request.getSession().getAttribute("certCode").toString())){
			msg="验证码错误";
			request.setAttribute("msg", msg);
			return "login";
		}
		List<Menu> list=loginService.searchMenuByUSRO(name, roleId);
		request.setAttribute("list", list);
		request.getSession().setAttribute("userSession", user);
		return "menu";
	}
	
	//根据用户名显示角色
	public void getRoleByname() {
		String name=request.getParameter("name");
		User user =userService.queryByName(name);
		if (user!=null) {
			List<Map<String, Object>> list= loginService.getRoleByname(name);
			String jsonStr=JSONArray.fromObject(list).toString();
			CommonUtil.responseJSONString(jsonStr);
		}
	}
}
