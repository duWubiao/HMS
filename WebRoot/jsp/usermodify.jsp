<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.right{
    width: 85%;
    float: right;
    margin-right:50px;
    margin-top: -510px;
	}
	#save{
		padding-top:0px;
	}
</style>
<%@include file="/jsp/common/head.jsp"%>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
        <form id="userForm" name="userForm" method="post" action="user_updateUser">
			<input type="hidden" name="user.id" value="${user.id }"/>
			 <div>
                    <label for="userName">用户名：</label>
                    <input type="text" name="user.username" value="${user.username }"> 
					<font color="red"></font>
             </div>
			 <div>
                    <label >真实姓名：</label>
                    <input type="text" name="user.name" value="${user.name }"> 
             </div>
		       <div>
                    <label for="userphone">身份证：</label>
                    <input type="text" name="user.idCard" value="${user.idCard}"> 
                    <font color="red"></font>
               </div>
                <div>
                    <label for="userAddress">注册时间：</label>
                    <input type="text" name="user.regtime" value="<fmt:formatDate value="${user.regtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="readonly">
                </div>
				<div>
                    <label >电话：</label>
                    <!-- 列出所有的角色分类 -->
					<input type="text" name="user.phone" value="${user.phone}" />
        			<font color="red"></font>
                </div>
			 	<div class="providerAddBtn">
                    <input type="submit" id="save" value="保存" />
                    <input type="button" id="back" name="back" value="返回"/>
                </div>
            </form>
        </div>
    </div>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/usermodify.js"></script>
