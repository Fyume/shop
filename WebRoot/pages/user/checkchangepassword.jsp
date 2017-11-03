n<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>



<html>
<head>


<title>修改密码检验</title>

<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-align: center;
}
#container {
	width: 980px;
	background-image: url("${pageContext.request.contextPath }/images/checkchangepassword.jpg");
	width: 400px;
	height: 300px;
	margin: 270px 0 0 450px;
	}
	#table{
	position: absolute;
	left: 520px;
	top: 170px;
	}
	
	#mark{
position: absolute;
	left: 220px;
	top: 25px;
	}
</style>


</head>

<body>
	<div id="container">
	<div id=mark><h1 style="color:9966ff"><a href="${pageContext.request.contextPath }/pages/user/index.jsp" style="cursor: pointer">网上商城</a></h1></div>
		<form
			action="${pageContext.request.contextPath }/servlet/CheckChangePassword"
			method="post">
			<div id="table">
				<table>
					<tr>
						<th colspan="2"><h2>身份认证</h2></th>
					</tr>
					<tr>
						<td>账号：</td>
						<td><input type="text" name="user_id" value=${user_id }></td>
						<td>${message }</td>
					</tr>
					<tr>
						<td>联系电话：</td>
						<td><input type="text" name="phonenum" value="${phonenum }">
						</td>
					</tr>
					<tr>
						<td>email：</td>
						<td><input type="text" name="email" value="${email }"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="检验">
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>
