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
import cn.edu.zhku.jsj.web.utils.TokenProcess;

@WebServlet("/servlet/AddGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storeid = request.getParameter("store_id");
		int store_id = Integer.parseInt(storeid);
		BusinessService bus = new BusinessServiceImpl();
		List<Book> booklist = bus.findstorebook(store_id);
		List<Cloth> clothlist = bus.findstorecloth(store_id);
		List<Food> foodlist = bus.findstorefood(store_id);
		
		HttpSession session = request.getSession();
		session.setAttribute("booklist", booklist);
		session.setAttribute("clothlist", clothlist);
		session.setAttribute("foodlist", foodlist);
		session.setMaxInactiveInterval(3600*24);
		request.getRequestDispatcher("/pages/shopkeeper/store.jsp").forward(request, response);
		return;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		//生成表单唯一的编号
		String formuuidnum = TokenProcess.getInstance().getUuidnum();
		request.getSession().setAttribute("formuuidnum", formuuidnum);
		if(category!=null && category.trim().equals("1")){  //1 表示食品类
			request.getRequestDispatcher("/pages/shopkeeper/addFood.jsp").forward(request, response);
			return;
		}else if(category!=null && category.trim().equals("2")){ //2 表示衣服类
			request.getRequestDispatcher("/pages/shopkeeper/addCloth.jsp").forward(request, response);
			return;
		}else{
			request.getRequestDispatcher("/pages/shopkeeper/addBook.jsp").forward(request, response);
			return;
		}
	}
}
