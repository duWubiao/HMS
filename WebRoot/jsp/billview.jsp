<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
         <span>订单管理页面 >> 信息查看</span>
     </div>
     <div class="providerView">
         <p><strong>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</strong><span>${sessionScope.live.name}</span></p>
         <p><strong>入住天数：</strong><span>${sessionScope.live.day}</span></p>
         <p><strong>所需价格：</strong><span>${sessionScope.live.price}</span></p>
         <p><strong>预约时间：</strong><span><fmt:formatDate value="${sessionScope.live.regtime}" pattern="yyyy-MM-dd HH:mm:ss"/></span></p>
         <p><strong>电话号码：</strong><span>${sessionScope.live.phone}</span></p>
         <p><strong>房间信息：</strong><span>${sessionScope.room.typename}</span></p>
         <p><strong>房间号：</strong><span>${sessionScope.room.number}</span></p>
		<div class="providerAddBtn">
         	<input type="button" id="back" name="back" onclick="javascript:history.back(-1);" value="返回" >
        </div>
     </div>
 </div>
<%@include file="/jsp/common/foot.jsp" %>