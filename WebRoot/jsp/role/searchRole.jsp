<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'searchUser.jsp' starting page</title>
    
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
    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#c9c9c9"> 
      <tr style="background-color:#3b627a"> 
        <td height="22" width="6%"><div align="center"><strong>序号</strong></div></td>
        <td height="22" width="10%"><div align="center"><strong>角色名</strong></div></td>
        <td height="22" width="10%"><div align="center"><strong>状态</strong></div></td>
        <td height="22" width="10%"><div align="center"><strong>时间</strong></div></td>
        <td height="22" width="10%"><div align="center"><strong>操作</strong></div></td>
      </tr>
      <c:forEach var="role" items="${list }" varStatus="vs">
      <tr>
      	<tr> 
        <td height="22" width="6%"><div align="center">${vs.count}</div></td>
        <td height="22" width="10%"><div align="center">${role.name }</div></td>
        <td height="22" width="10%"><div align="center">${role.state }</div></td>
        <td height="22" width="10%"><div align="center">${role.createDt }</div></td>
        <td height="22" width="10%"><div align="center"><a href="roleAction!toUpdateRole.action?id=${role.id }">修改</a></div></td>
      </tr>
      </c:forEach>
    </table>
  </body>
</html>
