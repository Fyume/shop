<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>



<html>
<head>


<title>个人信息</title>

<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-align: center;
}
#container {
	width: 980px;
	background-image: url("${pageContext.request.contextPath }/images/information.jpg");
	width: 1024px;
	height: 768px;
	margin: 0px 0 0 175px;
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
			action="${pageContext.request.contextPath }/servlet/ChangeInformationServlet"
			method="post">
			<div id="table">
				<table>
					<tr>
						<td colspan="2" align="center"><h2>个人信息</h2></td>
					</tr>
					<tr>
						<td>账号：</td>
						<td>${user.user_id }</td>
					</tr>
					<tr>
						<td>昵称：</td>
						<td><input type="text" name="nickname"
							value="${user.nickname }"></td>
						<td>${information.errors.nickname }</td>
					</tr>
					<tr>
						<td>联系方式：</td>
						<td><input type="text" name="phonenum"
							value="${user.phonenum }"></td>
						<td>${information.errors.phonenum }</td>
					</tr>
					<tr>
						<td>email：</td>
						<td><input type="text" name="email" value="${user.email }"></td>
						<td>${information.errors.email }</td>
					</tr>
					<tr>
						<td>地址：</td>
						<td><input type="text" name="address"
							value="${user.address }"></td>
						<td>${information.errors.address }</td>
					</tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr>
						<td align=center colspan="2"><input  type="submit" value="保存" ></td>
					</tr>

				</table>
			</div>
		</form>
	</div>
</body>
</html>
