package cn.edu.zhku.jsj.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.jsj.domain.Store;
import cn.edu.zhku.jsj.domain.User;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;
import cn.edu.zhku.jsj.web.utils.RegisterCheckBeanUtil;
import cn.edu.zhku.jsj.web.utils.StoreRegisterBean;


@WebServlet("/servlet/AddStoreServlet")
public class AddStoreServlet extends HttpServlet {
	/*
	 * 用户的开店注册
	 * 在用户的中添加身份角色，身份证号
	 * 开店信息中添加店铺名，店主的id，店铺的描述信息
	 */

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//将信息封装到检验的bean中
		StoreRegisterBean bean=RegisterCheckBeanUtil.registerBean(request, StoreRegisterBean.class);
		
		HttpSession session=request.getSession();
		//判断信息的输入格式有没有错误
		if(bean.validate()!=true){
			session.setAttribute("StroeRegisterBean", bean);
			request.getRequestDispatcher("/pages/user/store_register.jsp").forward(request, response);
			return;
		}
		//输入信息无误，进行注册
		User user=(User) session.getAttribute("user");
		if(user==null){
			session.setAttribute("message", "请先登录再注册店铺，三秒后返回首页");
			request.getRequestDispatcher("/pages/user/message.jsp").forward(request, response);
			return;
		}
		String user_id=user.getUser_id();
		Store store=new Store();
		store.setOwner_id(user_id);
		store.setDescription(bean.getDescription());
		store.setStorename(bean.getStorename());
		BusinessService service=new BusinessServiceImpl();
		if(service.addStore(store)==0||service.registerEmplooyer(user_id, bean.getCardID(), bean.getRole())==0){
			session.setAttribute("message", "服务器出错，注册失败，三秒后自动跳回首页 <meta http-equiv='refresh' content='3;url=/shop/pages/user/index.jsp'>");

			request.getRequestDispatcher("/pages/user/message.jsp").forward(request, response);
			return;
		}
		user=service.findInformation(user.getUser_id());
		session.setAttribute("user",user);
		session.setAttribute("message", "店铺注册成功，三秒后自动跳回首页");
		request.getRequestDispatcher("/pages/user/message.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
