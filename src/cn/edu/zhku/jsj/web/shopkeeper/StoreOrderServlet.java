package cn.edu.zhku.jsj.web.shopkeeper;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.domain.Order;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;


@WebServlet("/servlet/StoreOrderServlet")
public class StoreOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderid = request.getParameter("order_id");
		int order_id = Integer.parseInt(orderid);
		BusinessService bus = new BusinessServiceImpl();
		boolean b = bus.deleteOrder(order_id);
		if(b){
			request.setAttribute("message","删除成功！3秒后 跳回 店铺页面 <meta http-equiv='refresh' content='3;url=/shop/pages/shopkeeper/store.jsp'>");
		}else{
			request.setAttribute("message","删除失败！3秒后 跳回 店铺页面 <meta http-equiv='refresh' content='3;url=/shop/pages/shopkeeper/store.jsp'>");
		}
		request.getRequestDispatcher("/pages/user/message.jsp").forward(request, response);
		return;
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String order_type = request.getParameter("order_type");
		int states = Integer.parseInt(order_type);
		String storeid = request.getParameter("store_id");
		int store_id = Integer.parseInt(storeid);
		BusinessService bus = new BusinessServiceImpl();
		List<Order> listorder = null;
		if("0".equals(order_type)){
			//查询该店铺的所有订单
			listorder = bus.getOrder(store_id);
		}
		if("2".equals(order_type) || "3".equals(order_type)){
			listorder = bus.getBFOrder(store_id, states);
		}
		request.setAttribute("orderlist", listorder);
		request.getRequestDispatcher("/pages/shopkeeper/store_order_manage2.jsp").forward(request, response);
		return;
	}

}
