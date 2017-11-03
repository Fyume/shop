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
<title>My JSP 'body.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/index.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/body.js">
	
</script>
</head>

<body>
	<div class="body">
		<div class="body_good">
			<c:if test="${sessionScope.body_list_c_flag}">
				<br>
				<br>
				<br>
				<div class="body_good_total">
					<c:forEach var="c" items="${sessionScope.body_list_c}">
						<div class="body_good_total_c">
							<div>
							<c:if test="${empty c.images }">
								<a
									href="Goods_servlet?cloth=${c.cloth_id}"
									target="_blank"> <img class="body_good_total_f_img"
									alt="商品图片"
									src="${pageContext.request.contextPath }/images/aaaaa">
								</a>
								</c:if>
							<c:forTokens items="${c.images }" var="image" delims="," begin="0" end="0">
								<a href="Goods_servlet?cloth=${c.cloth_id}" target="_blank">
									<img class="body_good_total_c_img" alt="商品图片"
									src="${pageContext.request.contextPath }/images/${image }">
								</a>
								</c:forTokens>
							</div>
							<div
								style="font-size:20;font-family:宋体;font-weight:400;width:190px;height:10px;">
								<a href="Goods_servlet?cloth=${c.cloth_id}"
									target="_blank" style="font-weight:500;color:red">￥${c.price}</a>
							</div>
							<div
								style="font-size:20;font-family:宋体;font-weight:200;float:left;width:110px;height:190px;text-align:left">
								<a	style="color:black;" href="Goods_servlet?cloth=${c.cloth_id}"
									target="_blank">${c.description}</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:if>
			<c:if test="${sessionScope.body_list_b_flag}">
				<br>
				<br>
				<br>
				<div class="body_good_total">
					<c:forEach var="b" items="${sessionScope.body_list_b}">
						<div class="body_good_total_b">
							<div>
							<c:if test="${empty b.images }">
								<a
									href="Goods_servlet?book=${b.book_id}"
									target="_blank"> <img class="body_good_total_f_img"
									alt="商品图片"
									src="${pageContext.request.contextPath }/images/aaaaa">
								</a>
								</c:if>
							<c:forTokens items="${b.images }" var="image" delims="," begin="0" end="0">
								<a
									href="Goods_servlet?book=${b.book_id}"
									target="_blank"> <img class="body_good_total_b_img"
									alt="商品图片"
									src="${pageContext.request.contextPath }/images/${image }">
								</a>
								</c:forTokens>
							</div>
							<div
								style="font-size:20;font-family:宋体;font-weight:400;width:190px;height:10px">
								<a
									href="Goods_servlet?book=${b.book_id}"
									target="_blank" style="font-weight:500;color:red">￥${b.price}</a>
							</div>
							<div
								style="font-size:20;font-family:宋体;font-weight:200;float:left;width:110px;height:190px;text-align:left">
								<a	style="color:black;"
									href="Goods_servlet?book=${b.book_id}"
									target="_blank">${b.description}</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:if>
			<c:if test="${sessionScope.body_list_f_flag}">
				<br>
				<br>
				<br>
				<div class="body_good_total">
					<c:forEach var="f" items="${sessionScope.body_list_f}">
						<div class="body_good_total_f" style="display:inline">
							<div>
							<c:if test="${empty f.images}">
								<a
									href="Goods_servlet?food=${f.food_id}"
									target="_blank"> <img class="body_good_total_f_img"
									alt="商品图片"
									src="${pageContext.request.contextPath }/images/aaaaa">
								</a>
								</c:if>
							<c:forTokens items="${f.images }" var="image" delims="," begin="0" end="0">
								<a
									href="Goods_servlet?food=${f.food_id}"
									target="_blank"> <img class="body_good_total_f_img"
									alt="商品图片"
									src="${pageContext.request.contextPath }/images/${image}">
								</a>
								</c:forTokens>
							</div>
							<div
								style="font-size:20;font-family:宋体;font-weight:400;width:190px;height:10px">
								<a
									href="Goods_servlet?food=${f.food_id}"
									target="_blank" style="font-weight:500;color:red">￥${f.price}</a>
							</div>
							<div
								style="font-size:20;font-family:宋体;font-weight:200;float:left;width:110px;height:190px;text-align:left">
								<a style="color:black;"
									href="Goods_servlet?food=${f.food_id}"
									target="_blank">${f.description}</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>
