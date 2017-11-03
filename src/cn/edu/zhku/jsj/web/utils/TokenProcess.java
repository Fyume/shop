package cn.edu.zhku.jsj.web.utils;

import java.util.UUID;
//单例模式 生成 唯一编号  防止用户重复提交表单
public class TokenProcess {
	private TokenProcess(){}
	private static final TokenProcess token = new TokenProcess();
	public static TokenProcess getInstance(){
		return token;
	}
	public  String getUuidnum(){
		return UUID.randomUUID().toString()+"";
	}
}
