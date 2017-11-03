package cn.edu.zhku.jsj.web.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

import com.sun.mail.util.BASE64EncoderStream;

//用用户密码的加密，采用md5码加密。
public class Md5 {

	public static String md5(String password){
		try {
			MessageDigest md=MessageDigest.getInstance("md5");
			byte[] buf= md.digest(password.getBytes());
			BASE64Encoder encoder=new BASE64Encoder();
			String str=encoder.encode(buf);
			return str;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
