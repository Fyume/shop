package cn.edu.zhku.jsj.dao;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.domain.Cart;

public interface CartDao {

	//顾客选中物品加入购物车
	int add(Cart cart);

	//修改商品的数量
	boolean update(int cart_id, int quantity);

	boolean delete(int cart_id);

	int countCart(String user_id);

	List<Map> findAll(String user_id);

	Cart findCart(int cart_id);

}