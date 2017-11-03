package cn.edu.zhku.jsj.web.manager;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.jsj.domain.Operator;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;

@WebServlet("/servlet/Operator_loginServlet")
public class Operator_loginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
	    //获取表单信息
	    String name=request.getParameter("name");
	    String password=request.getParameter("password");
	    session.setAttribute("name", name);
	    session.setAttribute("password", password);
	
	  //登录检验
	  		BusinessService operator_login=new BusinessServiceImpl();
	  		Operator operator=operator_login.findOperator(name, password);
	  		if(operator==null){
	  			session.setAttribute("operator_message", "用户名或密码错误");
	  			request.getRequestDispatcher("/pages/operator_login.jsp").forward(request, response);
	  			return;
	  		}
	  		session.setAttribute("message", "用户登录成功，三秒后自动跳回首页");
	  		//传递上次登录的时间
	  		session.setAttribute("loginTime", operator.getLoginTime());
	  		//更新登录的时间
	  		long time=System.currentTimeMillis();
	  		Date date=new Date(time);
	  		operator.setLoginTime(date);
	  		operator_login.setTime(operator);
	  		session.setAttribute("operator", operator);
	  		List list=operator_login.storeInformation();
	  		session.setAttribute("StoreList", list);
	  		request.getRequestDispatcher("/pages/operator_message.jsp").forward(request, response);
	  	
	
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
