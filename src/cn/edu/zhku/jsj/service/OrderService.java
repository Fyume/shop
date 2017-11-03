package cn.edu.zhku.jsj.service;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zhku.jsj.dao.OrderDao;
import cn.edu.zhku.jsj.dao.impl.OrderDaoImpl;
import cn.edu.zhku.jsj.domain.Cart;
import cn.edu.zhku.jsj.domain.Order;

public class OrderService {
	private OrderDao od=new OrderDaoImpl();
	private List<Order> lo=new ArrayList<Order>();
	public void add(Order order){
		od.add(order);
	}
	public List<Order> findOrder(String user_id){
		lo=od.findOrder(user_id);
		return lo;
	}
	public void deleteorder(int order_id){
		od.delete(order_id);
	}
	public List<Order> findOrder(String user_id,int state){
		lo=od.findOrder(user_id,state);
		return lo;
	}
}
