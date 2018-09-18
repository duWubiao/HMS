<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<style>
	.right{
    width: 85%;
    float: right;
    margin-right:50px;
    margin-top: -510px;
}
</style>
<section>
    <div class="right">
        <img class="wColck" src="${pageContext.request.contextPath }/statics/images/clock.jpg" alt=""/>
        <div class="wFont">
            <h2>${sessionScope.user.username }</h2>
            <p>欢迎来到酒店管理系统!</p>
        </div>
    </div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
