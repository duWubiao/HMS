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
	#add{
		padding-top: 0px;
	}
</style>
<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
            <form id="userForm" name="userForm" method="post" action="user_register">
				<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="userCode">用户名:</label>
                    <input type="text" name="user.username" id="username"/><span id="span1"></span>
                </div>
                <div>
                    <label for="userName">密码:</label>
                    <input type="password" name="user.password" id="password"/><span id="span2"></span>
                </div>
                <div>
                    <label for="userPassword">真实姓名:</label>
                    <input type="text" name="user.name" id="name"/><span id="span3"></span>
                </div>
                <div>
                    <label for="ruserPassword">身份证:</label>
                    <input type="text" name="user.idCard" id="idcard"/> 
					<span id="span4"></span>
                </div>
                <div>
                    <label for="birthday">出生日期：</label>
                    <input type="text" Class="Wdate" id="birthday" name="birthday" 
					readonly="readonly" onclick="WdatePicker();">
					<font color="red"></font>
                </div>
                <div>
                    <label for="phone">电话号码:</label>
                    <input type="text" name="user.phone" id="phone" value=""> 
					<span id="span5"></span>
                </div> 
                <div class="providerAddBtn">
                    <input type="submit" name="add" id="add" value="保存" >
					<input type="button" id="back" name="back" value="返回" >
                </div>
            </form>
        </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/useradd.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/register.js"></script>
