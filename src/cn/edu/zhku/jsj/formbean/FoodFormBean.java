package cn.edu.zhku.jsj.formbean;

import java.util.HashMap;
import java.util.Map;

public class FoodFormBean {
	private String foodname;
	private String description;
	private float price;
	private int totalnum;
	private int store_id;
	
	private int food_id;
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	private Map<String,String> errormap = new HashMap<String,String>();
	public String getFoodname() {
		return foodname;
	}
	public Map<String, String> getErrormap() {
		return errormap;
	}
	public void setErrormap(Map<String, String> errormap) {
		this.errormap = errormap;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getTotalnum() {
		return totalnum;
	}
	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}
	public boolean checkoutData(){
		boolean b = false;
		if(this.foodname==null || this.foodname.trim().equals("")){
			System.out.println(foodname);
			errormap.put("foodname", "商品名称不能为空");
			return b;
		}
		if(this.price==0){
			errormap.put("price", "商品单价不能为空且只能填入数字");
			return b;
		}
		if(this.totalnum==0){
			errormap.put("totalnum", "商品库存不能为空且只能填入数字");
			return b;
		}
		if(this.description==null || this.description.trim().equals("")){
			errormap.put("description", "商品描述不能为空");
			return b;
		}
		b = true;
		return b;
	}
}
