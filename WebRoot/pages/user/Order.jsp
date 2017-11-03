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
    <title>My JSP 'Order.jsp' starting page</title>
  	<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/order.js">
</script>
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/Order.css">
  </head>
  
  <body>
  	<div style="text-align:center;">
  	<input type="button" value="未付款" onclick="state1()">
  	<input type="button" value="已付款" onclick="state2()">
  	<input type="button" value="已发货" onclick="state3()">
  	</div>
    <table id="state1_t">
    <tr><td>订单号</td><td>商品ID</td><td>店铺ID</td><td>商品数量</td><td>交易时间</td><td>交易总金额</td><td>操作</td></tr>
    <c:forEach items="${sessionScope.order_pay }" var="ol">
    <c:if test="${ol.state eq 1}">
    <tr><td>${ol.order_id }</td><td>${ol.good_id }</td><td>${ol.store_id }</td><td>${ol.quantity }</td><td>${ol.ordertime }</td><td>${ol.price }</td><td><a id="delete_a" href="${pageContext.request.contextPath }/order_delete_servlet?order_id=${ol.order_id }" style="display:none"></a><div onclick="deleteit()" style="cursor:pointer;">取消订单</div></td></tr>
    </c:if>
    </c:forEach>
    </table>
    <table id="state2_t" style="display:none">
    <tr><td>订单号</td><td>商品ID</td><td>店铺ID</td><td>商品数量</td><td>交易时间</td><td>交易总金额</td></tr>
    <c:forEach items="${sessionScope.order_pay }" var="ol">
    <c:if test="${ol.state eq 2}">
    <tr><td>${ol.order_id }</td><td>${ol.good_id }</td><td>${ol.store_id }</td><td>${ol.quantity }</td><td>${ol.ordertime }</td><td>${ol.price }</td></tr>
    </c:if>
    </c:forEach>
    </table>
    <table id="state3_t" style="display:none">
    <tr><td>订单号</td><td>商品ID</td><td>店铺ID</td><td>商品数量</td><td>交易时间</td><td>交易总金额</td></tr>
    <c:forEach items="${sessionScope.order_pay }" var="ol">
    <c:if test="${ol.state eq 3}">
    <tr><td>${ol.order_id }</td><td>${ol.good_id }</td><td>${ol.store_id }</td><td>${ol.quantity }</td><td>${ol.ordertime }</td><td>${ol.price }</td></tr>
    </c:if>
    </c:forEach>
    </table>
  </body>
</html>
