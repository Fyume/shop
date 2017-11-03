<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'cart.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/cart.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/cart.js">
	
</script>
<script type="text/javascript">
	function cart_ajax(obj, cart_id) {
		var xmlhttp;
		var num = obj.value;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			/*  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			 {
			 }*/
		}
		xmlhttp.open("GET",
				"${pageContext.request.contextPath}/cartupdate_servlet?num="
						+ num + "&cart_id=" + cart_id, true);
		xmlhttp.send();
	}
</script>
</head>
<body>
	<iframe src="${pageContext.request.contextPath }/pages/user/header.jsp"
		scrolling="no" style="border:none;width:100%;height:20%;"> </iframe>
	<div class="cart">
		<div class="cart_allselect">
			<input type="checkbox" onclick="allselect()">全选
		</div>
		<form id="cart_form" action="${pageContext.request.contextPath }/OrderServlet" method="post">
		<c:forEach items="${cartlist}" var="map">
			<div class="cart_single">
				<div class="cart_single_checkbox">
				
					<input type="checkbox" name="cart_single_checkbox_c"
						onclick="checkselected()"
						style="float:left;margin-left:30px;margin-top:30px;" value="${map.cart_id}">
				</div>
				<c:forTokens items="${map.images}" delims="," var="image"
					 begin="0" end="0">
					<div class="cart_single_img">
						<a href="Goods_servlet?${map.type}=${map.good_id}"> <img
							alt="商品图片"
							src="${pageContext.request.contextPath }/images/${image}"
							style="width:150px;height:100px;">
						</a>
					</div>
				</c:forTokens>
				<div class="cart_single_version">
					<div class="cart_single_version_v">${map.version }</div>
				</div>
				<div class="cart_single_num">
					<input class="cart_single_num_b1" type="button" value="-"
						onclick="dec_num(${map.cart_id})"> <input
						class="cart_single_num_text"
						id="cart_single_num_text${map.cart_id}" name="cart_single_num_text"
						type="text" value="${map.quantity }" onkeydown="checkit()"
						onblur="checknum()" onchange="cart_ajax(this,${map.cart_id})">
					<input class="cart_single_num_b2" type="button" value="+"
						onclick="add_num(${map.cart_id})">
				</div>
				<div class="cart_single_delete">
					<a id="cart_delete${map.cart_id}"
						href="${pageContext.request.contextPath }/cart_delete_servlet?cart_id=${map.cart_id}"
						style="display:none"></a>
					<div onclick="deleteit(${map.cart_id},'${pageContext.request.contextPath }/pages/user/cart.jsp')"
						style="cursor:pointer;font-size:18px;margin:10px;text-align:right;">删除</div>
				</div>
			</div>
		</c:forEach>
		</form>
		<div class="cart_pay">
			<input class="cart_pay_b" id="cart_pay_b" type="button" value="结算( )"
				onload="checkselected()" onclick="submitit()">
		</div>
	</div>
</body>
</html>
