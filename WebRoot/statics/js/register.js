$(document).ready(function(){
	var isOk1 = false;
	var isOk2 = false;
	var isOk3 = false;
	var isOk4 = false;
	var isOk5 = false;
	$("#username").blur(function(){
		var username = $("#username").val();
		var reg = /^[a-zA-Z0-9]{4,20}$/;
		var span1 = $("#span1");
		if(username == "" || username == null){
			span1.html("<font color='red' size='2'>昵称不能为空</font>");
			isOk1 = false;
		}else if(reg.test(username) == false){
			span1.html("<font color='red' size='2'>用户名格式错误，请用大小写英文字母、数字，长度4-20个字符</font>");
			isOk1 = false;
		}else{
			$.post("users_getName","user.username="+$("#username").val(),function(data){				
				var flag = data.flag;
				if(flag == "true"){
					span1.html("<font color='red' size='2'>用户名已被注册!</font>");
					isOk1 = false;
				}else if(flag =="false"){
					span1.html("");
					isOk1 = true;
				}
			});
		}	
	});
	$("#password").blur(function(){
		var password = $("#password").val();
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
	$("#name").blur(function(){
		var name = $("#name").val();
		var reg = /^[\u0391-\uFFE5]+$/;
		var span3 = $("#span3");
		if(name == "" || name == null){
			span3.html("<font color='red' size='2'>真实姓名不能为空</font>");
			isOk3 = false;
		}else if(reg.test(name) == false){
			span3.html("<font color='red' size='2'>名字不合法，只能是中文</font>");
			isOk3 = false;
		}else{
			span3.html("");
			isOk3 = true;
		}
	});
	$("#idcard").blur(function(){
		var idcard = $("#idcard").val();
		var reg = /^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/;
		var span4 = $("#span4");
		if(idcard == "" || idcard == null){
			span4.html("<font color='red' size='2'>身份证不能为空</font>");
			isOk4 = false;
		}else if(reg.test(idcard) == false){
			span4.html("<font color='red' size='2'>身份证格式不对</font>");
			isOk4 = false;
		}else{
			span4.html("");
			isOk4 = true;
		}
	});
	$("#phone").blur(function(){
		var phone = $("#phone").val();
		var reg = /^1[3|5|8]\d{9}?$/;
		var span5 = $("#span5");
		if(phone == "" || phone == null){
			span5.html("<font color='red' size='2'>电话号码不能为空</font>");
			isOk5 = false;
		}else if(reg.test(phone) == false){
			span5.html("<font color='red' size='2'>电话号码格式错误,以13.15,18开头的11位数</font>");
			isOk5 = false;
		}else{
			span5.html("");
			isOk5 = true;
		}
	});
	$("#submit").click(function(){
		if(isOk1 && isOk2 && isOk3 && isOk4 && isOk5){
			$("#form").submit();
        }else{
        	alert("请按照要求填写");
        	return false;
        }
	});
	
});