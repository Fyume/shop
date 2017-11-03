package cn.edu.zhku.jsj.web.shopkeeper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.domain.Store;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;


@WebServlet("/servlet/Modify_store_infoServlet")
public class Modify_store_infoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String storeid = request.getParameter("store_id");
		int store_id = Integer.parseInt(storeid);
		String storename = request.getParameter("storename");
		String description  = request.getParameter("description");
		
		BusinessService bus = new BusinessServiceImpl();
		Store store = new Store();
		store.setStorename(storename);
		store.setDescription(description);
		store.setStore_id(store_id);
		boolean b = bus.updatestore_info(store);
		if(b){
			request.setAttribute("message", "更新店铺信息成功！3秒钟后跳回店铺首页<meta http-equiv='Refresh' content='3;url=/shop/pages/shopkeeper/store.jsp'>");
			request.setAttribute("prepath", "/shop/pages/shopkeeper/store.jsp");
		}else{
			request.setAttribute("message", "更新店铺信息失败！3秒钟后跳回店铺首页<meta http-equiv='Refresh' content='3;url=/shop/pages/shopkeeper/store.jsp'>");
			request.setAttribute("prepath", "/shop/pages/shopkeeper/store.jsp");
		}
		request.getRequestDispatcher("/pages/user/message.jsp").forward(request, response);
		return;
		
	}

}
