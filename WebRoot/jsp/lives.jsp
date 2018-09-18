<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
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
<section>
<div class="right">
       <div class="location">
           <strong>你现在所在的位置是:</strong>
           <span>订单管理页面</span>
       </div>
       <div class="search">
		<form method="post" action="${pageContext.request.contextPath }/live_mohu">
			<input name="method" value="query" class="input-text" type="hidden">
			<span>通过姓名搜索:</span>
			<input name="parma" type="text" value="${queryProductName }">
			 <input	value="查 询" type="submit" id="searchbutton">
			 <a href="${pageContext.request.contextPath }/making.jsp">添加订单</a>
		</form>
       </div>
       <c:if test="${sessionScope.flag != 1 }">
       <!--账单表格 样式和供应商公用-->
      <table class="providerTable" cellpadding="0" cellspacing="0">
          <tr class="firstTr">
              <th width="10%">姓名</th>
              <th width="20%">入住天数</th>
              <th width="10%">所需价格</th>
              <th width="20%">预约时间</th>
              <th width="10%">电话号码</th>
              <th width="30%">操作</th>
          </tr>
          <c:forEach items="${sessionScope.liveList }" var="live">
				<tr>
	    			<td>${live.name}</td>
	    			<td>${live.day}</td>
	    			<td>${live.price}</td>
	    			<td><fmt:formatDate value="${live.regtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	    			<td>${live.phone}</td>
	    			<td>
					<span><a class="viewBill" href="live_getLiveRoom?id=${live.id}"><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>
					<%-- <span><a class="modifyBill" href="live_getLiveRoom_2?id=${live.id}"><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span> --%>
					<span><a class="deleteBill" href="live_delete?id=${live.id}" onclick="return checkDelete()"><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
					</td>
				</tr>
			</c:forEach>
      </table>
      	<span class="span1_lives">当前页数:[${sessionScope.pageindex}/${sessionScope.pageCount}]</span>
   		<c:if test="${sessionScope.pageindex == 1}"><span class="span2_lives">首页</span></c:if>
   		<c:if test="${sessionScope.pageindex != 1}"><a href="live_fenyes?pageIndex=1"><span class="span2_lives">首页</span></a></c:if>
   		<c:if test="${sessionScope.pageindex == 1}"><span class="span2_lives">上一页</span></c:if>
   		<c:if test="${sessionScope.pageindex != 1}"><a href="live_fenyes?pageIndex=${sessionScope.pageindex-1}"><span class="span2_lives">上一页</span></a></c:if>
   		<c:if test="${sessionScope.pageindex == sessionScope.pageCount}"><span class="span2_lives">下一页</span></c:if>
   		<c:if test="${sessionScope.pageindex != sessionScope.pageCount}"><a href="live_fenyes?pageIndex=${sessionScope.pageindex+1}"><span class="span2_lives">下一页</span></a></c:if>
   		<c:if test="${sessionScope.pageindex == sessionScope.pageCount}"><span class="span2_lives">尾页</span></c:if>
   		<c:if test="${sessionScope.pageindex != sessionScope.pageCount}"><a href="live_fenyes?pageIndex=${sessionScope.pageCount}"><span class="span2_lives">尾页</span></a></c:if>
    </c:if>
    <c:if test="${sessionScope.flag == 1 }">
       <!--账单表格 样式和供应商公用-->
      <table class="providerTable" cellpadding="0" cellspacing="0">
          <tr class="firstTr">
              <th width="10%">姓名</th>
              <th width="20%">入住天数</th>
              <th width="10%">所需价格</th>
              <th width="20%">预约时间</th>
              <th width="10%">电话号码</th>
              <th width="30%">操作</th>
          </tr>
          <c:forEach items="${sessionScope.listLike }" var="liveLike">
				<tr>
	    			<td>${liveLike.name}</td>
	    			<td>${liveLike.day}</td>
	    			<td>${liveLike.price}</td>
	    			<td><fmt:formatDate value="${liveLike.regtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	    			<td>${liveLike.phone}</td>
	    			<td>
					<span><a class="viewBill" href="live_getLiveRoom?id=${liveLike.id}"><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>
					<%-- <span><a class="modifyBill" href="live_getLiveRoom_2?id=${liveLike.id}"><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span> --%>
					<span><a class="deleteBill" href="live_delete?id=${liveLike.id}" onclick="return checkDelete()"><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
					</td>
				</tr>
			</c:forEach>		
      </table>
      <span class="span1_lives">当前页数:[${sessionScope.pageindexLike}/${sessionScope.pageCountLike}]</span>
   		<c:if test="${sessionScope.pageindexLike == 1}"><span class="span2_lives">首页</span></c:if>
   		<c:if test="${sessionScope.pageindexLike != 1}"><a href="live_mohu?pageIndexLike=1"><span class="span2_lives">首页</span></a></c:if>
   		<c:if test="${sessionScope.pageindexLike == 1}"><span class="span2_lives">上一页</span></c:if>
   		<c:if test="${sessionScope.pageindexLike != 1}"><a href="live_mohu?pageIndexLike=${sessionScope.pageindexLike-1}"><span class="span2_lives">上一页</span></a></c:if>
   		<c:if test="${sessionScope.pageindexLike == sessionScope.pageCountLike}"><span class="span2_lives">下一页</span></c:if>
   		<c:if test="${sessionScope.pageindexLike != sessionScope.pageCountLike}"><a href="live_mohu?pageIndexLike=${sessionScope.pageindexLike+1}"><span class="span2_lives">下一页</span></a></c:if>
   		<c:if test="${sessionScope.pageindexLike == sessionScope.pageCountLike}"><span class="span2_lives">尾页</span></c:if>
   		<c:if test="${sessionScope.pageindexLike != sessionScope.pageCountLike}"><a href="live_mohu?pageIndexLike=${sessionScope.pageCountLike}"><span class="span2_lives">尾页</span></a></c:if>
    </c:if>
  </div>
</section>
<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/billlist.js"></script>
