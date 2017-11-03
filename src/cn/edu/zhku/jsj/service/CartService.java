package cn.edu.zhku.jsj.service;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.dao.CartDao;
import cn.edu.zhku.jsj.dao.impl.CartDaoImpl;
import cn.edu.zhku.jsj.domain.Cart;

public class CartService {
	private CartDao cd=new CartDaoImpl();
	private Cart c=new Cart();
	private boolean mess=false;
	public boolean addCart(Cart cart){
		int message=cd.add(cart);
		if(message!=0){
		return true;
		}
		return false;
	}
	public int countCart(String user_id){
		int num=cd.countCart(user_id);
		return num;
	}
	public List<Map> findall(String user_id){
		List<Map> list=cd.findAll(user_id);
		return list;
	}
	public boolean deletecart(int cart_id){
		mess=cd.delete(cart_id);
		return mess;
	}
	public boolean updatecart(int cart_id,int quantity){
		mess=cd.update(cart_id, quantity);
		return mess;
	}
	public Cart findcart(int cart_id){
		c=cd.findCart(cart_id);
		return c;
	}
}
