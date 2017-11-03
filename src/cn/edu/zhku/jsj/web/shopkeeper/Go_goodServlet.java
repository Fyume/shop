package cn.edu.zhku.jsj.web.shopkeeper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.domain.Order;
import cn.edu.zhku.jsj.domain.User;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;

/**
 * Servlet implementation class Go_goodServlet
 */
@WebServlet("/servlet/Go_goodServlet")
public class Go_goodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderid = request.getParameter("order_id");
		int order_id = Integer.parseInt(orderid);
		BusinessService bus = new BusinessServiceImpl();
	/*	boolean b = bus.updateOrder_state_2(order_id);*/
		Order o = bus.getOrder2(order_id);
		String user_id = o.getUser_id();
		User user = bus.findInformation(user_id);
		request.setAttribute("order_user_info", o);
		request.setAttribute("order_user", user);
		request.getRequestDispatcher("/pages/shopkeeper/go_to_customs.jsp").forward(request, response);
		return;
		/*if(b){
			request.setAttribute("message","发货成功！3秒后 跳回 店铺页面 <meta http-equiv='refresh' content='3;url=/shop/pages/shopkeeper/store.jsp'>");
			request.getRequestDispatcher("/pages/user/message.jsp").forward(request, response);
			return;
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

}
