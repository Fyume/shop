<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<title>My JSP 'Goods.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/good.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/good.js">
</script>
<script type="text/javascript">
	function checkmessage() {
		if (${sessionScope.message }) {
			alert("已加入购物车");
		}
	}
</script>
</head>

<body onload="checkmessage()">
	<iframe src="${pageContext.request.contextPath }/pages/user/header.jsp"
		scrolling="no" style="border:none;width:100%;height:20%;"> </iframe>
	<div class="Goods">
		<div class="Goods_good">
			<c:if test="${sessionScope.Cloth_f }">
				<div class="Goods_good_i">
					<div class="Goods_good_i_cimg">
						<c:forTokens items="${Cloth.images }" var="icv" delims=","
							varStatus="icvs" begin="0" end="0">
							<img id="Goods_good_i_cimg_img" alt="商品中图"
								src="${pageContext.request.contextPath }/images/${icv}">
						</c:forTokens>
					</div>
					<div class="Goods_good_i_bimg"></div>
					<c:forTokens items="${Cloth.images }" var="isv" delims=","
						varStatus="isvs" begin="0" end="0">
						<div class="Goods_good_simg_selected" id="Goods_good_simg0">
							<img alt="商品小图${isvs.count }"
								src="${pageContext.request.contextPath }/images/${isv}"
								style="width:67px;height:67px;margin:auto;"
								onclick="img_change('${pageContext.request.contextPath }/images/${isv}',0)">
						</div>
					</c:forTokens>
					<c:forTokens items="${Cloth.images }" var="isv" delims=","
						varStatus="isvs" begin="1" end="4">
						<div class="Goods_good_simg" id="Goods_good_simg${isvs.count}">
							<img alt="商品小图${isvs.count }"
								src="${pageContext.request.contextPath }/images/${isv}"
								style="width:67px;height:67px;margin:auto;"
								onclick="img_change('${pageContext.request.contextPath }/images/${isv}','${isvs.count }')">
						</div>
					</c:forTokens>
				</div>
				<div class="Goods_good_type">
					<div class="Goods_good_type_title">${Cloth.description }</div>
					<div class="Goods_good_type_left">价格:</div>
					<div class="Goods_good_type_price">￥${Cloth.price }</div>
					<div class="Goods_good_type_left">颜色:</div>
					<form id="Goods_good_type_form_c"
						action="${pageContext.request.contextPath }/PayOrIntoCart_servlet"
						method="post">
						<input type="text" class="Goods_good_type_t"
							name="Goods_good_type_t" value="cloth"> <input
							type="text" class="Goods_good_type_price_text"
							name="Goods_good_type_price_text" value="${Cloth.price }">
						<div class="Goods_good_type_c">
							<c:forTokens items="${Cloth.color }" delims="," var="cv"
								varStatus="cvs">
								<div class="Goods_good_type_c_color"
									id="Goods_good_type_c_color${cvs.count }"
									onclick="color_selected(${cvs.count})">
									<input type="radio" id="Goods_good_type_c_color${cvs.count}"
										name="Goods_good_type_c_color" value="${cv}"
										style="display:none" checked>${cv}
								</div>
							</c:forTokens>
						</div>
						<div class="Goods_good_type_left">套餐:</div>
						<div class="Goods_good_type_v">
							<c:forTokens items="${Cloth.version }" delims="," var="vv"
								varStatus="vvs">
								<div class="Goods_good_type_v_version"
									id="Goods_good_type_v_version${vvs.count}"
									onclick="version_selected(${vvs.count})">
									<input type="radio" id="Goods_good_type_v_version${vvs.count}"
										name="Goods_good_type_v_version" value="${vv}"
										style="display:none;" checked>${vv}
								</div>
							</c:forTokens>
						</div>
						<div class="Goods_good_type_left">数量:</div>
						<div class="Goods_good_type_num">
							<input class="Goods_good_type_num_b1" type="button" value="-"
								onclick="dec_num()"> <input
								class="Goods_good_type_num_text" id="Goods_good_type_num_text"
								name="Goods_good_type_num_text" type="text" value="1"
								onkeydown="checkit()" onblur="checknum()"> <input
								class="Goods_good_type_num_b2" type="button" value="+"
								onclick="add_num()">
						</div>
						<div class="Goods_good_type_pay">
							<input type="text" name="BusinessType"
								id="Goods_good_type_pay_text"> <input
								class="Goods_good_type_pay_b1" type="button" value="立即购买"
								onclick="payit_c()"> <input
								class="Goods_good_type_pay_b2" type="button" value="加入购物车"
								onclick="intoCart_c()"> <input type="text"
								class="Goods_good_type_id" name="cloth_id"
								value="${Cloth.cloth_id}">
						</div>
					</form>
				</div>
			</c:if>
			<c:if test="${sessionScope.Book_f }">
				<div class="Goods_good_i">
					<div class="Goods_good_i_cimg">
						<c:forTokens items="${Book.images }" var="icv" delims=","
							varStatus="icvs" begin="0" end="0">
							<img id="Goods_good_i_cimg_img" alt="商品中图"
								src="${pageContext.request.contextPath }/images/${icv}">
						</c:forTokens>
					</div>
					<div class="Goods_good_i_bimg"></div>
					<c:forTokens items="${Book.images }" var="isv" delims=","
						varStatus="isvs" begin="0" end="0">
						<div class="Goods_good_simg_selected" id="Goods_good_simg0">
							<img alt="商品小图${isvs.count }"
								src="${pageContext.request.contextPath }/images/${isv}"
								style="width:67px;height:67px;margin:auto;"
								onclick="img_change('${pageContext.request.contextPath }/images/${isv}',0)">
						</div>
					</c:forTokens>
					<c:forTokens items="${Book.images }" var="isv" delims=","
						varStatus="isvs" begin="1" end="4">
						<div class="Goods_good_simg" id="Goods_good_simg${isvs.count}">
							<img alt="商品小图${isvs.count }"
								src="${pageContext.request.contextPath }/images/${isv}"
								style="width:67px;height:67px;margin:auto;"
								onclick="img_change('${pageContext.request.contextPath }/images/${isv}','${isvs.count }')">
						</div>
					</c:forTokens>
				</div>
				<div class="Goods_good_type">
					<div class="Goods_good_type_title">${Book.description }</div>
					<div class="Goods_good_type_left">价格:</div>
					<div class="Goods_good_type_price">￥${Book.price }</div>
					<form id="Goods_good_type_form_b"
						action="${pageContext.request.contextPath }/PayOrIntoCart_servlet"
						method="post">
						<input type="text" class="Goods_good_type_t"
							name="Goods_good_type_t" value="book"> <input type="text"
							class="Goods_good_type_price_text"
							name="Goods_good_type_price_text" value="${Book.price }">
						<div class="Goods_good_type_left">套餐:</div>
						<div class="Goods_good_type_v">
							<c:forTokens items="${Book.version }" delims=";" var="vv"
								varStatus="vvs">
								<div class="Goods_good_type_v_version"
									id="Goods_good_type_v_version${vvs.count}"
									onclick="version_selected(${vvs.count})">
									<input type="radio" id="Goods_good_type_v_version${vvs.count}"
										name="Goods_good_type_v_version" value="${vv}"
										style="display:none;" checked>${vv}
								</div>
							</c:forTokens>
						</div>
						<div class="Goods_good_type_left">数量:</div>
						<div class="Goods_good_type_num">
							<input class="Goods_good_type_num_b1" type="button" value="-"
								onclick="dec_num()"> <input
								class="Goods_good_type_num_text" id="Goods_good_type_num_text"
								name="Goods_good_type_num_text" type="text" value="1"
								onkeydown="checkit()" onblur="checknum()"> <input
								class="Goods_good_type_num_b2" type="button" value="+"
								onclick="add_num()">
						</div>
						<div class="Goods_good_type_pay">
							<input type="text" name="BusinessType"
								id="Goods_good_type_pay_text"> <input
								class="Goods_good_type_pay_b1" type="button" value="立即购买"
								onclick="payit_b()"> <input
								class="Goods_good_type_pay_b2" type="button" value="加入购物车"
								onclick="intoCart_b()"> <input type="text"
								class="Goods_good_type_id" name="book_id"
								value="${Book.book_id}">
						</div>
					</form>
				</div>
			</c:if>
			<c:if test="${sessionScope.Food_f }">
				<div class="Goods_good_i">
					<div class="Goods_good_i_cimg">
						<c:forTokens items="${Food.images }" var="icv" delims=","
							varStatus="icvs" begin="0" end="0">
							<img id="Goods_good_i_cimg_img" alt="商品中图"
								src="${pageContext.request.contextPath }/images/${icv}">
						</c:forTokens>
					</div>
					<div class="Goods_good_i_bimg"></div>
					<c:forTokens items="${Food.images }" var="isv" delims=","
						varStatus="isvs" begin="0" end="0">
						<div class="Goods_good_simg_selected" id="Goods_good_simg0">
							<img alt="商品小图${isvs.count }"
								src="${pageContext.request.contextPath }/images/${isv}"
								style="width:67px;height:67px;margin:auto;"
								onclick="img_change('${pageContext.request.contextPath }/images/${isv}',0)">
						</div>
					</c:forTokens>
					<c:forTokens items="${Food.images }" var="isv" delims=","
						varStatus="isvs" begin="1" end="4">
						<div class="Goods_good_simg" id="Goods_good_simg${isvs.count}">
							<img alt="商品小图${isvs.count }"
								src="${pageContext.request.contextPath }/images/${isv}"
								style="width:67px;height:67px;margin:auto;"
								onclick="img_change('${pageContext.request.contextPath }/images/${isv}','${isvs.count }')">
						</div>
					</c:forTokens>
				</div>
				<div class="Goods_good_type">
					<div class="Goods_good_type_title">${Food.description }</div>
					<div class="Goods_good_type_left">价格:</div>
					<div class="Goods_good_type_price">￥${Food.price }</div>
					<form id="Goods_good_type_form_f"
						action="${pageContext.request.contextPath }/PayOrIntoCart_servlet"
						method="post">
						<input type="text" class="Goods_good_type_t"
							name="Goods_good_type_t" value="food"> <input type="text"
							class="Goods_good_type_price_text"
							name="Goods_good_type_price_text" value="${Food.price }">
						<div class="Goods_good_type_left">数量:</div>
						<div class="Goods_good_type_num">
							<input class="Goods_good_type_num_b1" type="button" value="-"
								onclick="dec_num()"> <input
								class="Goods_good_type_num_text" id="Goods_good_type_num_text"
								name="Goods_good_type_num_text" type="text" value="1"
								onkeydown="checkit()" onblur="checknum()"> <input
								class="Goods_good_type_num_b2" type="button" value="+"
								onclick="add_num()">
						</div>
						<div class="Goods_good_type_pay">
							<input type="text" name="BusinessType"
								id="Goods_good_type_pay_text"> <input
								class="Goods_good_type_pay_b1" type="button" value="立即购买"
								onclick="payit_f()"> <input
								class="Goods_good_type_pay_b2" type="button" value="加入购物车"
								onclick="intoCart_f()"> <input type="text"
								class="Goods_good_type_id" name="food_id"
								value="${Food.food_id}">
						</div>
					</form>
				</div>
			</c:if>
		</div>
	</div>
	<div class="Goods_shop">
		<div class="Goods_shop_i">
			<a
				href="${pageContext.request.contextPath }/intoStore_servlet?store=${sessionScope.store.store_id}"
				target="_blank"> <img class="Goods_shop_i_img" alt="店家图片"
				src="${pageContext.request.contextPath }/images/${sessionScope.store.images}">
			</a>
		</div>
		<div class="Goods_shop_s">
			<a id="Goods_shop_s_storename" class="Goods_shop_s_storename"
				href="${pageContext.request.contextPath }/intoStore_servlet?store=
				${sessionScope.store.store_id}"
				target="_blank"> ${sessionScope.store.storename }</a>
		</div>
		<div class="Goods_shop_o">
			<a class="Goods_shop_o_ownername"
				href="${pageContext.request.contextPath }/intoStore_servlet?store=
				${sessionScope.store.store_id}"
				target="_blank"> ${sessionScope.owner.nickname }</a>
		</div>
		<div class="Goods_shop_b">
			<input class="Goods_shop_b_button" type="button"
				onclick="intoStore()" value="进入店铺">
		</div>
	</div>

</body>
</html>
