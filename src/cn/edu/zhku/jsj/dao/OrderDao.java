package cn.edu.zhku.jsj.dao;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.domain.Order;

public interface OrderDao {

	int add(Order order);

	List<Map> findAll();

	boolean delete(int order_id);
	
	List<Order> getstore_Orders(int store_id);
	Order getstore_Orders2(int order_id);
	
	List<Order> getstore_BFOrders(int store_id,int states);
	
	boolean updateState(int order_id);
	boolean updateState2(int order_id);
	List<Order> findOrder(String user_id);

	List<Order> findOrder(String user_id, int state);
	boolean deleteorder(int order_id);
}