package cn.edu.zhku.jsj.web.client;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.zhku.jsj.domain.User;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;
import cn.edu.zhku.jsj.web.utils.InformationBean;
import cn.edu.zhku.jsj.web.utils.RegisterCheckBeanUtil;

@WebServlet("/servlet/ChangeInformationServlet")
public class ChangeInformationServlet extends HttpServlet {

	/*
	 * 用户修改个人信息
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		// 将表单的内容填入information中，用于检验填写的数据是否符合要求
		InformationBean bean = RegisterCheckBeanUtil.registerBean(request,
				InformationBean.class);
		if (bean.validate() != true) {
			session.setAttribute("information", bean);
			request.getRequestDispatcher("/pages/user/information.jsp").forward(
					request, response);
			return;
		}
		// 通过验证后，数据库数据进行更新
		User user =(User) session.getAttribute("user");
		BusinessService service = new BusinessServiceImpl();
		try {
			BeanUtils.copyProperties(user, bean);
			service.changemessage(user);
			user=service.findInformation(user.getUser_id());
			session.setAttribute("user", user);
			session.setAttribute("message", "资料修改成功，三秒后返回首页");
			request.getRequestDispatcher("/pages/user/message.jsp").forward(request, response);

		} catch (Exception e) {

			session.setAttribute("message", "服务器出错，修改资料失败，三秒后返回首页");
			request.getRequestDispatcher("/pages/user/message.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
