<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>



<html>
<head>


<title>店铺注册</title>
<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-align: center;
}

#container {
	width: 980px;
	background-image: url("${pageContext.request.contextPath }/images/store_register.jpg");
	width: 1024px;
	height: 768px;
	margin: 0px 0 0 175px;
}

#table {
	position: absolute;
	left: 750px;
	top: 180px;
}
	#mark{
position: absolute;
	left: 240px;
	top: 40px;
	}
</style>
</head>

<body>
	<div id="container">
	<div id=mark><h1 style="color:9966ff"><a href="${pageContext.request.contextPath }/pages/user/index.jsp" style="cursor: pointer">网上商城</a></h1></div>
		<form
			action="${pageContext.request.contextPath }/servlet/AddStoreServlet"
			method="post">
			<div id="table">
			<table>
			<tr><td colspan="2" align="center"><h3>店铺注册</h3></td></tr>
				<tr>
					<td>店铺名称：</td>
					<td><input type="text" name="storename"
						value="${StroeRegisterBean.storename }"></td>
					<td>${StroeRegisterBean.errors.storename }</td>
				</tr>
				<tr>
					<td>是否开店：</td>
					<td><input type="radio" name="role" value="2">开店</td>
					<td>${StroeRegisterBean.errors.role }</td>
				</tr>
				<tr>
					<td>身份证号：</td>
					<td><input type="text" name="cardID"
						value="${StroeRegisterBean.cardID}"></td>
					<td>${StroeRegisterBean.errors.cardID }</td>
				</tr>
				<tr>
					<td>店铺描述信息：</td>
					<td><textarea name="description" style="resize:none"
							value="${StroeRegisterBean.description}" row="3" cols="20"></textarea></td>
					<td>${StroeRegisterBean.errors.description }</td>
				</tr>
				<tr>
					<td><input type="submit" value="注册"></td>
					<td><input type="reset" value="重置"></td>
					<td></td>
				</tr>
			</table>
	</div>
	</form>
	</div>
</body>
</html>
