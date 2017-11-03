<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="store_nav.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div id="order_big">
		<div id="order_big_in">
			<div id="form_up_order">
				<form action="${pageContext.request.contextPath }/servlet/StoreOrderServlet?store_id=2" id="order_form" method="post">
					<input type="hidden" id="order_input_1" name="order_type">
					<div id="order_tab">
						<ul id="ul_new">
				                <li class="list"><input onclick="allorder()" type="button" value="所有订单" class="order_button"></li>
				                <li class="list"><input onclick="beforeorder()" type="button" value="未处理订单" class="order_button"></li>
				                <li class="list"><input onclick="finishorder()" type="button" value="已处理订单" class="order_button"></li>
				         </ul>
					</div>
				</form>
			</div>
			<div id="order_result">
				<table border="1" cellspacing="0" style="background-color:#dddddd" align="center" width="850px">
               			<tr>
               				<th>订单编号</th><th>商品编号</th><th>顾客账号</th><th>购买数量</th><th>下单时间</th><th>订单状态</th><th>订单总额(元/￥)</th><th>订单管理</th>
               			</tr>
               			<c:forEach var="order_item" items="${orderlist}">
	               			<tr>
	               				<td>${order_item.order_id}</td><td>${order_item.good_id }</td><td>${order_item.user_id }</td><td>${order_item.quantity }</td><td>${order_item.time }</td>
								<c:choose>
									<c:when test="${order_item.state==1 }">
										<td>未付款</td>
									</c:when>
									<c:when test="${order_item.state==2 }">
										<td>已付款</td>
									</c:when>
									<c:otherwise>
										<td>已发货</td>
									</c:otherwise>
								</c:choose>	   
								<td>${order_item.price}</td>    
								<td>
									<c:choose>
										<c:when test="${order_item.state==2 }">
											<a href="${pageContext.request.contextPath }/servlet/Go_goodServlet?order_id=${order_item.order_id}">去发货</a>
										</c:when>
										<c:otherwise>
											<font style="colot:#c6c6c6">去发货</font>
										</c:otherwise>
									</c:choose>
									
									<c:if test="${order_item.state==2 }">
										<font style="colot:#c6c6c6">删除</font>
									</c:if>
									<c:if test="${order_item.state==3 }">
										<a href="${pageContext.request.contextPath }/servlet/StoreOrderServlet?order_id=${order_item.order_id}">删除</a>
									</c:if>
								</td>
								        				
	               			</tr>
               			</c:forEach>
               	</table>
			</div>
		</div>
	</div> 
</div>
  </body>
</html>
