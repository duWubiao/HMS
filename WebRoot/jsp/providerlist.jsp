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

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>房间管理页面</span>
        </div>
        
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0" style="margin-top:20px;">
            <tr class="firstTr">
                <th width="25%">房间类型</th>
                <th width="25%">房间号</th>
                <th width="25%">有无居住</th>
                <th width="25%">房间价格</th>
            </tr>
            <c:forEach items="${sessionScope.list }" var="list">
				<tr>
					<td>
					<span>${list.typename}</span>
					</td>
					<td>
					<span>${list.number}</span>
					</td>
					<td>
					<span>
						<c:if test="${list.ifendId == 1 }">有</c:if>
		    			<c:if test="${list.ifendId == 0 }">无</c:if>
	    			</span>
					</td>
					<td>
					<span>
						<c:if test="${list.type == 1 }">150</c:if>
						<c:if test="${list.type == 2 }">260</c:if>
						<c:if test="${list.type == 3 }">600</c:if>
					</span>
					</td>
				</tr>
			</c:forEach>
		
        </table>
        <span class="span1_lives">当前页数:[${sessionScope.pageindex}/${sessionScope.pageCount}]</span>
   		<c:if test="${sessionScope.pageindex == 1}"><span class="span2_lives">首页</span></c:if>
   		<c:if test="${sessionScope.pageindex != 1}"><a href="rooms_fenye?pageIndex=1"><span class="span2_lives">首页</span></a></c:if>
   		<c:if test="${sessionScope.pageindex == 1}"><span class="span2_lives">上一页</span></c:if>
   		<c:if test="${sessionScope.pageindex != 1}"><a href="rooms_fenye?pageIndex=${sessionScope.pageindex-1}"><span class="span2_lives">上一页</span></a></c:if>
   		<c:if test="${sessionScope.pageindex == sessionScope.pageCount}"><span class="span2_lives">下一页</span></c:if>
   		<c:if test="${sessionScope.pageindex != sessionScope.pageCount}"><a href="rooms_fenye?pageIndex=${sessionScope.pageindex+1}"><span class="span2_lives">下一页</span></a></c:if>
   		<c:if test="${sessionScope.pageindex == sessionScope.pageCount}"><span class="span2_lives">尾页</span></c:if>
   		<c:if test="${sessionScope.pageindex != sessionScope.pageCount}"><a href="rooms_fenye?pageIndex=${sessionScope.pageCount}"><span class="span2_lives">尾页</span></a></c:if>
    </div>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
   <div class="removerChid">
       <h2>提示</h2>
       <div class="removeMain" >
           <p>你确定要删除该供应商吗？</p>
           <a href="#" id="yes">确定</a>
           <a href="#" id="no">取消</a>
       </div>
   </div>
</div>

<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/providerlist.js"></script>
