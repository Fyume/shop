<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>



<html>
<head>


<title>My JSP 'operator_register.jsp' starting page</title>



</head>

<body>
	<form action="${pageContext.request.contextPath }/servlet/Operator_register" method="post">
		<table align=center>
			<tr>
				<td colspan="2" align="center"><h1>注册</h1></td>
			</tr>
			<tr>
				<td>账号：</td>
				<td><input type="text" name="name" value="${OperatorRegisterbean.name }"></td>
				<td>${OperatorRegisterbean.errors.name }</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" value="${OperatorRegisterbean.password }"></td>
				<td>${OperatorRegisterbean.errors.password }</td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" name="password2" value="${OperatorRegisterbean.password2 }"></td>
				<td>${OperatorRegisterbean.errors.password2 }</td>
			</tr>
			<tr>
				<td><input type="submit" value="注册"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>

</body>
</html>
