package cn.edu.zhku.jsj.web.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.domain.Cart;
import cn.edu.zhku.jsj.domain.Order;
import cn.edu.zhku.jsj.domain.User;
import cn.edu.zhku.jsj.service.CartService;
import cn.edu.zhku.jsj.service.Good_selectService;
import cn.edu.zhku.jsj.service.OrderService;

/**
 * Servlet implementation class PayOrIntoCart_servlet
 */
@WebServlet("/PayOrIntoCart_servlet")
public class PayOrIntoCart_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PayOrIntoCart_servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("Goods_good_type_t");// 商品类型
		String BusinessType = request.getParameter("BusinessType");// 支付方式
		Calendar cal = Calendar.getInstance();// 交易时间（月份记得+1）默认0开始
		User u = (User) request.getSession().getAttribute("user");
		if (u != null) {
			String user_id = u.getUser_id();
			if (BusinessType.equals("pay")) {// 立即支付
				List<Order> lo=new ArrayList<Order>();
				OrderService os=new OrderService();
				long time =	System.currentTimeMillis();
				CartService cs=new CartService();
				Good_selectService GsS=new Good_selectService();
				Order o=new Order();
				if (type.equals("cloth")) {
					float price = Float.parseFloat(request
							.getParameter("Goods_good_type_price_text"));
					String color = request
							.getParameter("Goods_good_type_c_color");
					String version = request
							.getParameter("Goods_good_type_v_version");
					int num = Integer.parseInt(request
							.getParameter("Goods_good_type_num_text"));
					int cloth_id = Integer.parseInt(request
							.getParameter("cloth_id"));
					 o.setGood_id(cloth_id);
					 o.setQuantity(num);
				     o.setPrice(num * price);
				     /*o.setOrdertime(cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH)+" "+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));*/
				     o.setOrdertime(time);
				     o.setState(1);
				     o.setUser_id(user_id);
				     o.setStore_id(GsS.findcloth_store(cloth_id).getStore_id());
				     os.add(o);
				}
				if (type.equals("book")) {
					float price = Float.parseFloat(request
							.getParameter("Goods_good_type_price_text"));
					String version = request
							.getParameter("Goods_good_type_v_version");
					int num = Integer.parseInt(request
							.getParameter("Goods_good_type_num_text"));
					int book_id = Integer.parseInt(request
							.getParameter("book_id"));
					 o.setGood_id(book_id);
					 o.setQuantity(num);
				     o.setPrice(num * price);
				     /*o.setOrdertime(cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH)+" "+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));*/
				     o.setOrdertime(time);
				     o.setState(1);
				     o.setUser_id(user_id);
				     o.setStore_id(GsS.findbook_store(book_id).getStore_id());
				     os.add(o);
				}
				if (type.equals("food")) {
					float price = Float.parseFloat(request
							.getParameter("Goods_good_type_price_text"));
					int num = Integer.parseInt(request
							.getParameter("Goods_good_type_num_text"));
					int food_id = Integer.parseInt(request
							.getParameter("food_id"));
					 o.setGood_id(food_id);
					 o.setQuantity(num);
				     o.setPrice(num * price);
				     /*o.setOrdertime(cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH)+" "+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));*/
				     o.setOrdertime(time);
				     o.setState(1);
				     o.setUser_id(user_id);
				     o.setStore_id(GsS.findfood_store(food_id).getStore_id());
				     os.add(o);
				}
				lo=os.findOrder(u.getUser_id());
				request.getSession().setAttribute("order_pay", lo);
				lo=os.findOrder(u.getUser_id(), 1);
				request.getSession().setAttribute("order_pay_1", lo);
				float totalprice = 0;
				int i=0;
				int num = 0;
				for(Order order1:lo){
					if(order1.getState()==1){
						num++;
						totalprice+=order1.getPrice();
					}
				}
				int [] order_id_arr=new int [num];
				for(Order order1:lo){
					if(order1.getState()==1){
						order_id_arr[i]=order1.getOrder_id();
						System.out.println(order_id_arr[i]);
						i++;
					}
				}
				request.setAttribute("totalprice", totalprice);
				request.getSession().setAttribute("order_id_arr", order_id_arr);
				
				RequestDispatcher rd = request.getRequestDispatcher("/pages/user/pay.jsp");
				rd.forward(request, response);
			} else if (BusinessType.equals("intocart")) {// 加入购物车
				Cart c = new Cart();
				CartService cs = new CartService();
				boolean message = false;
				if (type.equals("cloth")) {
					float price = Float.parseFloat(request
							.getParameter("Goods_good_type_price_text"));
					String color = request
							.getParameter("Goods_good_type_c_color");
					String version = request
							.getParameter("Goods_good_type_v_version");
					int num = Integer.parseInt(request
							.getParameter("Goods_good_type_num_text"));
					int cloth_id = Integer.parseInt(request
							.getParameter("cloth_id"));
					c.setGood_id(cloth_id);
					c.setQuantity(num);
					c.setTotalprice(num * price);
					c.setType("cloth");
					c.setUser_id(user_id);
					c.setVersion(color + ";" + version);
				}
				if (type.equals("book")) {
					float price = Float.parseFloat(request
							.getParameter("Goods_good_type_price_text"));
					String version = request
							.getParameter("Goods_good_type_v_version");
					int num = Integer.parseInt(request
							.getParameter("Goods_good_type_num_text"));
					int book_id = Integer.parseInt(request
							.getParameter("book_id"));
					c.setGood_id(book_id);
					c.setQuantity(num);
					c.setTotalprice(num * price);
					c.setType("book");
					c.setUser_id(user_id);
					c.setVersion(version);
				}
				if (type.equals("food")) {
					float price = Float.parseFloat(request
							.getParameter("Goods_good_type_price_text"));
					int num = Integer.parseInt(request
							.getParameter("Goods_good_type_num_text"));
					int food_id = Integer.parseInt(request
							.getParameter("food_id"));
					c.setGood_id(food_id);
					c.setQuantity(num);
					c.setTotalprice(num * price);
					c.setType("food");
					c.setUser_id(user_id);
				}
				message = cs.addCart(c);
				request.getSession().setAttribute("list_flag", true);
				request.getSession().setAttribute("message", message);
				RequestDispatcher rd = request
						.getRequestDispatcher("/pages/user/Goods.jsp");
				rd.forward(request, response);
			}
		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/pages/user/login.jsp");
			rd.forward(request, response);
		}
	}

}
