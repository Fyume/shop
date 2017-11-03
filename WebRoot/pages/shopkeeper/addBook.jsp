<%@ page language="java" import="java.util.*" import="cn.edu.zhku.jsj.domain.Store" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="store_nav.jsp"%>

<!-- 所以如果是店主 进入到店铺 前 要去查数据库  将其信息 存在 request 域 或者 session域里边 因为要将属于该 店铺的商品 查出 并展现出来 -->
<%
	Store store = new Store();
	store.setStore_id(1);
	session.setAttribute("store", store);
 %>

<div class="add_good_big">
	<div class="add_good_in">
		<div class="add_good_in_up">
			<div id="div_font_class">
				<font style="font-size:18px;color:#ff4400">请完善上架书籍信息:</font>
			</div>
		</div>
		<div class="add_good_in_down">
			<form
				action="${pageContext.request.contextPath }/servlet/AddBookServlet?uuid=${formuuidnum}"
				method="post" onsubmit="return checkoutfilename()"
				enctype="multipart/form-data">
				<input type="hidden" value="${store.store_id }" name="store_id">
				<!-- 记住商品是属于哪家店铺的 所以添加商品前要 在session域存一个 store对象 -->
				<table border="0px">
					<tr>
						<!-- 光标离开 后触发js函数 onblur="isInput(this.value)" -->
						<th>书籍名称：</th>
						<td><input type="text" name="bookname"></td>
						<td><span> <font style="color:red;">${errormap.bookhname }</font>
						</span></td>
					</tr>
					<tr>
						<th>书籍单价：</th>
						<td><input type="text" name="price" placeholder="输入数字即可"></td>
						<td><span> <font style="color:red;">${errormap.price }</font>
						</span></td>
					</tr>
					<tr>
						<th>出版社：</th> 
						<td><input type="text" name="press"></td>
						<td><span> <font style="color:red;">${errormap.press}</font>
						</span></td>
					</tr>
					<tr>
						<th>ISBN：</th> 
						<td><input type="text" name="ISBN" placeholder="输入13位数字"></td>
						<td><span> <font style="color:red;">${errormap.ISBN}</font>
						</span></td>
					</tr>
					<tr>
						<th>书籍作者：</th>
						<td><input type="text" name="author" ></td>
						<td><span> <font style="color:red;">${errormap.author }</font>
						</span></td>
					</tr>
					<tr>
						<th>书籍版本：</th> <!-- 什么版本 有无光盘 电子书之类的 -->
						<td><input type="text" name="version" placeholder="版本之间用逗号隔开"></td>
						<td><span> <font style="color:red;">${errormap.version }</font>
						</span></td>
					</tr>
					<tr>
						<th>书籍库存：</th>
						<td><input type="text" name="totalnum" placeholder="输入数字即可"></td>
						<td><span><font style="color:red;">${errormap.totalnum }</font></span></td>
					</tr>
					<tr>
						<th>书籍描述：</th>
						<td><textarea name="description" rows="5" cols="40"></textarea></td>
						<td><span><font style="color:red;">${errormap.description }</font></span></td>
					</tr>
					<tr>
						<th>书籍图片：</th>
						<td>
							<input type="file" name="images" id="images">
							
						</td>
						<!-- <td><input type="file" name="images" id="images"></td> -->
						<td><span>${message }</span></td>
					</tr>
					<tr>
						<th>
							<input type="button" value="继续添加图片" onclick="fileadd()"><br>
						</th>
						<td>
							<div id="addfile"></div>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="发布" id="submit"> <input type="reset" value="重置"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>
<!-- <font style="font-size:18px;color:#ff4400">请完善上架食品信息:</font> -->
</div>
</body>
</html>
