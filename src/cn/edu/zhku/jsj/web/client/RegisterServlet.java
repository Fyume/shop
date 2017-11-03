package cn.edu.zhku.jsj.web.client;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.zhku.jsj.domain.User;
import cn.edu.zhku.jsj.exception.UserexistException;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;
import cn.edu.zhku.jsj.web.utils.RegisterCheckBean;
import cn.edu.zhku.jsj.web.utils.RegisterCheckBeanUtil;


@WebServlet("/servlet/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//将表的数据提交到RegisterCheckBean
		RegisterCheckBean bean=RegisterCheckBeanUtil.registerBean(request, RegisterCheckBean.class);
		
		//检验用户注册提交的数据
		if(bean.validate()!=true){
			request.getSession().setAttribute("RegisterCheckBean", bean);
			request.getRequestDispatcher("/pages/user/register.jsp").forward(request, response);
			return;
		}
		User user=new User();
		BusinessService register=new BusinessServiceImpl();
		try {
			BeanUtils.copyProperties(user, bean);
			register.adduser(user);
			request.setAttribute("message", "注册成功,三秒后返回首页");
			request.getRequestDispatcher("/pages/user/message.jsp").forward(request, response);;
			return;
		} catch (UserexistException e) {
			bean.getErrors().put("user_id","用户已存在");
			request.getSession().setAttribute("RegisterCheckBean", bean);
			request.getRequestDispatcher("/pages/user/register.jsp").forward(request, response);;
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "对不起，服务器出错，注册失败");
			request.getRequestDispatcher("/pages/user/message.jsp").forward(request, response);;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
