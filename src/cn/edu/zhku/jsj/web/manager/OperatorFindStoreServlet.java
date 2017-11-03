package cn.edu.zhku.jsj.web.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.jsj.domain.Operator;
import cn.edu.zhku.jsj.domain.Store;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;

/*
 * 管理员通过店铺名查找店铺
 */
@WebServlet("/servlet/OperatorFindStoreServlet")
public class OperatorFindStoreServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storename=request.getParameter("storename");
		HttpSession session=request.getSession();
		Operator operator=(Operator) session.getAttribute("operator");
		if(operator==null){
			session.setAttribute("message", "请先登录再查询，三秒后返回首页");
			request.getRequestDispatcher("/pages/operator_message.jsp").forward(request, response);
            return;		
		}
		BusinessService find=new BusinessServiceImpl();
		Store store=find.operator_find(storename);
		session.setAttribute("findstore", store);
		request.getRequestDispatcher("/pages/operator_findstore.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
