<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
	
	
  <script type="text/javascript"> 
	function changeimg() {
		var myimg = document.getElementById("code");
		now = new Date();
		myimg.src = "makeCertPic.jsp?code=" + now.getTime();
	}
	
	$(function(){
		if($("#msg").val()!=""){
			alert($("#msg").val());
		}
		
		$("#login").window({
			width:500,
			height:300,
			minimizable:false,
			maximizable:false,
			closable:false
		});
		
		$("#name").blur(function(){
			var name=$("#name").val();
			$.ajax({
				url:"loginAction!getRoleByname.action",
				type:"post",
				data:{
					"name":name
				},
				global : false,
				async : false,
				dataType:"text",
				success : function(data){
					var strjson=eval(data);
					for(var i in strjson){
						var value=strjson[i].NAME;
						var roleId=strjson[i].ID;
						$("#juese").append("<option value="+roleId+">"+value+"</option>");
					}
				}
			});
		});
	});
	
	function doLogin() {
		$("#loginform").submit();
	}
	
	function doReset(){
		$("#name").val("");
		$("#password").val("");
	}
  </script> 
  </head>
  
  <body class="easyui-layout">
  <div region="center">
      <div id="login" title="用户登录">
	  <input type="hidden" id="msg" name="msg" value="${msg}">
	<div style="margin-top:50px"><center>
	<form id="loginform" action="loginAction!login.action">
	<table id="loginTable">
		<tr>
			<td align="center"><b style="font: 12px">用户名：</b></td>
			<td><input type="text" name="name" class="easyui-validatebox" id="name" style="width:200px;" maxlength="20" required="true"></input></td>
		</tr>
		<tr>
			<td align="center"><b style="font: 12px">密码：</b></td>
			<td><input type="password" name="password" class="easyui-validatebox" id="password" style="width:200px;" maxlength="20" required="true"></input></td>
		</tr>
		<tr>
			<td align="center"><b style="font: 12px">验证码：</b></td>
			<td><input type="text" name="certCode" class="easyui-validatebox" id="certCode" style="width:200px;" maxlength="20" required="true"></input><img id="code" src="makeCertPic.jsp"><a href="javascript:changeimg()"><font size="2px">看不清，换一张 </font></a></td>
		</tr>
		<tr>
			<td align="center"><b style="font: 12px">当前角色：</b></td>
			<td><select id="juese" name="juese" style="width:100px;"></select></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a class="easyui-linkbutton" icon="icon-redo" onclick="doReset();">重置</a>
				<a class="easyui-linkbutton" icon="icon-ok" onclick="doLogin();">确定</a>
			</td>
		</tr>
	</table>
	</form>
	</center>
	</div>
	</div>
  </div>
  </body>
</html>
