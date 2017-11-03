package cn.edu.zhku.jsj.domain;

public class Store {
	private int store_id;
	private String storename;
	private String owner_id; // 店铺所属人（店家）
	private String description;
	private int control;  //判断管理员是否封铺了，0表示没封，1表示封了
	private String images;
	
	public int getControl() {
		return control;
	}
	public void setControl(int control) {
		this.control = control;
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

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public String getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
