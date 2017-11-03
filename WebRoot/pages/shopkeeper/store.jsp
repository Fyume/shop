<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="store_nav.jsp" %>
	<!-- 还没有在主页面 展示 商品 
		店主登录进店铺后 先查到自己店铺 的所有商品后 在转到 该页面
		顾客 搜店铺 或者 点击 该店铺的某一个商品进入 店铺 前 也是要在servlet 中 查到 该店铺的所有商品 然后 做展示  
		只不过 店主能对商品进行编辑 而 顾客却不能
		
		暂且 先把所有的 商品信息 存在三个个 list  clothlist foodcloth bookcloth  里边 然后展现
		展示区 每四个 商品一行
		
		在前台页面中 顾客点击中 该店的商品 跳到 商品具体信息展示页面 点击进入店铺 那么就跳到 一个servlet(或者 店家 点击 进入我的店铺 同样先跳到 一个servlet中)
		在这个servlet 中 先检索出所有商品  由于 商品 有 食物 衣服 书籍 三类 所以 用 三个list 分类展示 到店铺首页
	-->
		<div id="show_goods_div_big">
			<div id="show_goods_div">
				<c:if test="${empty clothlist && empty booklist && empty foodlist}">
					<div id="nogoods">
						<div id="nogoodsfont">还没有任何商品哦~</div>
					</div>
				</c:if>
				<c:if test="${not empty clothlist}">
					
					<div id="show_goods_div_in_up">
						<div class="title"><strong>衣服类:</strong></div>
					</div>
					<c:forEach var="cloth" items="${clothlist }">
						<div class="show_goods_div_in">
							<div class="good_img">
							<a href="${pageContext.request.contextPath }/Goods_servlet?cloth=${cloth.cloth_id }">
							<c:forTokens var="cloth2" items="${cloth.images }" delims="," begin="0" end="0">
							<img alt="picture" src="${pageContext.request.contextPath }/images/${cloth2}" width="220px" height="250px">
							</c:forTokens>
							</a>
							</div>
							<div class="good_descrition">${cloth.description}</div>
							<div class="good_price_big">
								<div class="good_price"><font class="price_font">￥<strong>${cloth.price }</strong></font></div>
								<div class="good_totalnum"><font class="totalnum">库存:${cloth.totalnum }</font></div>
								<div class="good_manage">
									<c:if test="${user.role==2 }">
										<div class="good_modify">
											<a href="${pageContext.request.contextPath }/servlet/BeforeModifyGoodServlet?cloth_id=${cloth.cloth_id }">编辑</a>
										</div>
										 <div class="good_delete">
											<a href="javascript:void(0)" onclick="isdelete('${pageContext.request.contextPath }/servlet/DeletegoodServlet','cloth_id','${cloth.cloth_id }')">删除</a>
										</div>
									</c:if>
								</div>
							</div>
						</div>
						
					</c:forEach>
				</c:if>
				
				<c:if test="${not empty booklist}">
					<div id="show_goods_div_in_up">
						<div class="title_up"></div>
						<div class="title"><strong>书籍类:</strong></div>
						<div class="clear"></div>
						
					</div>
					<c:forEach var="book" items="${booklist }">
						<div class="show_goods_div_in">
							<div class="good_img">
							<a href="${pageContext.request.contextPath }/Goods_servlet?book=${book.book_id }">
							<img alt="picture" src="${pageContext.request.contextPath }/images/${book.images}" width="220px" height="250px">
							</a>
							</div>
							<div class="good_descrition">${book.description}</div>
							<div class="good_price_big">
								<div class="good_price"><font class="price_font">￥<strong>${book.price }</strong></font></div>
								<div class="good_totalnum"><font class="totalnum">库存:${book.totalnum }</font></div>
								<div class="good_manage">
									<c:if test="${user.role==2 }">
										<div class="good_modify">
											<a href="${pageContext.request.contextPath }/servlet/BeforeModifyGoodServlet?book_id=${book.book_id }">编辑</a>
										</div>
										<div class="good_delete">
											<a href="javascript:void(0)" onclick="isdelete('${pageContext.request.contextPath }/servlet/DeletegoodServlet','book_id','${book.book_id }')">删除</a>
										</div>
									</c:if>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
				
				
				<c:if test="${not empty foodlist}">
					<div id="show_goods_div_in_up">
						<div class="title_up"></div>
						<div class="title"><strong>食物类:</strong></div>
						<div class="clear"></div>
					</div>
					<c:forEach var="food" items="${foodlist }">
						<div class="show_goods_div_in">
							<div class="good_img">
							<a href="${pageContext.request.contextPath }/Goods_servlet?food=${food.food_id }">
							<img alt="picture" src="${pageContext.request.contextPath }/images/${food.images}" width="220px" height="250px">
							</a>
							</div>
							
							<div class="good_descrition">${food.description }</div>
							<div class="good_price_big">
								<div class="good_price"><font class="price_font">￥<strong>${food.price }</strong></font></div>
								<div class="good_totalnum"><font class="totalnum">库存:${food.totalnum }</font></div>
								<div class="good_manage">
								<c:if test="${user.role==2 }">
									<div class="good_modify">
										<a href="${pageContext.request.contextPath }/servlet/BeforeModifyGoodServlet?food_id=${food.food_id }">编辑</a>
									</div>
									<div class="good_delete">
										<a href="javascript:void(0)" onclick="isdelete('${pageContext.request.contextPath }/servlet/DeletegoodServlet','food_id','${food.food_id }')">删除</a>
									</div>
								</c:if>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
			
		</div>
				
   </div> <!--  </div>和 在 store_nav.jsp 的container div匹配 -->
  </body>
</html>
