package cn.edu.zhku.jsj.web.utils;

import java.util.HashMap;

import java.util.Map;

public class RegisterCheckBean {

	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	private String user_id;
	private String nickname;
	private String password;
	private String password2;
	private String phonenum;//int超出范围
	private String email;
	private String address;
	private int role=1;//是否为店主   1 为顾客   2 为店主
	private String cardID;  //普通用户注册时 不显示 注册店家时 要输入真实身份证号
	private String image;
	private Map errors=new HashMap();
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	//检验数据
	public boolean validate(){
		boolean isOK=true;
		
		//检验用户的id
		if(this.user_id==null||this.user_id.trim().equals("")){
			isOK=false;
			errors.put("user_id", "用户名不能为空");
		}else{
			if(!this.user_id.matches("[a-zA-Z]{3,8}")){
				isOK=false;
				errors.put("user_id", "用户名必须为字母组成的3-8位");
			}
		}
		
		//检验用户密码
		if(this.password==null||this.password.trim().equals("")){
			isOK=false;
			errors.put("password", "密码不能为空");
		}else{
			if(!this.password.matches("\\d{8,16}")){
				isOK=false;
				errors.put("password", "密码必须为数字组成的8-16位");
			}
		}
		
		//检验用户的确认密码
		if(this.password2==null){
			isOK=false;
			errors.put("password2", "确认密码不能为空");
		}else{
			if(!this.password2.equals(this.password)){
				isOK=false;
				errors.put("password2", "两次密码必须一致");
			}
		}
		
		//检验用户的邮箱
		if(this.email==null||this.email.trim().equals("")){
			isOK=false;
			errors.put("email", "邮箱不能为空");
		}else{
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
				isOK=false;
				errors.put("email", "邮箱不是一个合法邮箱");
			}
		}
		
		//检验用户的昵称
		if(this.nickname==null||this.nickname.trim().equals("")){
			isOK=false;
			errors.put("nickname", "用户的昵称不能为空");
		}else{
			if(!this.nickname.matches("[\u4e00-\u9fa5]{1,6}")){
				isOK=false;
				errors.put("nickname", "用户的昵称必须为汉字");
			}
		}
		
		//检验联系方式
		if(this.phonenum==null||this.phonenum.trim().equals("")){
			isOK=false;
			errors.put("phonenum", "联系电话不能为空");
		}else{
			if(!this.phonenum.matches("\\d{11}")){
				isOK=false;
				errors.put("phonenum", "联系电话不是一个合法");
			}
		}
		
		//检验地址
		if(this.address==null||this.address.trim().equals("")){
			isOK=false;
			errors.put("address", "地址不能为空");
		}
		
		return isOK;
	}
}
