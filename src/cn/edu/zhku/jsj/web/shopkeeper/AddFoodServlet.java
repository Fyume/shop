package cn.edu.zhku.jsj.web.shopkeeper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;

import cn.edu.zhku.jsj.domain.Book;
import cn.edu.zhku.jsj.domain.Cloth;
import cn.edu.zhku.jsj.domain.Food;
import cn.edu.zhku.jsj.domain.Store;
import cn.edu.zhku.jsj.formbean.FoodFormBean;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;
import cn.edu.zhku.jsj.web.utils.WebUtil;

@WebServlet("/servlet/AddFoodServlet")
public class AddFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storeid =  request.getParameter("store_id");
		int store_id = Integer.parseInt(storeid);
		BusinessService bus = new BusinessServiceImpl();
		Store store = bus.finstoreinfo(store_id);
		request.setAttribute("store_info", store);
		request.getRequestDispatcher("/pages/shopkeeper/show_store_info.jsp").forward(request, response);
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String client_uuid = request.getParameter("uuid");
			String server_uuid = (String) request.getSession().getAttribute("formuuidnum");
			boolean b2 = WebUtil.isToken(client_uuid, server_uuid);
			if(b2){
				System.out.println("请不要重复提交表单");
				request.getRequestDispatcher("/pages/shopkeeper/store.jsp").forward(request, response);
				return;
			}
			request.getSession().removeAttribute("formuuidnum");
			String imgsavepath = this.getServletContext().getRealPath("/images");
			try {
				Map map2 = WebUtil.doUploadFood(request, imgsavepath);
				FoodFormBean formbean = (FoodFormBean) map2.get("formbean");
				if(formbean!=null){
					request.setAttribute("errormap", formbean.getErrormap());
					request.getRequestDispatcher("/pages/shopkeeper/addFood.jsp").forward(request, response);
					return;
				}else{
					Food food = (Food) map2.get("food");
					//图片 由于用 UUID 名  数据库 存放路径 大小设为 255 最多 可能只能存 5张图片
					
					
food.setStore_id(2);//测试用 由于 还没有店主登录进来  所以先 手动 赋值为 一个存在的店铺  到时候要删除！！


					BusinessService bus = new BusinessServiceImpl();
					int num = bus.addFood(food);
					int store_id_2 = food.getStore_id();
					if(num!=0){
						List<Book> booklist = bus.findstorebook(store_id_2);
						List<Cloth> clothlist = bus.findstorecloth(store_id_2);
						List<Food> foodlist = bus.findstorefood(store_id_2);
						
						HttpSession goodsession = request.getSession();
						goodsession.setAttribute("booklist", booklist);
						goodsession.setAttribute("clothlist", clothlist);
						goodsession.setAttribute("foodlist",foodlist);
						
						request.getRequestDispatcher("/pages/shopkeeper/store.jsp").forward(request, response);
						return;
					}

				}
			} catch (FileSizeLimitExceededException e) {
				e.printStackTrace();
				request.setAttribute("message", "文件太大！");
				request.setAttribute("prepath", "/pages/shopkeeper/addFood.jsp");
				request.getRequestDispatcher("/pages/message.jsp").forward(request, response);
				return;
			}
	}

}
