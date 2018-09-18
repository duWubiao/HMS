<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<style>
	.right{
    width: 85%;
    float: right;
    margin-right:50px;
    margin-top: -510px;
	}
	#submit{
		padding-top: 0px;
	}
</style>
<div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>密码修改页面</span>
            </div>
            <div class="providerAdd">
                <form id="form" name="userForm" method="post">
                    <input type="hidden" id="id" value="${sessionScope.user.id}">
                    <!--div的class 为error是验证错误，ok是验证成功-->
                    <div class="info">${message}</div>
                    <div class="">
                        <label for="oldPassword">旧密码：</label>
                        <input type="password" id="pwd"/> 
						<span id="span1"></span>
                    </div>
                    <div>
                        <label for="newPassword">新密码：</label>
                        <input type="password" name="user.password" id="newpassword" value=""> 
						<span id="span2"></span>
                    </div>
                    <div>
                        <label for="reNewPassword">确认新密码：</label>
                        <input type="password" name="repwd" id="renewpassword" value=""> 
						<span id="span3"></span>
                    </div>
                    <div class="providerAddBtn">
                        <!--<a href="#">保存</a>-->
                        <input type="button" name="save" id="button" value="保存" class="input-button">
                    </div>
                </form>
            </div>
        </div>
    </section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="statics/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var isOk1 = false;
	var isOk2 = false;
	var isOk3 = false;
	$("#pwd").blur(function(){
		var id = $("#id").val();
		var password = $("#pwd").val();
		var param = {
			"user.id":id,
			"user.password":password
		};
		$.post("users_getUserPwd",param,function(data){
			var flag = data.flag;
			if(flag == "true"){
				$("#span1").html("");
				isOk1 = true;
			}else if(flag =="false"){
				isOk1 = false;
				$("#span1").html("<font color='red' size='2'>请输入正确的原密码!</font>");
			}
		});
	});
$("#newpassword").blur(function(){
	var password = $("#newpassword").val();
		var reg=/^[a-zA-Z0-9]{6,20}$/;
		var span2 = $("#span2");
		if(password == "" || password == null){
			span2.html("<font color='red' size='2'>密码不能为空</font>");
			isOk2 = false;
		}else if(reg.test(password) == false){
			span2.html("<font color='red' size='2'>密码格式错误，请用大小写英文字母、数字，长度6-20个字符</font>");
			isOk2 = false;
		}else{
			span2.html("");
			isOk2 = true;
		}	
});
$("#renewpassword").blur(function(){
	var password1 = $("#newpassword").val();
	var password = $("#renewpassword").val();
	var span3 = $("#span3");
	if(password1 == password){
		isOk3 = true;
		span3.html("");
	}else{
		isOk3 = false;
		span3.html("<font color='red'>两次密码输入不一致!</font>");
	}	
});
	$("#button").click(function(){
	alert(11111);
		var pwd1 = $("#newpassword").val();
		var pwd2 = $("#renewpassword").val();
		var id = $("#id").val();
		alert(pwd1);
		alert(pwd2+"1");
		if(isOk1 && isOk2 && isOk3){
			$.post("users_updatePwd","user.password="+pwd1+"&repwd="+pwd2+"&user.id="+id,function(data){
				alert(flag);
			});
        }else{
        	alert("修改密码失败!");
        	return false;
        }
	});
});

</script>