package cn.edu.zhku.jsj.web.client;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.domain.User;
import cn.edu.zhku.jsj.service.CartService;

/**
 * Servlet implementation class cart_delete_servlet
 */
@WebServlet("/cart_delete_servlet")
public class cart_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cart_delete_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cart_id=Integer.parseInt(request.getParameter("cart_id"));
		User u=(User)request.getSession().getAttribute("user");
		CartService cs=new CartService();
		cs.deletecart(cart_id);
		List<Map> list=cs.findall(u.getUser_id());
		request.getSession().setAttribute("cartlist", list);
		RequestDispatcher rd = request.getRequestDispatcher("/pages/user/cart.jsp");
		rd.forward(request, response);
	}

}
