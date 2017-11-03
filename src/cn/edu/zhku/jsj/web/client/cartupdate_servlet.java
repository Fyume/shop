package cn.edu.zhku.jsj.web.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.service.CartService;

/**
 * Servlet implementation class cartupdate_servlet
 */
@WebServlet("/cartupdate_servlet")
public class cartupdate_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartupdate_servlet() {
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
		int quantity=Integer.parseInt(request.getParameter("num"));
		int cart_id=Integer.parseInt(request.getParameter("cart_id"));
		CartService cs=new CartService();
		cs.updatecart(cart_id, quantity);
		RequestDispatcher rd = request.getRequestDispatcher("/pages/user/cart.jsp");
		rd.forward(request, response);
	}

}
