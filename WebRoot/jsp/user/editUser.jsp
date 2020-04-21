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
	<link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/icon.css"/>
	<script type="text/javascript" src="<%=basePath%>easyui/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>easyui/locale/easyui-lang-zh_CN.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	
    <s:form action="userAction!updateUser" method="post">
    <input type="hidden" name="user.id" value="${user.id }" />
    <div>
    	用户名：<input type="text" name="user.name" value="${user.name }"/>
    	姓名：<input type="text" name="user.fullname" value="${user.fullname }"/><br/>
    	手机号：<input type="text" name="user.mobile" value="${user.mobile }"/><br/>
    	性别：<input type="radio" name="user.sex" value="1" <c:if test="${user.sex == 1 }">checked="checked"</c:if> /> 男
    	      <input type="radio" name="user.sex" value="0" <c:if test="${user.sex == 0 }">checked="checked"</c:if> /> 女<br/>
    	 状态: <select name="user.state" id="state" style="width: 160px;">
				<option value="">－请选择－</option>
				<option value="1" <c:if test="${user.state == 1 }">selected="selected"</c:if>>正常</option>
				<option value="0" <c:if test="${user.state == 0 }">selected="selected"</c:if>>锁定</option>
				<option value="2" <c:if test="${user.state == 2 }">selected="selected"</c:if>>删除</option>
			</select><br/> 
    	      <input type="submit" name="sb" value="保存" />
    </div>
   </s:form>
  </body>
</html>
