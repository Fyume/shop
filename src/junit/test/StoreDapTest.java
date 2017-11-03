package junit.test;

import org.junit.Test;

import cn.edu.zhku.jsj.dao.impl.StoreDaoImpl;
import cn.edu.zhku.jsj.domain.Store;
import cn.edu.zhku.jsj.domain.User;

public class StoreDapTest {
	private Store sto = new Store();
	private StoreDaoImpl storedao = new StoreDaoImpl();
	@Test
	public void addTest(){
		
		sto.setStorename("美宜佳");
		sto.setOwner_id("我就是叨叨");
		sto.setDescription("这是一家便利店");
		
		
		storedao.add(sto);
	}
	
	@Test
	public void ClassTest(){
		System.out.println(Store.class.getName());
	}
	@Test
	public void findowner(){
		User u=storedao.findowner("aaa");
		System.out.println(u.getNickname());
	}
}
