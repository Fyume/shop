package cn.edu.zhku.jsj.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.domain.Order;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;
import cn.edu.zhku.jsj.web.utils.PayConfig;
import cn.edu.zhku.jsj.web.utils.PaymentUtil;

/**
 * Servlet implementation class PaymentResponse
 */
@WebServlet("/servlet/PaymentResponse")
public class PaymentResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("gb2312");
		response.setContentType("text/html;charset=gb2312");
		
		String p1_MerId = PayConfig.getValue("p1_MerId");
		String r0_Cmd = request.getParameter("r0_Cmd");
		String r1_Code = request.getParameter("r1_Code");
		String r2_TrxId = request.getParameter("r2_TrxId");
		String r3_Amt = request.getParameter("r3_Amt");
		String r4_Cur = request.getParameter("r4_Cur");
		String r5_Pid = request.getParameter("r5_Pid");
		String r6_Order = request.getParameter("r6_Order");
		String r7_Uid = request.getParameter("r7_Uid");
		String  r8_MP= request.getParameter("r8_MP");
		String r9_BType = request.getParameter("r9_BType");
		String hmac = request.getParameter("hmac");
		
		String keyValue = PayConfig.getValue("keyValue");
		
		boolean b = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid, r8_MP, r9_BType, keyValue);
		if(!b){
			response.getWriter().write("交易签名已被修改！！！");
			return;
		}
		
		if("1".equals(r1_Code)){  //处理支付成功
			if("1".equals(r9_BType)){
				response.getWriter().write("支付成功！！ 3秒后跳回首页");
				//支付成功后 update order 表  将状态改为 已支付 2
				BusinessService bus = new BusinessServiceImpl();
				Order o = (Order) request.getSession().getAttribute("order_pay");
				int [] order_id_arr = (int[]) request.getSession().getAttribute("order_id_arr");
				for(int i=0;i<order_id_arr.length;i++){
					System.out.println(order_id_arr[i]);
					bus.updateOrder_state(order_id_arr[i]);
				}
				request.getSession().setAttribute("message", "支付成功,3秒后跳回首页  <meta http-equiv='refresh' content='3;url=/shop/pages/user/index.jsp'>");
				response.sendRedirect("/shop/pages/user/message.jsp");
				return;
			}
			if("2".equals(r9_BType)){
				response.getWriter().write("success");
			}
			
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
