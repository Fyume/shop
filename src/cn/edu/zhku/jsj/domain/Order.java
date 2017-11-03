package cn.edu.zhku.jsj.domain;

import java.sql.Timestamp;


public class Order {
	private int order_id;
	private int good_id;
	private int store_id;    //外键 记住订单是哪个店铺的
	private String user_id;//外键 记住这个购物车是哪个 用户的
	private int quantity;//商品数量
	private long ordertime;  //下单时间
	private int state;   //订单状态  1代表 未付款 2代表 已付款 3代表 已发货 
	private float price;    //订单总价	
	
	public Timestamp getTime(){
		return new Timestamp(this.getOrdertime());
	}
	
	public int getOrder_id() {
		return order_id;
	}
	public long getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(long ordertime) {
		this.ordertime = ordertime;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getGood_id() {
		return good_id;
	}
	public void setGood_id(int good_id) {
		this.good_id = good_id;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
