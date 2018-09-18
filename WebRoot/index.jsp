<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>进入HMS</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css" />
	<style type="text/css">
		.div1{
			margin-top: 170px;
			text-align: center;
		}
		.span{
			font-size: 18px;
			
		}
		a{
			color:black;
			text-decoration: none;
			font-size: 19px;
		}
		a:hover{
			color: red;
		}
		.div2{
			margin-top: 150px;
		}
		
	</style>
  </head>
  
  <body class="login_bg" style="text-align: center;">
  		<div class="div1">
	  		<h1 style="text-align: center;">HMS酒店管理系统</h1>
  		</div>
    	<div class="div2">
    	<font>游客,请点击此</font><a href="making.jsp" >&nbsp;预定</a>
    	<font style="margin-left: 50px;">会员,请点击此</font><a href="${pageContext.request.contextPath }/login.jsp">&nbsp;预定</a>
    	</div>
  </body>
</html>
