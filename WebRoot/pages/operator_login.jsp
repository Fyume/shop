<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>



  <head>
    
    
    <title>管理员登录</title>
    
	

  </head>
  
  <body>
  <form action="${pageContext.request.contextPath }/servlet/Operator_loginServlet" method="post">
  <table align=center>
  <tr><td colspan="2" align=center><h1>登录</h1></td></tr>
  <tr><td>账号：</td><td><input type="text" name="name" value="${name }" ></td><td>${operator_message }</td></tr>
  <tr><td>密码：</td><td><input type="password" name="password" value="${password }" ></td></tr>
  <tr><td><input type="submit" value="登录"></td></tr>
  </table>
  </form>
  </body>
</html>
