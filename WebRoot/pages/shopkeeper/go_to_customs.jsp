<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="store_nav.jsp"%>


<center>
<div id="fahuo">
	<div id="fahuo_in">
		<h3 align="center">订单详情</h3>
		<form action="${pageContext.request.contextPath}/servlet/InStoreSearchServlet">
			<input type="hidden" value="${order_user_info.order_id }" name="order_id">
			<table align="center" border="1px">
				<tr>
					<th>下单人：</th><td>${order_user.nickname }</td>
				</tr>
				<tr>
					<th>收货地址 ：</th><td>${order_user.address }</td>
				</tr>
				<tr>
					<th>下单时间 ：</th><td>${order_user_info.time }</td>
				</tr>
				<tr>
					<th>商品数量 ：</th><td>${order_user_info.quantity }</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit" value="去发货"></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</center>
</div>
  </body>
</html>
