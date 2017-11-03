<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="store_nav.jsp" %>
  <div id="show_goods_div_big">
			<div id="show_goods_div">
				<c:if test="${good_cat_type == 'cloth'}">
					<c:choose>
						<c:when test="${empty clothlist_cat }">
							<div id="nogoods">
								<div id="nogoodsfont">sorry,我们还没上架衣服~</div>
							</div>
						</c:when>
						
						<c:otherwise>
						<div class="clear"></div>
							<c:forEach var="cloth" items="${clothlist_cat }">
							<div class="show_goods_div_in">
							<div class="good_img">
							<a href="${pageContext.request.contextPath }/Goods_servlet?cloth=${cloth.cloth_id }">
							<c:forTokens var="images2" items="${cloth.images }" delims="," begin="0" end="0">
							<img alt="picture" src="${pageContext.request.contextPath }/images/${images2}" width="220px" height="250px">
							</c:forTokens>
							</a>
							</div>
							<div class="good_descrition">${cloth.description}</div>
							<div class="good_price_big">
								<div class="good_price"><font class="price_font">￥<strong>${cloth.price }</strong></font></div>
								<div class="good_totalnum"><font class="totalnum">库存:${cloth.totalnum }</font></div>
								<div class="good_manage">
									<div class="good_modify">
										<a href="${pageContext.request.contextPath }/servlet/BeforeModifyGoodServlet?cloth_id=${cloth.cloth_id }">编辑</a>
									</div>
									<div class="good_delete">
										<a href="javascript:void(0)" onclick="isdelete('${pageContext.request.contextPath }/servlet/DeletegoodServlet','cloth_id','${cloth.cloth_id }')">删除</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					</c:otherwise>
				</c:choose>
			</c:if>
			
			<c:if test="${good_cat_type == 'book'}">
				<c:choose>
						<c:when test="${empty booklist_cat }">
							<div id="nogoods">
								<div id="nogoodsfont">sorry,我们还没上架书籍~</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="clear"></div>
							<c:forEach var="book" items="${booklist_cat }">
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
										<div class="good_modify">
											<a href="${pageContext.request.contextPath }/servlet/BeforeModifyGoodServlet?book_id=${book.book_id }">编辑</a>
										</div>
										<div class="good_delete">
											<a href="javascript:void(0)" onclick="isdelete('${pageContext.request.contextPath }/servlet/DeletegoodServlet','book_id','${book.book_id }')">删除</a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
						</c:otherwise>
				</c:choose>
			</c:if>
				
				<c:if test="${good_cat_type == 'food'}">
					<c:choose>
						<c:when test="${empty foodlist_cat }">
							<div id="nogoods">
								<div id="nogoodsfont">sorry,我们还没上架食物呢~</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="clear"></div>
							<c:forEach var="food" items="${foodlist_cat }">
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
									<div class="good_modify">
										<a href="${pageContext.request.contextPath }/servlet/BeforeModifyGoodServlet?food_id=${food.food_id }">编辑</a>
									</div>
									<div class="good_delete">
										<a href="javascript:void(0)" onclick="isdelete('${pageContext.request.contextPath }/servlet/DeletegoodServlet','food_id','${food.food_id }')">删除</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:if>
			</div>
   </div> <!--  </div>和 在 store_nav.jsp 的container div匹配 -->
  </body>
</html>
