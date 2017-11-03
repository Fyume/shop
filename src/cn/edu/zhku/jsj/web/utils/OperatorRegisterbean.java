package cn.edu.zhku.jsj.web.utils;

import java.util.HashMap;
import java.util.Map;

public class OperatorRegisterbean {

	private String name;
	private String password;
	private String password2;
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	private Map errors=new HashMap();
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean vaildate(){
		boolean isOK=true;
		//检验用户的id
		if(this.name==null||this.name.trim().equals("")){
			isOK=false;
			errors.put("name", "用户名不能为空");
		}else{
			if(!this.name.matches("[a-zA-Z]{3,8}")){
				isOK=false;
				errors.put("name", "用户名必须为字母组成的3-8位");
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
		return isOK;
	}
}
