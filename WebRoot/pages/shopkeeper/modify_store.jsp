<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="store_nav.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="add_store_big">
	<div id="add_store_in">
		<div id="add_store_in_in">
			<div id="add_store_in_left_2">
				<c:choose>
					<c:when test="${empty store_info.images }">
					<img alt="picture" src="${pageContext.request.contextPath }/images/store_logo.jpg" height="100px" width="200px">
					</c:when>
					<c:otherwise>
					<img alt="picture" src="${pageContext.request.contextPath }/images/${store_info.images}" height="100px" width="200px">
					</c:otherwise>
				</c:choose>
				</div>
			</div>
			<div id="add_store_in_right">
			<form action="${pageContext.request.contextPath }/servlet/Modify_store_infoServlet" method="post">
			<input type="hidden" name="store_id" value="${store_id }">
				<table align="center" style="width:250px">
					<tr>
						<th class="th_wight">店名：</th>
						<td><input type="text" name="storename" value="${store_info.storename }"></td>
					</tr>
					
					<tr><%-- <input type="text" name="description" value=""> --%>
						<th class="th_wight">描述：</th>
						<td><textarea name="description" rows="4" cols="16">${store_info.description }</textarea></td>
					</tr>
					<tr><td colspan="2" align="center"><input type="submit" value="修改"><input type="reset" value="重置"></td></tr>
				</table>
			</form>
			</div>
		</div>
	</div>
</div>
</div>
</body>
</html>