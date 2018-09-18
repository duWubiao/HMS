<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
	.right{
    width: 85%;
    float: right;
    margin-right:50px;
    margin-top: -510px;
	}
	.span1_lives{
		font-size: 16px;
		margin-top:-100px;
		margin-left:450px;
		border: 0px solid red;
	}
	.span2_lives{
		font-size: 16px;
	}
</style>
<script type="text/javascript">
	function checkDelete(){
			var flag = window.confirm("确认删除吗？");
			if(flag == true){
				return true;
			}else{
				return false;
			}
		}
</script>
<%@include file="/jsp/common/head.jsp"%>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
           		<form method="post" action="${pageContext.request.contextPath }/user_mohu">
					 <span>用户名：</span>
					 <input name="parma" class="input-text"	type="text">				 
					 <input	value="查 询" type="submit" id="searchbutton">
					 <a href="${pageContext.request.contextPath}/jsp/useradd.jsp" >添加用户</a>
				</form>
            </div>
            <c:if test="${sessionScope.flag != 1 }">
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户名</th>
                    <th width="15%">真实姓名</th>
                    <th width="20%">身份证号</th>
                    <th width="20%">注册时间</th>
                    <th width="12%">电话</th>
                    <th width="23%">操作</th>
                </tr>
                   <c:forEach var="user" items="${sessionScope.userList}" >
					<tr>
						<td>
						<span>${user.username }</span>
						</td>
						<td>
						<span>${user.name }</span>
						</td>
						<td>
							<span>
								${user.idCard }
							</span>
						</td>
						<td>
						<span><fmt:formatDate value="${user.regtime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
						</td>
						<td>
						<span>${user.phone}</span>
						</td>
						<td>
						<%-- <span><a class="viewUser" href=""><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>--%>						
						<span><a class="modifyUser" href="user_getUserById?id=${user.id}"><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span>
						<span><a class="deleteUser" href="user_deleteUser?id=${user.id}" onclick="return checkDelete()"><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
						</td>
					</tr>
				</c:forEach>
			</table>
			<span class="span1_lives">当前页数:[${sessionScope.pageindex}/${sessionScope.pageCount}]</span>
   		<c:if test="${sessionScope.pageindex == 1}"><span class="span2_lives">首页</span></c:if>
   		<c:if test="${sessionScope.pageindex != 1}"><a href="user_getUserList?pageIndex=1"><span class="span2_lives">首页</span></a></c:if>
   		<c:if test="${sessionScope.pageindex == 1}"><span class="span2_lives">上一页</span></c:if>
   		<c:if test="${sessionScope.pageindex != 1}"><a href="user_getUserList?pageIndex=${sessionScope.pageindex-1}"><span class="span2_lives">上一页</span></a></c:if>
   		<c:if test="${sessionScope.pageindex == sessionScope.pageCount}"><span class="span2_lives">下一页</span></c:if>
   		<c:if test="${sessionScope.pageindex != sessionScope.pageCount}"><a href="user_getUserList?pageIndex=${sessionScope.pageindex+1}"><span class="span2_lives">下一页</span></a></c:if>
   		<c:if test="${sessionScope.pageindex == sessionScope.pageCount}"><span class="span2_lives">尾页</span></c:if>
   		<c:if test="${sessionScope.pageindex != sessionScope.pageCount}"><a href="user_getUserList?pageIndex=${sessionScope.pageCount}"><span class="span2_lives">尾页</span></a></c:if>
        </c:if>
        <c:if test="${sessionScope.flag == 1 }">
       <!--账单表格 样式和供应商公用-->
      <table class="providerTable" cellpadding="0" cellspacing="0">
          <tr class="firstTr">
                    <th width="10%">用户名</th>
                    <th width="15%">真实姓名</th>
                    <th width="20%">身份证号</th>
                    <th width="20%">注册时间</th>
                    <th width="12%">电话</th>
                    <th width="23%">操作</th>
               </tr>
          <c:forEach items="${sessionScope.userlistLike}" var="userLike">
				<tr>
	    			<td>${userLike.username}</td>
	    			<td>${userLike.name}</td>
	    			<td>${userLike.idCard}</td>
	    			<td><fmt:formatDate value="${userLike.regtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	    			<td>${userLike.phone}</td>
	    			<td>
					<%-- <span><a class="viewBill" href="live_getLiveRoom?id=${userLike.id}"><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span> --%>
					<span><a class="modifyBill" href="user_getUserById?id=${userLike.id}"><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span>
					<span><a class="deleteBill" href="user_deleteUser?id=${userLike.id}" onclick="return checkDelete()"><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
					</td>
				</tr>
			</c:forEach>		
      </table>
      <span class="span1_lives">当前页数:[${sessionScope.pageindex}/${sessionScope.pageCount}]</span>
   		<c:if test="${sessionScope.pageindex == 1}"><span class="span2_lives">首页</span></c:if>
   		<c:if test="${sessionScope.pageindex != 1}"><a href="user_mohu?pageIndex=1"><span class="span2_lives">首页</span></a></c:if>
   		<c:if test="${sessionScope.pageindex == 1}"><span class="span2_lives">上一页</span></c:if>
   		<c:if test="${sessionScope.pageindex != 1}"><a href="user_mohu?pageIndex=${sessionScope.pageindex-1}"><span class="span2_lives">上一页</span></a></c:if>
   		<c:if test="${sessionScope.pageindex == sessionScope.pageCount}"><span class="span2_lives">下一页</span></c:if>
   		<c:if test="${sessionScope.pageindex != sessionScope.pageCount}"><a href="user_mohu?pageIndex=${sessionScope.pageindex+1}"><span class="span2_lives">下一页</span></a></c:if>
   		<c:if test="${sessionScope.pageindex == sessionScope.pageCount}"><span class="span2_lives">尾页</span></c:if>
   		<c:if test="${sessionScope.pageindex != sessionScope.pageCount}"><a href="user_mohu?pageIndex=${sessionScope.pageCount}"><span class="span2_lives">尾页</span></a></c:if>
    </c:if>
        </div>
    </section>

 <!--点击删除按钮后弹出的页面-->
<!--<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div> -->

<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/userlist.js"></script>
