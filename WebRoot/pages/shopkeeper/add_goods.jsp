<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="store_nav.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="add_store_big">
	<div id="add_store_in">
		<div id="add_store_in_in">
			<div id="add_store_in_left">
				<font style="color:#fb7728;font-size:18px;">请选择上架商品类型</font>
			</div>
			<div id="add_store_in_right">
				<form
					action="${pageContext.request.contextPath }/servlet/AddGoodsServlet"
					method="post" onsubmit="return isselected()">
					<select id="category2" name="category">
						<option value="0" selected>选择类型</option>
						<option value="1">食品类</option>
						<option value="2">衣服类</option>
						<option value="3">书籍类</option>
					</select> <input type="submit" value="添加" class="add_button">
				</form>
			</div>
		</div>
	</div>
</div>
</div>
</body>
</html>
