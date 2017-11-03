package cn.edu.zhku.jsj.web.shopkeeper;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.jsj.domain.Book;
import cn.edu.zhku.jsj.domain.Cloth;
import cn.edu.zhku.jsj.domain.Food;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;


@WebServlet("/servlet/DeletegoodServlet")
public class DeletegoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> enu = request.getParameterNames();
		BusinessService bus = new BusinessServiceImpl();
		HttpSession goodsession = request.getSession(); 
		if(enu.hasMoreElements()){
			String param = enu.nextElement();
			String good_id = request.getParameter(param);
			int goodId = Integer.parseInt(good_id);
			boolean b = false;
			if(param!=null && param.trim().equals("book_id")){
				Book book = bus.findbook(goodId);
				int store_id = book.getStore_id();
				b = bus.deletebook(goodId);  //delete 删除完数据后 要更新 session的 商品信息
				goodsession.removeAttribute("booklist");
				List<Book> booklist = bus.findstorebook(store_id);
				goodsession.setAttribute("booklist", booklist);
			}else if(param!=null && param.trim().equals("food_id")){
				Food food = bus.findfood(goodId);
				int store_id = food.getStore_id();
				b = bus.deletefood(goodId);
				goodsession.removeAttribute("foodlist");
				List<Food> foodlist = bus.findstorefood(store_id);
				goodsession.setAttribute("foodlist", foodlist);
			}else{
				Cloth cloth = bus.findcloth(goodId);
				int store_id = cloth.getStore_id();
				b = bus.deletecloth(goodId);
				goodsession.removeAttribute("clothlist");
				List<Cloth> clothlist = bus.findstorecloth(store_id);
				goodsession.setAttribute("clothlist",clothlist);
			}
			if(b){
				request.setAttribute("message", "删除成功！3秒钟后跳回店铺首页<meta http-equiv='Refresh' content='3;url=/shop/pages/shopkeeper/store.jsp'>");
				request.setAttribute("prepath", "/shop/pages/shopkeeper/store.jsp");
			}else{
				request.setAttribute("message", "删除失败！3秒钟后跳回店铺首页<meta http-equiv='Refresh' content='3;url=/shop/pages/shopkeeper/store.jsp'>");
				request.setAttribute("prepath", "/shop/pages/shopkeeper/store.jsp");
			}
			request.getRequestDispatcher("/pages/user/message.jsp").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

}
