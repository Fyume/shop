<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>



<html>
<head>


<title>修改密码</title>


<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-align: center;
}

#container {
	width: 980px;
	background-image:
		url("${pageContext.request.contextPath }/images/changepassword.jpg");
	width: 600px;
	height: 460px;
	margin: 100px 0 0 50px;
}

#table {
	position: absolute;
	left: 520px;
	top: 170px;
}

#mark {
	position: absolute;
	left: 220px;
	top: 25px;
}
</style>


</head>

<body>
	<div id="container">
		<div id=mark>
			<h1 style="color:9966ff">
				<a href="${pageContext.request.contextPath }/pages/user/index.jsp"
					style="cursor: pointer">网上商城</a>
			</h1>
		</div>
		<form
			action="${pageContext.request.contextPath }/servlet/ChangePassword"
			method="post">
			<div id="table">
				<table>
				<tr><th colspan="2"><h2>修改密码</h2></th></tr>
					<tr>
						<td>修改密码：</td>
						<td><input type="password" name="password" value=${password }></td>
						<td>${message }</td>
					</tr>
					<tr>
						<td>确认修改密码：</td>
						<td><input type="password" name="password2"
							value=${password2 }></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="提交">
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>
