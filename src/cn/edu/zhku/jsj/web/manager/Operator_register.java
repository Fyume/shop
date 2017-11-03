package cn.edu.zhku.jsj.web.manager;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.zhku.jsj.domain.Operator;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;
import cn.edu.zhku.jsj.web.utils.OperatorRegisterbean;
import cn.edu.zhku.jsj.web.utils.RegisterCheckBeanUtil;


@WebServlet("/servlet/Operator_register")
public class Operator_register extends HttpServlet {
	
/*
 * 用于管理员的注册
 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取表单内容
		OperatorRegisterbean bean=RegisterCheckBeanUtil.registerBean(request, OperatorRegisterbean.class);
		
		HttpSession session=request.getSession();
		//判断注册表单的内容是否符合格式要求
		if(bean.vaildate()!=true){
			session.setAttribute("OperatorRegisterbean", bean);
			request.getRequestDispatcher("/pages/operator_register.jsp").forward(request, response);
			return;
		}
		
		//数据库储存管理员的信息
		Operator operator=new Operator();
		BusinessService service=new BusinessServiceImpl();
		int num;
		try {
			BeanUtils.copyProperties(operator, bean);
			System.out.println(operator.getName());
			num=service.addOperator(operator);
			
		} catch (Exception e) {
			System.out.println("11111");
			session.setAttribute("message", "服务器出错，注册失败，三秒后返回首页");
			request.getRequestDispatcher("/pages/operator_message.jsp").forward(request, response);
			return;
		}
		if(num==0){
			
			session.setAttribute("message", "服务器出错，注册失败，三秒后返回首页");
			request.getRequestDispatcher("/pages/operator_message.jsp").forward(request, response);
			return;
		}
		session.setAttribute("message", "注册成功，三秒后返回首页");
		request.getRequestDispatcher("/pages/operator_message.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
