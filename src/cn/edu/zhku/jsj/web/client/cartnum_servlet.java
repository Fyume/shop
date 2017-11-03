package cn.edu.zhku.jsj.web.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.domain.User;
import cn.edu.zhku.jsj.service.CartService;

/**
 * Servlet implementation class cartnum_servlet
 */
@WebServlet("/cartnum_servlet")
public class cartnum_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartnum_servlet() {
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
		CartService cs=new CartService();
		if(u!=null){
			int num=cs.countCart(u.getUser_id());
			request.getSession().setAttribute("cartnum", num);
			RequestDispatcher rd = request
					.getRequestDispatcher("/pages/user/header.jsp");
			rd.forward(request, response);
		}
	}

}
