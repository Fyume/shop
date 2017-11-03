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
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
		String[] cart_id=request.getParameterValues("cart_single_checkbox_c");
		CartService cs=new CartService();
		OrderService os=new OrderService();
		Good_selectService GsS=new Good_selectService();
		User u=(User)request.getSession().getAttribute("user");
		List<Order> lo=new ArrayList<Order>();
		Order o=new Order();
		Cart c=new Cart();
		String type=null;
		long time =	System.currentTimeMillis();
		if(cart_id!=null&&cart_id.length>0) {//若传过来的值不为空
	        for(int i= 0 ;i<cart_id.length;i++){
	        c=cs.findcart(Integer.parseInt(cart_id[i]));//根据传过来的id找到购物车内容
	        cs.deletecart(Integer.parseInt(cart_id[i]));//相应的 删除相应购物项记录
	        type=c.getType();
	        o.setGood_id(c.getGood_id());
	        o.setQuantity(c.getQuantity());
	        o.setPrice(c.getTotalprice() );
	        /*o.setOrdertime(cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH)+" "+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));*/
	        o.setOrdertime(time);
	        o.setState(1);
	        if(type.equals("cloth")){
	        	o.setStore_id(GsS.findcloth_store(c.getGood_id()).getStore_id());
	        }
	        if(type.equals("book")){
	        	o.setStore_id(GsS.findbook_store(c.getGood_id()).getStore_id());
	        }
	        if(type.equals("food")){
	        	o.setStore_id(GsS.findfood_store(c.getGood_id()).getStore_id());
	        }
	        o.setUser_id(u.getUser_id());
	        os.add(o);
	        }
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
	}

}
