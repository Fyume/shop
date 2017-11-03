package junit.test;

import org.junit.Test;

import cn.edu.zhku.jsj.dao.CartDao;
import cn.edu.zhku.jsj.dao.impl.CartDaoImpl;

public class CartDaoTest {
	private CartDao cd=new CartDaoImpl();
	@Test
	public void count(){
		System.out.println(cd.countCart("aaa"));
	}
	@Test
	public void all(){
		System.out.println(cd.findAll("aaa"));
	}
}
