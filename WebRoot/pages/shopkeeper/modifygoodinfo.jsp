<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="store_nav.jsp"%>

<div class="add_good_big">
	<div class="add_good_in">
		<div class="add_good_in_up">
			<div id="div_font_class">
				<font style="font-size:18px;color:#ff4400">编辑商品信息:</font>
			</div>
		</div>
		<div calss="clear"></div>
		<div class="add_good_in_down">
			
				<form
					action="${pageContext.request.contextPath }/servlet/ModifyGoodServlet"
					method="post">
					<input type="hidden" name="uuid" value="${moduuidnum }">
					<input type="hidden" name="good_type" value="${good_type }">
					<input type="hidden" name="store_id" value="${store_id}">
					
					<table border="0px" align="center">
					<c:choose>
					<c:when test="${good_type=='book_id'}">
					<input type="hidden" value="${modify_book.book_id }" name="book_id">
					<!-- 记住 要修改的是 哪本书 -->
					
						<tr>
							<!-- 光标离开 后触发js函数 onblur="isInput(this.value)" -->
							<th>书本名称：</th>
							<td><input type="text" name="bookname" value="${modify_book.bookname}"></td>
							<td><span> <font style="color:red;">${errormap.bookname }</font>
							</span></td>
						</tr>
						<tr>
							<th>书籍作者：</th>
							<td><input type="text" name="author" value="${modify_book.author }"></td>
							<td><span> <font style="color:red;">${errormap.author }</font>
							</span></td>
						</tr>
						<tr>
							<th>出版社：</th>
							<td><input type="text" name="press" value="${modify_book.press }"></td>
							<td><span> <font style="color:red;">${errormap.press}</font>
							</span></td>
						</tr>
						<tr>
							<th>ISBN：</th>
							<td><input type="text" name="ISBN" value="${modify_book.ISBN }"></td>
							<td><span> <font style="color:red;">${errormap.ISBN}</font>
							</span></td>
						</tr>
						<tr>
							<th>书本单价：</th>
							<td><input type="text" name="price" value="${modify_book.price }"></td>
							<td><span> <font style="color:red;">${errormap.price }</font>
							</span></td>
						</tr>
						<tr>
							<th>书籍版本：</th>
							<td><input type="text" name="version" value="${modify_book.version }"></td>
							<td><span> <font style="color:red;">${errormap.version }</font>
							</span></td>
						</tr>
						
						<tr>
							<th>书本库存：</th>
							<td><input type="text" name="totalnum" value="${modify_book.totalnum }"></td>
							<td><span><font style="color:red;">${errormap.totalnum }</font></span></td>
						</tr>
						<tr>
							<th>商品描述：</th>
							<td><textarea style="resize:none" name="description" rows="5" cols="40" >${modify_book.description }</textarea></td>
							<td><span><font style="color:red;">${errormap.description }</font></span></td>
						</tr>
						
						<tr>
							<td colspan="2" align="center"><input type="submit"
								value="修改" id="submit"> <input type="reset" value="重置"></td>
						</tr>
					<!-- </table> -->
					</c:when>
					
					<c:when test="${good_type=='food_id'}">
					<input type="hidden" value="${modify_food.food_id }" name="food_id">
					<!-- 记住 要修改的是 哪本书 -->
					<!-- <table border="0px"> -->
						<tr>
							<!-- 光标离开 后触发js函数 onblur="isInput(this.value)" -->
							<th>食品名称：</th>
							<td><input type="text" name="foodname" value="${modify_food.foodname}"></td>
							<td><span> <font style="color:red;">${errormap.foodname }</font>
							</span></td>
						</tr>
						<tr>
							<th>食品单价：</th>
							<td><input type="text" name="price" value="${modify_food.price }"></td>
							<td><span> <font style="color:red;">${errormap.price }</font>
							</span></td>
						</tr>
						<tr>
							<th>商品库存：</th>
							<td><input type="text" name="totalnum" value="${modify_food.totalnum }"></td>
							<td><span><font style="color:red;">${errormap.totalnum }</font></span></td>
						</tr>
						<tr>
							<th>商品描述：</th>
							<td><textarea style="resize:none" name="description" rows="5" cols="40" >${modify_food.description }</textarea></td>
							<td><span><font style="color:red;">${errormap.description }</font></span></td>
						</tr>
						
						<tr>
							<td colspan="2" align="center"><input type="submit"
								value="修改" id="submit"> <input type="reset" value="重置"></td>
						</tr>
					<!-- </table> -->
					</c:when>
					
					<c:otherwise>
						<input type="hidden" value="${modify_cloth.cloth_id }" name="cloth_id">
					<!-- 记住 要修改的是 哪本书 -->
					<!-- <table border="0px"> -->
						<tr>
							<!-- 光标离开 后触发js函数 onblur="isInput(this.value)" -->
							<th>衣服名称：</th>
							<td><input type="text" name="clothname" value="${modify_cloth.clothname}"></td>
							<td><span> <font style="color:red;">${errormap.clothname }</font>
							</span></td>
						</tr>
						<tr>
							<th>衣服单价：</th>
							<td><input type="text" name="price" value="${modify_cloth.price }"></td>
							<td><span> <font style="color:red;">${errormap.price }</font>
							</span></td>
						</tr>
						<tr>
							<th>衣服款式：</th>
							<td><input type="text" name="version" value="${modify_cloth.version }"></td>
							<td><span> <font style="color:red;">${errormap.version }</font>
							</span></td>
						</tr>
						<tr>
							<th>衣服码数：</th>
							<td><input type="text" name="size" value="${modify_cloth.size }"></td>
							<td><span> <font style="color:red;">${errormap.size }</font>
							</span></td>
						</tr>
						<tr>
							<th>衣服颜色：</th>
							<td><input type="text" name="color" value="${modify_cloth.color }"></td>
							<td><span> <font style="color:red;">${errormap.color }</font>
							</span></td>
						</tr>
						<tr>
							<th>商品库存：</th>
							<td><input type="text" name="totalnum" value="${modify_cloth.totalnum }"></td>
							<td><span><font style="color:red;">${errormap.totalnum }</font></span></td>
						</tr>
						<tr>
							<th>商品描述：</th>
							<td><textarea style="resize:none" name="description" rows="5" cols="40" >${modify_cloth.description }</textarea></td>
							<td><span><font style="color:red;">${errormap.description }</font></span></td>
						</tr>
						
						<tr>
							<td colspan="2" align="center"><input type="submit"
								value="修改" id="submit"> <input type="reset" value="重置"></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
					
			</form>
		</div>
	</div>
</div>

</div>
</body>
</html>
