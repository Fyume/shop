package cn.edu.zhku.jsj.domain;

public class Cart {
	private int cart_id;
	private int good_id;
	private String type;//记录从哪个（种类）表查找
	private String user_id;//外键 记住这个购物车是哪个 用户的
	private int quantity;//商品数量
	//private float unitprice;//商品单价
	private float totalprice;//小计 每种商品价格 * 数量
	//private String imgurl;
	private String version;
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	
	public int getGood_id() {
		return good_id;
	}
	public void setGood_id(int good_id) {
		this.good_id = good_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	

}
