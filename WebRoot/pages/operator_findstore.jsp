<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
  <head>
   
    <title>店铺查找结果</title>
   
<style type="text/css">
body{
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
	<form action=""><input type="text" name="storename" value="根据店名查找"><input type="submit" value="查找"></form>
	<br> 店铺信息
	<br>
	<table border="1" align=center>
		<tr>
			<td>店铺名称</td>
			<td>店主</td>
			<td>店铺状态</td>
			<td>店铺管理</td>
		</tr>
		<c:if test="${findstore==null }"><tr><td colspan="4">没有您查询的店铺</td></tr></c:if>
		<c:if test="${findstore!=null }">
			<tr>
				<td>${findstore.storename }</td>
				<td>${findstore.owner_id  }</td>
				<td>
				<c:if test="${findstore.control== 0}">营业</c:if>
				<c:if test="${findstore.control!=0}">被封</c:if>
				</td>
				<td><a href="${pageContext.request.contextPath }/servlet/Store_Controlservlet?control=0&storename=${store.storename}">解封</a>
				<a href="${pageContext.request.contextPath }/servlet/Store_Controlservlet?control=1&storename=${store.storename}">封店</a></td>
			</tr>
			</c:if>
		<a href="${pageContext.request.contextPath }/pages/operator_shouye.jsp">返回首页</a>
	</table>
  </body>
</html>
