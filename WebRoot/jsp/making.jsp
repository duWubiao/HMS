<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'making.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/css/making.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.8.3.min.js"></script>
  	<script type="text/javascript">
		$(document).ready(function(){
			$("#room").blur(function(){
				$.get("room_number","room.type="+$("#room").val(),function(data){
				var flag = data.flag;
				if(flag == "false"){
					$("#span1").html(data.result);
					$("#span2").hide();
				}else if(flag == "true"){
					var option = "";
					for(var i=0;i<data.list.length;i++){
						option += "<option value='"+data.list[i]+"'>"+data.list[i]+"</option>";
					}
					$("#select2").html(option);
					$("#span1").html("");
					$("#span2").show().html();		
				}
			});
			});
		});
  	</script>
  </head>
  
  <body>
    	<div class="div1">
    	<div id="div2">
    		<div class="div2"><img src="${pageContext.request.contextPath }/statics/images/3.png"/></div>
    		<div class="div3">谢谢你长得这么好看还选我们酒店</div>
    	</div>
    		<div class="div4"><img src="${pageContext.request.contextPath }/statics/images/2.png"/></div>
    	</div>
    	
    	<form action="live_make" class="form" method="post">
    	<c:if test="${sessionScope.user == null }">
    	<div class="div5">
    		<div class="div2"><img src="${pageContext.request.contextPath }/statics/images/1.png"/></div>
    		<div class="div6">现在<a href="">登录</a>可享受折扣、专属服务等优惠。</div>
    	</div>
    	</c:if>
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
    	</form>
  </body>
</html>
