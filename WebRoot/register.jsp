<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="statics/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="statics/js/register.js"></script>

  </head>
  
  <body>
    	<form action="user_register" method="post" id="form">
    		<table border="0">
    			<tr>
    				<td>用户名:</td>
    				<td><input type="text" name="user.username" id="username"/><span id="span1"></span></td>
    			</tr>
    			<tr>
    				<td>密码:</td>
    				<td><input type="password" name="user.password" id="password"/><span id="span2"></span></td>
    			</tr>
    			<tr>
    				<td>真实姓名:</td>
    				<td><input type="text" name="user.name" id="name"/><span id="span3"></span></td>
    			</tr>
    			<tr>
    				<td>身份证:</td>
    				<td><input type="text" name="user.idCard" id="idcard"/><span id="span4"></span></td>
    			</tr>
    			<tr>
    				<td>电话号码:</td>
    				<td><input type="text" name="user.phone" id="phone"/><span id="span5"></span></td>
    			</tr>
    			<tr>
    				<td></td>
    				<td><input type="submit" value="注册" id="submit"/></td>
    			</tr>
    		</table>
    	</form>
  </body>
</html>
