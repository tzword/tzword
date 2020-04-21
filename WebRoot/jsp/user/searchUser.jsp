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
	<link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/icon.css"/>
	<script type="text/javascript" src="<%=basePath%>easyui/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>easyui/locale/easyui-lang-zh_CN.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function openWin(){
		$.ajax({
			type:"json",
			url:"roleAction!roleList",
			data:"",
			success:function(){
				for(var i=0;i<list.length,i++){
					$("#win").append("<optionj>"+list[i].name+"</option>");
				}
				//$("#role").append("<optionj>ssssss</option>");
				$().val(list[].val);
			}
		});
		$("#win").window({
			width:500,
			height:400
		});
	}
	</script>
  </head>
  
  <body>
    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#c9c9c9"> 
      <tr style="background-color:#3b627a"> 
        <td height="22" width="6%"><div align="center"><strong>序号</strong></div></td>
        <td height="22" width="10%"><div align="center"><strong>用户名</strong></div></td>
        <td height="22" width="10%"><div align="center"><strong>姓名</strong></div></td>
        <td height="22" width="10%"><div align="center"><strong>手机号</strong></div></td>
        <td height="22" width="10%"><div align="center"><strong>性别</strong></div></td>
        <td height="22" width="10%"><div align="center"><strong>状态</strong></div></td>
        <td height="22" width="10%"><div align="center"><strong>操作</strong></div></td>
      </tr>
      <c:forEach var="user" items="${list }" varStatus="vs">
      <tr>
      	<tr> 
        <td height="22" width="6%"><div align="center">${vs.count}</div></td>
        <td height="22" width="10%"><div align="center">${user.name }</div></td>
        <td height="22" width="10%"><div align="center">${user.fullname }</div></td>
        <td height="22" width="10%"><div align="center">${user.mobile }</div></td>
        <td height="22" width="10%"><div align="center">${user.sex }</div></td>
        <td height="22" width="10%"><div align="center">${user.state }</div></td>
        <td height="22" width="10%"><div align="center"><a href="userAction!toUpdateUser.action?id=${user.id }">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:openWin()">分配角色</a></div></td>
      </tr>
      </c:forEach>
    </table>
    
    <div id="win" title="分配角色">
    </div>
  </body>
</html>
