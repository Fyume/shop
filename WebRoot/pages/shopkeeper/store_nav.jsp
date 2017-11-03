<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/store.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/store.js">
	
</script>
</head>
<body onload="changeTitle(${store.storename})">
	<div id="container">
		<div id="store_nav_big">
			<div id="store_nav">
				<div id="store_nav_div">
					<ul id="nav_ul_1">
						<li>
							<div>
								<c:choose>
									<c:when test="${empty user}">
										<a href="${pageContext.request.contextPath }/pages/user/login.jsp">亲，请登录</a>
										<a href="${pageContext.request.contextPath }/pages/user/register.jsp">免费注册</a>
									</c:when>
									<c:otherwise>
										<a href="${pageContext.request.contextPath }/servlet/ChangeInformationServlet">${user.nickname}</a>
									</c:otherwise>
								</c:choose>
							</div>
						</li>
					</ul>

					<ul id="nav_ul_2">
						<li>
							<div>
								<a
									href="${pageContext.request.contextPath }/pages/user/index.jsp">商城首页</a>
							</div>
						</li>
						<li>
							<div class="li_down">
								<c:choose>
									<c:when test="${empty user}">
										<a
											href="${pageContext.request.contextPath }/pages/user/login.jsp">我的小号</a>
									</c:when>
									<c:otherwise>
										<a
											href="${pageContext.request.contextPath }/pages/user/showOrder.jsp">我的小号</a>
									</c:otherwise>
								</c:choose>
								<ul>
									<li class="li_hover"><c:choose>
											<c:when test="${empty user}">
												<a
													href="${pageContext.request.contextPath }/pages/user/login.jsp">已买宝贝</a>
											</c:when>
											<c:otherwise>
												<a
													href="${pageContext.request.contextPath }/pages/user/showOrder.jsp">已买宝贝</a>
											</c:otherwise>
										</c:choose></li>
								</ul>
							</div>
						</li>
						<li>
							<div class="li_down">
								<c:choose>
									<c:when test="${empty user}">
										<a
											href="${pageContext.request.contextPath }/pages/shopkeeper/login.jsp">购物车</a>
									</c:when>
									<c:otherwise>
										<a
											href="${pageContext.request.contextPath }/pages/shopkeeper/showCartGood.jsp">购物车</a>
									</c:otherwise>
								</c:choose>
							</div>
						</li>
						<li class="li_down">
							<div id="store_div">
								<c:choose>
									<c:when test="${empty user}">
										<a
											href="${pageContext.request.contextPath }/pages/user/login.jsp">卖家中心</a>
									</c:when>
									<c:when test="${not empty user && user.role == 1}">
										<!-- 1表示 顾客 还没有开店 -->
										<a
											href="${pageContext.request.contextPath }/pages/shopkeeper/Builestore.jsp">卖家中心</a>
									</c:when>
									<c:otherwise>
										<a
											href="${pageContext.request.contextPath }/pages/shopkeeper/store.jsp">卖家中心</a>
									</c:otherwise>
								</c:choose>

								<div id="store_nav_down">
									<c:choose>
										<c:when test="${empty user}">
											<a
												href="${pageContext.request.contextPath }/pages/user/login.jsp">免费开店</a>
											<br>
										</c:when>
										<c:when test="${not empty user && user.role == 2}">
											<!-- 判断其是否为店家 2表示 为店家 那么进入店铺 -->
											<a
												href="${pageContext.request.contextPath }/pages/shopkeeper/store.jsp">免费开店</a>
										</c:when>
										<c:otherwise>
											<a
												href="${pageContext.request.contextPath }/pages/shopkeeper/Builestore.jsp">免费开店</a>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${empty user}">

											<a
												href="${pageContext.request.contextPath }/pages/user/login.jsp">已卖货品</a>
										</c:when>
										<c:when test="${not empty user && user.role == 2}">
											<!-- 判断其是否为店家 2表示 为店家 那么进入店铺 -->
											<a
												href="${pageContext.request.contextPath }/pages/shopkeeper/store.jsp">已卖货品</a>
										</c:when>
										<c:otherwise>
											<a
												href="${pageContext.request.contextPath }/pages/shopkeeper/Builestore.jsp">已卖货品</a>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>


			<div id="mid_find">
				<div id="in_mid_find">
					<div id="mid_up">
						<div id="mid_up_left">
							<a href="${pageContext.request.contextPath }/pages/user/index.jsp"><img
								alt="logo"
								src="${pageContext.request.contextPath }/images/logo2.jpg"
								width="210px" height="50px" /></a>
						</div>
						<div id="mid_up_right_search">
							<div id="search_panel">
								<form action="${pageContext.request.contextPath }/servlet/InStoreSearchServlet" method="post" class="form_class"  target="_blank" onsubmit="return checkoutinput_key()">
								<%-- <input type="hidden" value="${store.store_id }" name="store_id"> --%>
								<!-- 测试 先用 2代替 -->
								<input type="hidden" value="2" name="store_id">
									<div id="search_text_field">
										<div id="category_div_search">
											<select name="search_cat">
												<option value="store" selected>本店</option>
												<option value="shop">商城</option>
											</select>
										</div>
										<div id="search_div_right">
											<input type="text" id="input_search_key" name="searchGoodname" class="input_class" placeholer="输入关键字搜索" />
										</div>
										
									</div>
									<div id="search_button">
										<button class="btn_search_class" type="submit">搜索</button>
									</div>
								</form>
							</div>
						</div>
					</div>
					<div id="mid_down">
						<p class="p_class">
							<span class="left_span"> <span class="left_span"></span> <span
								class="left_span">店铺：</span> <span class="left_span">${store.storename }&nbsp;&nbsp;</span>
								<span class="left_span"> <a
									href="${pageContext.request.contextPath }/pages/shopkeeper/store.jsp">进入店铺</a>
							</span>
							</span> <span class="right_span"></span>
						</p>
					</div>
				</div>
			</div>

			<div style="width:100%;height:0px;border-top:1px black dashed;"></div>
			<div id="store_info_div">
				<div id="store_name_div">
					<div id="store_logo_div">
					<c:choose>
					<c:when test="${empty store.images }">
						<img alt="store_logo"
							src="${pageContext.request.contextPath }/images/store_logo.jpg"
							width="350px" height="120px" style="align:center" />
					</c:when>
					<c:otherwise>
						<img alt="store_logo"
								src="${pageContext.request.contextPath }/images/${store.images}"
								width="350px" height="120px" style="align:center" />
					</c:otherwise>
					</c:choose>
					</div>
				</div>
				<div id="again_store_nav_big">
					<div id="again_store_nav_big_mid">
						<ul class="ul_1"><!-- pages/shopkeeper/store.jsp -->
							<li class="li_1_again"><a href="${pageContext.request.contextPath }/servlet/AddGoodsServlet?store_id=2">首页</a></li>
							<li class="li_1_again"><a     
								href="${pageContext.request.contextPath }/servlet/AddFoodServlet?store_id=2">关于我们</a></li><%--测试先用2 代替 ${store_id } --%>
<%-- ${store.store_id} --%>
							<!-- 分类显示 不好做先 不做 -->    <%-- pages/shopkeeper/show_store_info.jsp?store_id=${store.store_id} --%>
							<%-- <li class="li_1_again">
								<div id="again_store_to_keeper">
									<a href="进入可以修改店铺信息的页面  modify_store.jsp">所有分类</a>
									<div id="again_hidden_2">
										<c:forEach var="category_string" items="${category }">
											<a href="show_category.jsp?">${category_string}</a><br>
										</c:forEach>
										<a href="modify_store.jsp">货物管理</a><br> <a
											href="modify_store.jsp">店铺管理</a><br>
										<!-- 可能会出现的错误  user_id含有中文   参数为中文-->
										<a href="store_order_manage.jsp?user_id=${user.user_id}">订单管理</a>
									</div>
								</div>
							</li>  --%>
							<li class="li_1_again" id="li_1_again_catogray">
								<div id="again_store_catogry">
									<a href="#">商品分类</a>   <!--  store_id  进入店铺前 要查到 该店铺的 bean -->
									<div id="again_hidden_3">
										<a
											href="${pageContext.request.contextPath }/servlet/CategroyServlet?goodtype=food&store_id=${store.store_id}">食品类</a><br>
										<a
											href="${pageContext.request.contextPath }/servlet/CategroyServlet?goodtype=cloth&store_id=${store.store_id}">衣服类</a><br>
										<!-- 可能会出现的错误  user_id含有中文   参数为中文-->
										<a
											href="${pageContext.request.contextPath }/servlet/CategroyServlet?goodtype=book&store_id=${store.store_id}">书籍类</a>
									</div>
								</div>
							</li>

						</ul>
						<ul class="ul_2">
							<c:if test="${user.role==2 }">   <!-- 如果是店主那么 显示管理店铺的 操作 -->
							<li class="li_2_again">
								<div id="again_store_to_keeper">
									<a href="">店铺管理</a>
									<div id="again_hidden_2">
										<a
											href="${pageContext.request.contextPath }/pages/shopkeeper/add_goods.jsp">添加商品</a><br>
										<a
											href="${pageContext.request.contextPath }/servlet/AddClothServlet?store_id=2">店铺管理</a><br>
										<!-- 可能会出现的错误  user_id含有中文   参数为中文    ${store.store_id}-->
										<a
											href="${pageContext.request.contextPath }/servlet/AddBookServlet?store_id=2">订单管理
											</a>
											<%-- pages/shopkeeper/store_order_manage.jsp?user_id=${user.user_id} --%>
									</div>
								</div>
							</li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>