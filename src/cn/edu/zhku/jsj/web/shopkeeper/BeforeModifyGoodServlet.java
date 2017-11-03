package cn.edu.zhku.jsj.web.shopkeeper;

import java.io.IOException;
import java.util.Enumeration;

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

@WebServlet("/servlet/BeforeModifyGoodServlet")
public class BeforeModifyGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String moduuidnum = TokenProcess.getInstance().getUuidnum();
		request.getSession().setAttribute("moduuidnum", moduuidnum);
		Enumeration<String> enu = request.getParameterNames();
		HttpSession session = request.getSession();
		
		if(enu.hasMoreElements()){
			String param = enu.nextElement();
			String value = request.getParameter(param);
			
			request.getSession().setAttribute("good_type",param);
			BusinessService bus = new BusinessServiceImpl();
			int store_id = 0;
			int paramint = Integer.parseInt(value);
			if(param!=null && param.trim().equals("book_id")){
				Book book = bus.findbook(paramint);
				store_id = book.getStore_id();
				session.setAttribute("modify_book", book);
			}else if(param!=null && param.trim().equals("food_id")){
				Food food = bus.findfood(paramint);
				store_id = food.getStore_id();
				session.setAttribute("modify_food", food);
			}else{
				Cloth cloth = bus.findcloth(paramint);
				store_id = cloth.getStore_id();
				session.setAttribute("modify_cloth", cloth);
			}
			request.setAttribute("store_id", store_id);
			request.getRequestDispatcher("/pages/shopkeeper/modifygoodinfo.jsp?good_id="+value).forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
