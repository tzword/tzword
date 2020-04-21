<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'menu.jsp' starting page</title>
    
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
	</script>
  </head>
  
  <body class="easyui-layout">
	<!-- 正上方panel -->
    <div region="north" title="标题栏" split="true" style="width:1000px;height:100px">
    	<center><div style="margin-top:20px;">
    		<h2>权限管理系统</h2>
		</div></center>
    </div>
    <!-- 正左边panel -->
    <div region="west" title="菜单栏" split="true" style="width:280px;padding1:1px;overflow:hidden;">
    	<div class="easyui-accordion" fit="true" border="false">
    		<!-- selected -->
    		   <c:forEach items="${list }" var="root">
			<div title="${root.name }" selected="true">
			<ul>
				<c:forEach items="${root.list }" var="child">
				<li><a href="">${child.name }</a></li>
				</c:forEach>
			</ul>
			</div>
			</c:forEach>
		</div>
   	</div>
    <!-- 正中间panel -->
    <div region="center" title="功能区" >
    	<div class="easyui-tabs" id="centerTab" fit="true" border="false">
			<div title="欢迎页" style="padding:20px;overflow:hidden;"> 
				<div style="margin-top:20px;">
					<h3>你好，欢迎来到权限管理系统</h3>
				</div>
			</div>
		</div>
    </div>
    <!-- 正下方panel -->
    <div region="south" style="height:50px;" align="center">
    	<label>
    	版本号：1.0.1
    	</label>
    </div>
</body>
</html>
