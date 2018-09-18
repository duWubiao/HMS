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
</style>
<div class="right">
     <div class="location">
         <strong>你现在所在的位置是:</strong>
         <span>订单管理页面 >> 订单添加页面</span>
     </div>
     <div class="providerAdd">
     <table class="table1" width="800" style="padding: 0">
    			<tr>
    				<td><div class="div8">预定信息</div></td>
    				<td>
    					<table border="0" width="600" style="line-height: 30px;">
    						<!-- <tr>
    							<td width="70">入离日期</td>
    							<td><input type="text" name="data"/></td>
    						</tr> -->
    						<tr>
    							<td>入住天数</td>
    							<td><input type="text" size="3" name="live.day"/></td>
    						</tr>
    						<tr>
    							<td>住客姓名</td>
    							<td>
	    							<input type="text" size="16" placeholder="住客1" value="${sessionScope.user.name}" name="live.name"/>
    							</td>
    						</tr>
    						<tr>
    							<td></td>
    							<td><div class="div7">所填姓名需与入住时所持证件一致。</div></td>
    						</tr>
						<tr>
							<td>选择房间</td>
							<td><select id="room">
									<option value="0" selected="selected">请选择</option>
									<option value="1">单人间</option>
									<option value="2">双人间</option>
									<option value="3">豪华套房</option>
							</select><span id="span1"></span><span id="span2">房间号<select id="select2" name="room.number"></select></span>
							</td>
						</tr>
					</table>
    				</td>
    			</tr>			
				<tr>
    				<td>联系信息</td>
    				<td>
    					<table>
    						<tr>
    							<td width="70">手机号码</td>
    							<td><input type="text" value="${sessionScope.user.phone}" name="live.phone"/></td>
    						</tr>
    					</table>
    				</td>
    			</tr>
    			
    			<tr>
    				<td>发票信息</td>
    				<td><div class="div9">可具电子发票，纸质发票，增值税专用发票。订单成交后6个月内可补开。</div></td>
    			</tr>
    			<tr>
    				<td></td>
    				<td><input type="submit" value="立即预约"/></td>
    			</tr>
    		</table>
         
     </div>
 </div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/billadd.js"></script>