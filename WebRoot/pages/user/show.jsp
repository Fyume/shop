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
<title>My JSP 'show.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/index.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/show.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/show.js">
	
</script>
</head>

<body>
	<iframe src="${pageContext.request.contextPath }/pages/user/header.jsp"
		scrolling="no" style="border:none;width:100%;height:20%;"> </iframe>
	<div class="body_good_total">
		<c:if test="${sessionScope.Fuzz_flag=='goods'}">
			<div style="width:1300px;float:left;">
				<c:choose>
					<c:when test="${empty sessionScope.Fuzzlist_c }">
					</c:when>
					<c:otherwise>
						<div class="show_type">衣服：</div>
						<c:forEach var="c" items="${sessionScope.Fuzzlist_c}" begin="0"
							end="7">
							<div class="body_good_total_c">
								<div>
									<c:if test="${empty c.images }">
										<a href="Goods_servlet?cloth=${c.cloth_id}" target="_blank">
											<img class="body_good_total_f_img" alt="商品图片"
											src="${pageContext.request.contextPath }/images/aaaaa">
										</a>
									</c:if>
									<c:forTokens items="${c.images }" var="image" delims=","
										begin="0" end="0">
										<a href="Goods_servlet?cloth=${c.cloth_id}" target="_blank">
											<img class="body_good_total_c_img" alt="商品图片"
											src="${pageContext.request.contextPath }/images/${image }">
										</a>
									</c:forTokens>
								</div>
								<div
									style="font-size:20;font-family:宋体;font-weight:400;width:190px;height:10px;">
									<a href="Goods_servlet?cloth=${c.cloth_id}" target="_blank"
										style="font-weight:500;color:red">￥${c.price}</a>
								</div>
								<div
									style="font-size:20;font-family:宋体;font-weight:200;float:left;width:110px;height:190px;text-align:left">
									<a style="color:black;"
										href="Goods_servlet?cloth=${c.cloth_id}" target="_blank">${c.description}</a>
								</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
			<div style="width:1300px;float:left;">
				<c:choose>
					<c:when test="${empty sessionScope.Fuzzlist_b }">
					</c:when>
					<c:otherwise>
						<div class="show_type">书本：</div>
						<c:forEach var="b" items="${sessionScope.Fuzzlist_b}" begin="0"
							end="7">
							<div class="body_good_total_b">
								<div>
									<c:if test="${empty b.images }">
										<a href="Goods_servlet?book=${b.book_id}" target="_blank">
											<img class="body_good_total_f_img" alt="商品图片"
											src="${pageContext.request.contextPath }/images/aaaaa">
										</a>
									</c:if>
									<c:forTokens items="${b.images }" var="image" delims=","
										begin="0" end="0">
										<a href="Goods_servlet?book=${b.book_id}" target="_blank">
											<img class="body_good_total_b_img" alt="商品图片"
											src="${pageContext.request.contextPath }/images/${image }">
										</a>
									</c:forTokens>
								</div>
								<div
									style="font-size:20;font-family:宋体;font-weight:400;width:190px;height:10px">
									<a href="Goods_servlet?book=${b.book_id}" target="_blank"
										style="font-weight:500;color:red">￥${b.price}</a>
								</div>
								<div
									style="font-size:20;font-family:宋体;font-weight:200;float:left;width:110px;height:190px;text-align:left">
									<a style="color:black;" href="Goods_servlet?book=${b.book_id}"
										target="_blank">${b.description}</a>
								</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
			<div style="width:1300px;float:left;">
				<c:choose>
					<c:when test="${empty sessionScope.Fuzzlist_f }">
					</c:when>
					<c:otherwise>
						<div class="show_type">食物：</div>
						<c:forEach var="f" items="${sessionScope.Fuzzlist_f}" begin="0"
							end="7">
							<div class="body_good_total_f" style="display:inline">
								<div>
									<c:if test="${empty f.images}">
										<a href="Goods_servlet?food=${f.food_id}" target="_blank">
											<img class="body_good_total_f_img" alt="商品图片"
											src="${pageContext.request.contextPath }/images/aaaaa">
										</a>
									</c:if>
									<c:forTokens items="${f.images }" var="image" delims=","
										begin="0" end="0">
										<a href="Goods_servlet?food=${f.food_id}" target="_blank">
											<img class="body_good_total_f_img" alt="商品图片"
											src="${pageContext.request.contextPath }/images/${image}">
										</a>
									</c:forTokens>
								</div>
								<div
									style="font-size:20;font-family:宋体;font-weight:400;width:190px;height:10px">
									<a href="Goods_servlet?food=${f.food_id}" target="_blank"
										style="font-weight:500;color:red">￥${f.price}</a>
								</div>
								<div
									style="font-size:20;font-family:宋体;font-weight:200;float:left;width:110px;height:190px;text-align:left">
									<a style="color:black;" href="Goods_servlet?food=${f.food_id}"
										target="_blank">${f.description}</a>
								</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</c:if>
		<c:if test="${sessionScope.Fuzz_flag=='stores'}">
			<c:choose>
				<c:when test="${empty sessionScope.Fuzzlist_s}">
					<div>没有找到相关店铺</div>
				</c:when>
				<c:otherwise>
					<c:forEach items="${sessionScope.Fuzzlist_s }" var="store">
						<div class="show_shop"
							style="border:2px solid #c0c0c0;width:193px;margin-top:5px;">
							<div class="show_shop_i">
								<a
									href="${pageContext.request.contextPath }/intoStore_servlet?store=${sessionScope.store.store_id}"
									target="_blank"> <img class="Goods_shop_i_img" alt="店家图片"
									src="${pageContext.request.contextPath }/images/${store.images}">
								</a>
							</div>
							<div class="Goods_shop_s">
							<div style="width:50px;height:40px;float:left;font-size:15px;margin-top:10px">店名:</div>
								<a id="Goods_shop_s_storename" class="Goods_shop_s_storename" style="margin-left:-40px;"
									href="${pageContext.request.contextPath }/intoStore_servlet?store=
				${store.store_id}"
									target="_blank"> ${store.storename }</a>
							</div>
							<div class="Goods_shop_b">
								<input class="Goods_shop_b_button" type="button"
									onclick="intoStore()" value="进入店铺">
							</div>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</c:if>
	</div>

</body>
</html>
