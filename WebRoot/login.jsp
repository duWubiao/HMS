<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - HMS管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css" />
    <script type="text/javascript" src="statics/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
    	/* $(document).ready(function(){
    		$("#submit").click(function(){
    			var username = $("#username").val();
    			var password = $("#password").val();
    			$.post("users_login","user.username="+username+"&user.password="+password,function(data){
	    			var flag = data.flag;
	    			if(flag == "true"){
	    				alert(1111111);
	    				window.location.href="jsp/frame.jsp";
	    			}else if(flag == "false"){
	    			alert(22222222);
	    				window.location.href="login.jsp";
	    			}
    		});
    		});
    	}); */
    </script>
</head> 
<body class="login_bg">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>HMS管理系统</h1>
        </header>
        <section class="loginCont">
	        <form class="loginForm"  action="${pageContext.request.contextPath }/user2_login" name="actionForm" id="actionForm" method="post">
				<div class="info">${error }</div>
				<div class="inputbox">
                    <label for="user">用户名：</label>
					<input type="text" class="input-text" id="username" name="user.username" placeholder="请输入用户名" required/>
				</div>	
				<div class="inputbox">
                    <label for="mima">密码：</label>
                    <input type="password" id="password" name="user.password" placeholder="请输入密码" required/>
                </div>	
				<div class="subBtn">
                    <input type="submit" id="submit" value="登录"/>
                    <input type="reset" value="重置"/>
                </div>	
			</form>
        </section>
    </section>
</body>
</html>
