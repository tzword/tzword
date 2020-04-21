<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adduser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	
    <s:form action="roleAction!updateRole" method="post">
    <input type="hidden" name="role.id" value="${role.id }" />
    <div>
    	角色名：<input type="text" name="role.name" value="${role.name }"/>
    	姓名：<select name="role.state" id="state" style="width: 160px;">
				<option value="">－请选择－</option>
				<option value="0" <c:if test="${role.state == 1 }">selected="selected"</c:if>>正常</option>
				<option value="1" <c:if test="${role.state == 0 }">selected="selected"</c:if>>锁定</option>
				<option value="2" <c:if test="${role.state == 2 }">selected="selected"</c:if>>删除</option>
			</select><br/>
    	      <input type="submit" name="sb" value="保存" />
    </div>
   </s:form>
  </body>
</html>
