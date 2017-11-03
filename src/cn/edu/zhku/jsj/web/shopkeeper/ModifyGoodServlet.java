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
import cn.edu.zhku.jsj.formbean.BookFormBean;
import cn.edu.zhku.jsj.formbean.ClothFormBean;
import cn.edu.zhku.jsj.formbean.FoodFormBean;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;
import cn.edu.zhku.jsj.web.utils.RegisterCheckBeanUtil;
import cn.edu.zhku.jsj.web.utils.WebUtil;

@WebServlet("/servlet/ModifyGoodServlet")
public class ModifyGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String clientuuidnum = request.getParameter("uuid");
		String serveruuidnum = (String)request.getSession().getAttribute("moduuidnum");
		
		String goodtype = request.getParameter("good_type");
		boolean b = WebUtil.isToken(clientuuidnum, serveruuidnum);
		
		BusinessService bus = new BusinessServiceImpl();
	
		HttpSession goodsession = request.getSession();
		if(goodtype!=null && goodtype.trim().equals("book_id")){
			if(!b){
				request.getSession().removeAttribute("moduuidnum");
				BookFormBean formbook = RegisterCheckBeanUtil.registerBean(request, BookFormBean.class);
				if(!formbook.checkoutData()){
					request.setAttribute("errormap", formbook.getErrormap());
					
				/*	System.out.println(formbook.getBook_id());*/
					
					/*Book book = bus.findbook(formbook.getBook_id());
					request.setAttribute("errorbook", book);*/
					request.getRequestDispatcher("/pages/shopkeeper/modifygoodinfo.jsp").forward(request, response);
					return;
				}
				goodsession.removeAttribute("modify_book");
				Book book = RegisterCheckBeanUtil.registerBean(request, Book.class);
				bus.updateBook(book);
				goodsession.removeAttribute("booklist");
				/*System.out.println(book.getStore_id());*/
				List<Book> booklist = bus.findstorebook(book.getStore_id());
				goodsession.setAttribute("booklist", booklist);
			}else{
				System.out.println("请不要刷新页面重复修改信息");
			}
		}else if(goodtype!=null && goodtype.trim().equals("cloth_id")){
			if(!b){
				request.getSession().removeAttribute("moduuidnum");
				ClothFormBean formcloth = RegisterCheckBeanUtil.registerBean(request, ClothFormBean.class);
				if(!formcloth.checkoutData()){
					request.setAttribute("errormap", formcloth.getErrormap());
					/*Cloth cloth = bus.findcloth(formcloth.getCloth_id());
					request.setAttribute("errorcloth", cloth);*/
					request.getRequestDispatcher("/pages/shopkeeper/modifygoodinfo.jsp").forward(request, response);
					return;
				}
				goodsession.removeAttribute("modify_cloth");
				Cloth cloth = RegisterCheckBeanUtil.registerBean(request, Cloth.class);
				bus.updateCloth(cloth);
				goodsession.removeAttribute("clothlist");
				List<Cloth> clothlist = bus.findstorecloth(cloth.getStore_id());
				goodsession.setAttribute("clothlist", clothlist);
				
			}else{
				System.out.println("请不要刷新页面重复修改信息");
			}
		}else{
			if(!b){
				request.getSession().removeAttribute("moduuidnum");
				FoodFormBean formfood = RegisterCheckBeanUtil.registerBean(request, FoodFormBean.class);
				if(!formfood.checkoutData()){
					request.setAttribute("errormap", formfood.getErrormap());
					/*Food food = bus.findfood(formfood.getFood_id());
					request.setAttribute("errorfood", food);*/
					request.getRequestDispatcher("/pages/shopkeeper/modifygoodinfo.jsp").forward(request, response);
					return;
				}
				goodsession.removeAttribute("modify_food");
				Food food = RegisterCheckBeanUtil.registerBean(request, Food.class);
				bus.updateFood(food);
				goodsession.removeAttribute("foodlist");
				List<Food> foodlist = bus.findstorefood(food.getStore_id());
				goodsession.setAttribute("foodlist", foodlist);
			}else{
				System.out.println("请不要刷新页面重复修改信息");
			}
		} 
		request.getSession().removeAttribute("good_type");
		request.getRequestDispatcher("/pages/shopkeeper/store.jsp").forward(request, response);
		return;
	}

}
