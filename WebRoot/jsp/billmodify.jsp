<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<style type="text/css">
	.right{
    width: 85%;
    float: right;
    margin-right:50px;
    margin-top: -510px;
}
</style>
<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>订单管理页面 >> 订单修改页面</span>
        </div>
        <div class="providerAdd">
          <form id="billForm" name="billForm">
				<input type="hidden" name="method" value="modifysave">
				<input type="hidden" name="id" value="${sessionScope.live.id}">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="billCode">姓名：</label>
                    <input type="text" name="billCode" id="billCode" value="${sessionScope.live.name}" readonly="readonly"> 
                </div>
                <div>
                    <label for="productName">入住天数：</label>
                    <input type="text" name="productName" id="productName" value="${sessionScope.live.day}"> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="productUnit">所需价格：</label>
                    <input type="text" name="productUnit" id="productUnit" value="${sessionScope.live.price}"> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="productCount">预约时间：</label>
                    <input type="text" name="productCount" value="<fmt:formatDate value="${sessionScope.live.regtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="readonly"> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="totalPrice">电话号码：</label>
                    <input type="text" name="totalPrice" id="totalPrice" value="${sessionScope.live.phone}"> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="providerId">房间信息：</label>
                    <input type="text" value="${sessionScope.room.typename}" id="pid" />
					
					<font color="red"></font>
                </div>
                <div>
                    <label >房间号：</label>
                    <input type="text" value="${sessionScope.room.number}" id="pid" />
                </div>
                <div class="providerAddBtn">
                  <input type="button" name="save" id="save" value="保存">
				  <input type="button" id="back" name="back" value="返回" >
              	</div>
            </form>
        </div>

    </div>

<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/billmodify.js"></script>