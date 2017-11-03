package cn.edu.zhku.jsj.web.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.domain.Order;
import cn.edu.zhku.jsj.domain.User;
import cn.edu.zhku.jsj.service.OrderService;

/**
 * Servlet implementation class intoOrderServlet
 */
@WebServlet("/intoOrderServlet")
public class intoOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public intoOrderServlet() {
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
		User u=(User)request.getSession().getAttribute("user");
		OrderService os=new OrderService();
		List<Order> lo=new ArrayList<Order>();
		lo=os.findOrder(u.getUser_id());
		request.getSession().setAttribute("orderlist", lo);
		RequestDispatcher rd = request.getRequestDispatcher("/pages/user/Order.jsp");
		rd.forward(request, response);
	}

}
