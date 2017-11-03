package cn.edu.zhku.jsj.web.client;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.jsj.domain.User;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;


@WebServlet("/servlet/CheckChangePassword")
public class CheckChangePassword extends HttpServlet {
	/*
	 * 用户忘记密码是，根据user_id、phonenum和email修改密码
	 */

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id=request.getParameter("user_id");
		String phonenum=request.getParameter("phonenum");
		String email=request.getParameter("email");
		BusinessService service=new BusinessServiceImpl();
		//查询用户是否存在及根据用户的email和phonenum确认用户的身份
		User user=service.check(user_id, phonenum, email);
		HttpSession session=request.getSession();
		session.setAttribute("user_id", user_id);
		session.setAttribute("phonenum", phonenum);
		session.setAttribute("email", email);
		if(user==null){
			request.getSession().setAttribute("message", "该用户不存在，请检查");
			request.getRequestDispatcher("/pages/user/checkchangepassword.jsp").forward(request, response);
			return;
		}
		session.removeAttribute("message");
		request.getRequestDispatcher("/pages/user/changepassword.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
