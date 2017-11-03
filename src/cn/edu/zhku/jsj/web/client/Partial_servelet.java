package cn.edu.zhku.jsj.web.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.domain.Book;
import cn.edu.zhku.jsj.domain.Cloth;
import cn.edu.zhku.jsj.domain.Food;
import cn.edu.zhku.jsj.service.Client_PartialSelectService;

public class Partial_servelet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getParameter("body_type_selected");
		Client_PartialSelectService CsS = new Client_PartialSelectService();
		if (str.equals("Cloth")) {
			List<Cloth> list_c = CsS.select_c();
			request.getSession().setAttribute("body_list_c", list_c);
			request.getSession().setAttribute("body_list_c_flag", true);
			request.getSession().setAttribute("body_list_b_flag", false);
			request.getSession().setAttribute("body_list_f_flag", false);
		}
		if (str.equals("Book")) {
			List<Book> list_b = CsS.select_b();
			request.getSession().setAttribute("body_list_b", list_b);
			request.getSession().setAttribute("body_list_b_flag", true);
			request.getSession().setAttribute("body_list_c_flag", false);
			request.getSession().setAttribute("body_list_f_flag", false);
		}
		if (str.equals("Food")) {
			List<Food> list_f = CsS.select_f();
			request.getSession().setAttribute("body_list_f", list_f);
			request.getSession().setAttribute("body_list_f_flag", true);
			request.getSession().setAttribute("body_list_b_flag", false);
			request.getSession().setAttribute("body_list_c_flag", false);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/pages/user/body.jsp");
		rd.forward(request, response);
	}

}
