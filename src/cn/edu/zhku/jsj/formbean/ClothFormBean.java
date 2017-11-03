package cn.edu.zhku.jsj.formbean;

import java.util.HashMap;
import java.util.Map;

public class ClothFormBean {
	private String clothname;
	private float price;
	private String color;
	private String size;
	private String version;
	private String images;
	private int store_id;
	private int totalnum;
	
	private int cloth_id;
	
	public int getCloth_id() {
		return cloth_id;
	}
	public void setCloth_id(int cloth_id) {
		this.cloth_id = cloth_id;
	}

	private Map<String,String> errormap = new HashMap<String,String>();
	
	
	public Map<String, String> getErrormap() {
		return errormap;
	}
	public void setErrormap(Map<String, String> errormap) {
		this.errormap = errormap;
	}
	public String getClothname() {
		return clothname;
	}
	public void setClothname(String clothname) {
		this.clothname = clothname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public int getTotalnum() {
		return totalnum;
	}
	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}
	
	public boolean checkoutData(){
		boolean b = false;
		if(this.clothname==null || this.clothname.trim().equals("")){
			errormap.put("clothname", "请输入衣服名称");
			return b;
		}
		if(this.price==0){
			errormap.put("price", "请输入衣服单价");
			return b;
		}
		if(this.color==null || this.color.trim().equals("")){
			errormap.put("color", "请填入衣服颜色");
			return b;
		}
		if(this.size==null || this.size.trim().equals("")){
			errormap.put("size", "请填入衣服码数");
			return b;
		}
		if(this.version==null || this.version.trim().equals("")){
			errormap.put("version", "请填入衣服的款式");
			return b;
		}
		if(this.totalnum==0){
			errormap.put("totalnum", "请输入商品货存量");
			return b;
		}
		b = true;
		return b;
	}
	
}
