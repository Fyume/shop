<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="store_nav.jsp"%>

<div class="add_good_big">
	<div class="add_good_in">
		<div class="add_good_in_up">
			<div id="div_font_class">
				<font style="font-size:18px;color:#ff4400">请完善上架衣服信息:</font>
			</div>
		</div>
		<div class="add_good_in_down">
			<form
				action="${pageContext.request.contextPath }/servlet/AddClothServlet?uuid=${formuuidnum}"
				method="post" onsubmit="return checkoutfilename()"
				enctype="multipart/form-data">
				<input type="hidden" value="${store.store_id }" name="store_id">
				<!-- 记住商品是属于哪家店铺的 所以添加商品前要 在session域存一个 store对象 -->
				<table border="0px">
					<tr>
						<!-- 光标离开 后触发js函数 onblur="isInput(this.value)" -->
						<th>衣服名称：</th>
						<td><input type="text" name="clothname"></td>
						<td><span> <font style="color:red;">${errormap.clothname }</font>
						</span></td>
					</tr>
					<tr>
						<th>衣服单价：</th>
						<td><input type="text" name="price" placeholder="输入数字即可"></td>
						<td><span> <font style="color:red;">${errormap.price }</font>
						</span></td>
					</tr>
					<tr>
						<th>衣服码数：</th> <!--  L,m,s -->
						<td><input type="text" name="size" placeholder="码数之间用逗号隔开"></td>
						<td><span> <font style="color:red;">${errormap.size }</font>
						</span></td>
					</tr>
					<tr>
						<th>衣服颜色：</th> <!--  L,m,s -->
						<td><input type="text" name="color" placeholder="颜色之间用逗号隔开"></td>
						<td><span> <font style="color:red;">${errormap.color }</font>
						</span></td>
					</tr>
					<tr>
						<th>衣服款式：</th> <!-- 什么版本 清新版 帅气版啊之类的 -->
						<td><input type="text" name="version" placeholder="款式之间用逗号隔开"></td>
						<td><span> <font style="color:red;">${errormap.version }</font>
						</span></td>
					</tr>
					<tr>
						<th>商品库存：</th>
						<td><input type="text" name="totalnum" placeholder="输入数字即可"></td>
						<td><span><font style="color:red;">${errormap.totalnum }</font></span></td>
					</tr>
					<tr>
						<th>商品描述：</th>
						<td><textarea name="description" rows="5" cols="40"></textarea></td>
						<td><span><font style="color:red;">${errormap.description }</font></span></td>
					</tr>
					<tr>
						<th>衣服图片：</th>
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
</body>
</html>