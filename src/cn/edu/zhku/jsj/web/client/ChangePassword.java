package cn.edu.zhku.jsj.web.client;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.security.provider.MD5;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;
import cn.edu.zhku.jsj.web.utils.Md5;


@WebServlet("/servlet/ChangePassword")
public class ChangePassword extends HttpServlet implements Servlet {
	

	/*
	 * 忘记密码时，修改密码
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		String user_id=(String) session.getAttribute("user_id");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		//检验密码是否符合格式
		if(password==null||password.trim().equals("")){
			
			session.setAttribute("message", "密码不能为空");
			request.getRequestDispatcher("/pages/user/changepassword.jsp").forward(request, response);
			return;
		}else{
			if(!password.matches("\\d{8,16}")){	
				session.setAttribute("message", "密码必须为数字组成的8-16位");
				request.getRequestDispatcher("/pages/user/changepassword.jsp").forward(request, response);
				return;
			}
		}
		if(!password.equals(password2)){
			session.setAttribute("message", "两次密码不一致");
			request.getRequestDispatcher("/pages/user/changepassword.jsp").forward(request, response);
			return;
		}
	//修改密码
		BusinessService service=new BusinessServiceImpl();
		password=Md5.md5(password);
		int num=service.changePassword(user_id, password);
		if(num!=0){
		session.setAttribute("message", "密码修改成功,三秒后返回首页");
		request.getRequestDispatcher("/pages/user/message.jsp").forward(request, response);
		return;
		}
			session.setAttribute("message", "服务器出错了，修改密码失败");
			request.getRequestDispatcher("/pages/user/message.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
