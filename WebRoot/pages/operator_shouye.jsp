<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>


<title>My JSP 'operator_shouye.jsp' starting page</title>

<style type="text/css">
body {
	text-align: center;
}
</style>
</head>

<body>
	<table align=center>
		<tr>
			<td>欢迎您：</td>
			<td>${operator.name }</td>
			<td colspan="3"></td>
			<td>您上次登录的时间是：</td>
			<td>${loginTime }</td>
			<td></td>
			<td><a
				href="${pageContext.request.contextPath }/pages/operator_login.jsp">登录</a></td>
			<td></td>
			<td><a
				href="${pageContext.request.contextPath }/servlet/Operator_drop">注销</a></td>
		</tr>
	</table>
	<form
		action="${pageContext.request.contextPath }/servlet/OperatorFindStoreServlet" method="post">
		<input type="text" name="storename" value="根据店名查找"><input
			type="submit" value="查找">
	</form>
	<br> 店铺信息
	<br>
	<table border="1" align=center>
		<tr>
			<td>店铺名称</td>
			<td>店主</td>
			<td>店铺状态</td>
			<td>店铺管理</td>
		</tr>
		<c:forEach items="${StoreList }" var="store">
			<tr>
				<td>${store.storename }</td>
				<td>${store.owner_id  }</td>
				<td><c:if test="${store.control== 0}">营业</c:if> <c:if
						test="${store.control!=0}">被封</c:if></td>
				<td><a
					href="${pageContext.request.contextPath }/servlet/Store_Controlservlet?control=0&storename=${store.storename}">解封</a>
					<a
					href="${pageContext.request.contextPath }/servlet/Store_Controlservlet?control=1&storename=${store.storename}">封店</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
