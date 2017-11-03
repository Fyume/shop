package cn.edu.zhku.jsj.web.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class RegisterCheckBeanUtil {

	public static<T> T registerBean(HttpServletRequest request,Class<T> clazz){
		try {
			T bean=clazz.newInstance();
			Enumeration en=request.getParameterNames();
			while(en.hasMoreElements()){
				String name=(String) en.nextElement();
				String value=request.getParameter(name);
				if(!name.trim().equals("uuid") || !name.trim().equals("moduuidnum"))
					BeanUtils.setProperty(bean, name, value);
			}
			
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
	}
}
