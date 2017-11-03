package cn.edu.zhku.jsj.web.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.domain.Cloth;
import cn.edu.zhku.jsj.service.Client_PartialSelectService;

public class index_servlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Client_PartialSelectService CsS = new Client_PartialSelectService();
		List<Cloth> list_c = CsS.select_c();
		request.getSession().setAttribute("body_list_c", list_c);
		request.getSession().setAttribute("body_list_c_flag", true);
		request.getSession().setAttribute("body_list_b_flag", false);
		request.getSession().setAttribute("body_list_f_flag", false);
		RequestDispatcher rd = request.getRequestDispatcher("/pages/user/index.jsp");
		rd.forward(request, response);
		out.flush();
		out.close();
	}

}
