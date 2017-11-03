package cn.edu.zhku.jsj.web.shopkeeper;

import java.io.IOException;
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

@WebServlet("/servlet/CategroyServlet")
public class CategroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String goodtype = request.getParameter("goodtype");
		//store_id要传进来  现在测试 先手动赋值 为 2  因为 下现在只有 一个 2号店铺
		/*String store_id = request.getParameter("store_id");
		int storeid = Integer.parseInt(store_id);*/
		int storeid = 2;
		BusinessService bus = new BusinessServiceImpl();
		HttpSession cat_session = request.getSession();
		request.setAttribute("good_cat_type", goodtype); 
		if(goodtype!=null && goodtype.trim().equals("book")){
			List<Book> booklist_cat = bus.findstorebook(storeid);
			cat_session.setAttribute("booklist_cat", booklist_cat);
		}else if(goodtype!=null && goodtype.trim().equals("food")){
			List<Food> foodlist_cat = bus.findstorefood(storeid);
			cat_session.setAttribute("foodlist_cat", foodlist_cat);
		}else{
			List<Cloth> clothlist_cat = bus.findstorecloth(storeid);
			cat_session.setAttribute("clothlist_cat", clothlist_cat);
		}
		request.getRequestDispatcher("/pages/shopkeeper/categroygoods.jsp").forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
