<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>
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
  
    <s:form action="userAction!addUser" method="post">
    <div>
    	用户名：<input type="text" name="user.name"/>
    	姓名：<input type="text" name="user.fullname"/><br/>
    	手机号：<input type="text" name="user.mobile"/>
    	性别：<input type="radio" name="user.sex" value="1"/> 男
    	     <input type="radio" name="user.sex" value="0"/> 女 
    	     <input type="submit" name="sb" value="注册" />
    </div>
   </s:form>
  </body>
</html>
