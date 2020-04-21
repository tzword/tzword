package com.youying.western.tools;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class CommonUtil {
	/**
	 * 返回JsonString对象
	 * 
	 * @param jsonStr
	 */
	public static void responseJSONString(String jsonStr) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		try {
			response.getWriter().write(jsonStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
