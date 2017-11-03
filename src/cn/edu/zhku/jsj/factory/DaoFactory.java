package cn.edu.zhku.jsj.factory;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
	
	private static Properties prop = new Properties();
	private DaoFactory(){
		try{
			InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("cn/edu/zhku/jsj/factory/dao.properties");//查找具有给定名称的资源。
			prop.load(in);//从输入流中读取属性列表（键和元素对）。
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	};
	private static final DaoFactory instance = new DaoFactory();
	public static DaoFactory getInstance(){
		return instance;
	}
	
	//BookDao.class
	public <T> T createDao(Class<T> interfaceClass){
		try{
			String key = interfaceClass.getSimpleName();//返回源代码中给出的底层类的简称。
			String className = prop.getProperty(key);// 用指定的键在此属性列表中搜索属性。
			return (T) Class.forName(className).newInstance();// 返回与带有给定字符串名的类或接口相关联的 Class 对象。//创建此 Class 对象所表示的类的一个新实例。
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
