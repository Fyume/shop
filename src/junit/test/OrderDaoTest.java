package junit.test;

import org.junit.Test;

import cn.edu.zhku.jsj.dao.OrderDao;
import cn.edu.zhku.jsj.dao.impl.OrderDaoImpl;
import cn.edu.zhku.jsj.domain.Order;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;

public class OrderDaoTest {
	private OrderDao od=new OrderDaoImpl();
	BusinessService bus = new BusinessServiceImpl();
	@Test
	public void testAdd(){
		Order o = new Order();
		o.setGood_id(1);
		o.setOrdertime(System.currentTimeMillis());
		o.setPrice(120);
		o.setQuantity(2);
		o.setStore_id(2);
		o.setUser_id("我就是叨叨");
		o.setState(2);
		int num = bus.addOrder(o);
		
		
	}
	@Test 
	public void teststate(){
		int order_id = 2;
		bus.updateOrder_state(order_id);
	}
	@Test
	public void delete(){
		od.delete(12);
	}
}
