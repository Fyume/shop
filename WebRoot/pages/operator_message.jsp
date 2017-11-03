
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="refresh"
	content="3;url=http://localhost:8080${pageContext.request.contextPath }/pages/operator_shouye.jsp">
<title>message</title>
<style type="text/css">
body{
text-align: center;
overflow: hidden;
}

#container{
width:980;
height:100%;

}

#image{
position: absolute;
	right: 70px;
	top: 150px;
}

#message{
position: absolute;
top:250;
left:300;
}
</style>
</head>

<body>
<div id="container">
	<center>
	<div id="image">
		<img alt=""
			src="${pageContext.request.contextPath }/images/message.GIF">
	</div>
	<div id="message"><h1>${message }</h1><br>
	<a href="${pageContext.request.contextPath }/pages/operator_shouye.jsp"><h3>返回管理员首页</h3></a>
	</div>
	</center>
	</dir>
</body>
</html>
