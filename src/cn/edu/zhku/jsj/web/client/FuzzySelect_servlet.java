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
import cn.edu.zhku.jsj.domain.Store;
import cn.edu.zhku.jsj.service.Client_FuzzySelectService;

public class FuzzySelect_servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String type = (String)request.getParameter("header2_center_top_type_radio");
		String select = (String)request.getParameter("select");
		Client_FuzzySelectService CsS = new Client_FuzzySelectService();
		if(select!=""||!select.isEmpty()){
		if (type.equals("商品")) {
			List<Book> list_b = CsS.select_b(select);
			request.getSession().setAttribute("Fuzzlist_b", list_b);
			List<Food> list_f = CsS.select_f(select);
			request.getSession().setAttribute("Fuzzlist_f", list_f);
			List<Cloth> list_c = CsS.select_c(select);
			request.getSession().setAttribute("Fuzzlist_c", list_c);
			request.getSession().setAttribute("Fuzz_flag","goods");
		} else if (type.equals("店铺")) {
			List<Store> list_s = CsS.select_s(select);
			request.getSession().setAttribute("Fuzzlist_s", list_s);
			request.getSession().setAttribute("Fuzz_flag","stores");
		}
		RequestDispatcher rd = request
				.getRequestDispatcher("/pages/user/show.jsp");
		rd.forward(request, response);
		}else{
		RequestDispatcher rd = request.getRequestDispatcher("/pages/user/index.jsp");
		rd.forward(request, response);
		}
		out.flush();
		out.close();
	}

}
