$(document).ready(function(){
	$("#oldpassword").blur(function(){
		alert(ssssss);
		var id = $("#id").val();
		var password = $("#oldpassword").val();
		$.post("users_getUserPwd","user.id="+id+"&user.password="+password,function(data){
			var flag = data.flag;
			if(flag == "true"){
				$("#span1").html("");
			}else if(flag ==" false"){
				$("#span1").html("<font color='red' size='2'>请输入正确的原密码!</font>");
			}
		});
	});
});