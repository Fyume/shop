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
				<table align="center">
					<tr>
						<th class="th_wight">店名：</th>
						<td>${store_info.storename }</td>
					</tr>
					<tr>
						<th class="th_wight">掌柜：</th>
						<td>${store_info.owner_id }</td>
					</tr>
					<tr>
						<th class="th_wight">描述：</th>
						<td>${store_info.description }</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>
</div>
</body>
</html>