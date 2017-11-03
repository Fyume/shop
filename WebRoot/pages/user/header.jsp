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
<base href="<%=basePath%>">
<title>My JSP 'index.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/index.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/header.js">
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/header2.js"></script>
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/body.js">
</script>
<script type="text/javascript">
function cart_ajax()
{
var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
/*  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    }*/
  }
xmlhttp.open("GET","${pageContext.request.contextPath}/cartnum_servlet",true);
xmlhttp.send();
}
</script>
<body onload="cart_ajax()">
	<div class="header">
		<ul class="header_ul">
			<li class="header_left"><c:choose>
					<c:when
						test="${empty user}">
						<div class="header_left_browser">
							<a class="header_left_browser_a"
								href="${pageContext.request.contextPath }/pages/user/login.jsp"
								target="_top">亲，请登录</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="header_left_user">
							<div class="header_left_user_d-a" onmouseover="userinfo()"
								onmouseout="hidit()">
								<a class="header_left_user_a"
									href="${pageContext.request.contextPath}/pages/user/information.jsp"
									target="_blank">${sessionScope.user.nickname}</a>
							</div>
						</div>
						<div class="header_left_userinfo" id="header_left_userinfo"
							style="width:130px;float:left;height:55px;border:2px solid #c0c0c0;display:none"
							onmouseover="userinfo()" onmouseout="hidit()">
							<div class="header_left_user_d-image">
								<img class="header_left_user_image" alt="头像"
									src="${pageContext.request.contextPath}/images/${sessionScope.user.image }">
							</div>
							<div class="header_left_userinfo_out"
								style="float:right;width:70px;height:55px;text-align:right;">
								<a style="font-size:10px;" href="${pageContext.request.contextPath}/servlet/Cancel_Login" target="_top">退出</a>
							</div>
						</div>
							<li class="header_right">
								<div class="header_right_cart" style="display:inline">
									<a class="header_right_order_a"
										href="${pageContext.request.contextPath}/Cart_servlet"
										target="_blank"> 我的购物车<span style="color:red;font-weight:900;font-size:15px;">${sessionScope.cartnum }</span></a>
								</div>
								<div class="header_right_order" style="display:inline">
									<a class="header_right_order_a"
										href="${pageContext.request.contextPath}/intoOrderServlet"
										target="_blank"> 我的订单</a>
								</div> <c:choose>
									<c:when test="${sessionScope.user.role==2}">
										<div class="header_right_merchant" style="display:inline">
											<a class="header_right_merchant_a"
												href="${pageContext.request.contextPath }/servlet/MyStoreServlet"
												target="_blank"> 卖家中心</a>
										</div>
									</c:when>
									<c:otherwise>
										<div class="header_right_merchant" style="display:inline">
											<a class="header_right_merchant_a"
												href="${pageContext.request.contextPath}/pages/user/store_register.jsp"
												target="_blank"> 我要开店</a>
										</div>
									</c:otherwise>
								</c:choose>
							</li>
					</c:otherwise>
				</c:choose>
		</ul>
	</div>
	<br>
	<!-- header2 -->
	<div class="header2">
		<ul>
			<li class="header2_left"><a
				href="${pageContext.request.contextPath }/pages/user/index.jsp"
				target="_top"> <img alt="商城图标"
					src="${pageContext.request.contextPath}/images/taobao.jpg"
					style="position:absolute;left:220px;top:30px;width:145px;height:55px;text-align:center;">
			</a></li>
			<li>
				<div class="header2_center">
					<form id="select_form" action="servlet/FuzzySelect_servlet"
						target="_blank" method="post">
						<div class="header2_center_top">
							<div class="header2_center_top_Goods_selected"
								id="header2_center_top_Goods" onclick="Goodselect()">
								<input id="header2_center_top_Goods_radio"
									name="header2_center_top_type_radio" style="display:none"
									type="radio" value="商品" checked>商品
							</div>
							<div class="header2_center_top_Shop" id="header2_center_top_Shop"
								onclick="Shopselect()">
								<input id="header2_center_top_Shop_radio"
									name="header2_center_top_type_radio" style="display:none"
									type="radio" value="店铺">店铺
							</div>
						</div>
						<div class="header2_center_buttom">
							<fieldset
								style="width:675;height:35;background-color:#ff7624;border:0px;">
								<div>
									<input class="header2_center_select" id="select_input"
										name="select" type="text">
								</div>
								<div>
									<input class="header2_center_selectbutton" type="submit"
										value="搜 索">
								</div>
							</fieldset>
						</div>
					</form>
				</div>
			</li>
		</ul>
	</div>
	<br>
	<!-- body一部分（种类选择） -->
	<div class="body_type">
		<form id="body_type_form" action="servlet/Partial_servelet"
			method="post" target="view_body">
			<table>
				<td><input id="body_type_selected" class="body_type_selected"
					type="text" name="body_type_selected" /></td>
				<c:choose>
					<c:when test="${empty sessionScope.body_type_b1}">
						<td><input id="body_type_b1" class="body_type_b1_action"
							type="button" onclick="type_change1()" value="衣    服"></td>
						<td><input id="body_type_b2" class="body_type_b2"
							type="button" onclick="type_change2()" value="书    本"></td>
						<td><input id="body_type_b3" class="body_type_b3"
							type="button" onclick="type_change3()" value="食    物"></td>
					</c:when>
					<c:otherwise>
						<td><input id="body_type_b1"
							class="${sessionScope.body_type_b1}" type="button"
							onclick="type_change1()" value="衣    服"></td>
						<td><input id="body_type_b2"
							class="${sessionScope.body_type_b2}" type="button"
							onclick="type_change2()" value="书    本"></td>
						<td><input id="body_type_b3"
							class="${sessionScope.body_type_b3}" type="button"
							onclick="type_change3()" value="食    物"></td>
					</c:otherwise>
				</c:choose>
			</table>
		</form>
	</div>
</body>
</html>
