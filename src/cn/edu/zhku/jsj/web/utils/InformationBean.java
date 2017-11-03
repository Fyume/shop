package cn.edu.zhku.jsj.web.utils;

import java.util.HashMap;
import java.util.Map;

public class InformationBean {


	

	private String nickname;
	private String address;
	private String email;
	private String phonenum;
	private Map errors=new HashMap();
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
 
	public boolean validate(){
		boolean isOK=true;
		
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
