<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>


<title>登录</title>

<script type="text/javascript">
	function dump() {

		window.location.href = "${pageContext.request.contextPath}/pages/user/register.jsp";
	}
</script>
<script type="text/javascript">
	function change(img) {
		img.src = img.src + "?" + new Date().getTime();
	}
</script>


<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
	overflow: hidden;
}

#container {
	width: 980px;
	background-image: url("${pageContext.request.contextPath }/images/login.GIF");

	width: 1340px;
	height: 540px;
	margin: 5px 0 0 13px;
}

#a {
	margin-left: 100px;
}

#form table {
	background-image: url("${pageContext.request.contextPath }/images/login1.GIF");
	width: 428px;
	height: 298px;
	position: absolute;
	right: 40px;
	top: 180px;
	text-align: center;
	border: 1px solid gray;
}
</style>

</head>

<body>
	<div id="a">
		<a href="${pageContext.request.contextPath }/pages/user/index.jsp"
			style="color:99BBFF"><h1>网上商城</h1></a>
	</div>
	<div id="container">


		<div id="form">
			<form
				action="${pageContext.request.contextPath }/servlet/LoginServlet"
				method="post">
				<table>

					<tr>
						<th colspan="3"><h1>登录</h1></th>
					</tr>
					<tr>
						<td>账号：</td>
						<td><input type="text" name="user_id" value="${username }"></td>
						<td>${login }</td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="password"
							value="${password }"></td>
						<td></td>
					</tr>
					<tr>
						<td>验证码：</td>
						<td><input type="text" name="checkcode"></td>
						<td><img alt="换一张"
							src="${pageContext.request.contextPath }/servlet/CheckCode"
							onclick="change(this)" style="cursor:pointer"></td>
						<td>${checkcodemessage }</td>
					</tr>
					<tr>
						<td><input type="submit" value="登录"></td>
						<td><input type="button" value="注册" onclick="dump()"></td>
					</tr>
					<tr><td></td><td></td><td><a href="${pageContext.request.contextPath }/pages/user/checkchangepassword.jsp" style="cursor: pointer">忘记密码</a></td></tr>

				</table>
			</form>
		</div>
	</div>
</body>
</html>
