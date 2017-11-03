<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="store_nav.jsp"%>

<div class="add_good_big">
	<div class="add_good_in">
		<div class="add_good_in_up">
			<div id="div_font_class">
				<font style="font-size:18px;color:#ff4400">请完善上架食品信息:</font>
			</div>
		</div>
		<div calss="clear"></div>
		<div class="add_good_in_down">
			<form
				action="${pageContext.request.contextPath }/servlet/AddFoodServlet?uuid=${formuuidnum}"
				method="post" onsubmit="return checkoutfilename()"
				enctype="multipart/form-data">
				<input type="hidden" value="${store.store_id }" name="store_id">
				<!-- 记住商品是属于哪家店铺的 所以添加商品前要 在session域存一个 store对象 -->
				<table border="0px">
					<tr>
						<!-- 光标离开 后触发js函数 onblur="isInput(this.value)" -->
						<th>商品名称：</th>
						<td><input type="text" name="foodname"></td>
						<td><span> <font style="color:red;">${errormap.foodname }</font>
						</span></td>
					</tr>
					<tr>
						<th>商品单价：</th>
						<td><input type="text" name="price" placeholder="输入数字即可"></td>
						<td><span> <font style="color:red;">${errormap.price }</font>
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
						<th>商品图片：</th>
						<td><input type="file" name="images" id="images"></td>
						<td><span>${message }</span></td>
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
