package cn.edu.zhku.jsj.web.utils;

import java.util.HashMap;
import java.util.Map;

public class StoreRegisterBean {

	private String cardID;
	private String description;
	private String storename;
	private int role;
	private Map errors=new HashMap();
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	public boolean validate(){
		boolean isOK=true;
		
		//检验身份证号
		if(this.cardID==null||this.cardID.trim().equals("")){
			isOK=false;
			errors.put("cardID", "身份证号不能为空");
		}else{
			if(!this.cardID.matches("\\d{18}")){
				isOK=false;
				errors.put("cardID", "身份证号必须为数字组成的18位");
			}
		}
		
		//校验描述信息
		if(this.description==null||this.description.trim().equals("")){
			isOK=false;
			errors.put("description", "描述信息不能为空");
		}else{
			if(!this.description.matches("[\u4e00-\u9fa5]{5,255}")){
				isOK=false;
				errors.put("description", "描述信息必须为汉字组成的5-255位");
			}
		}
		
		//校验店铺名字
				if(this.storename==null||this.storename.trim().equals("")){
					isOK=false;
					errors.put("storename", "店铺名不能为空");
				}else{
					if(!this.storename.matches("[\u4e00-\u9fa5]{2,8}")){
						isOK=false;
						errors.put("storename", "店铺名必须为汉字组成的2-8位");
					}
				}
				//检验身份信息
				if(role!=2){
					isOK=false;
					errors.put("role", "没有勾选");
				}
		return isOK;
	}
}

