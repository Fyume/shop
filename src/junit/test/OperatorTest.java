package junit.test;

import java.util.Date;

import org.junit.Test;

import cn.edu.zhku.jsj.dao.impl.OperatorDaoImpl;
import cn.edu.zhku.jsj.domain.Operator;

public class OperatorTest {
	@Test
	public void addTest(){
		Operator ope = new Operator();
		ope.setName("管理员1");
		ope.setLoginTime(new Date (System.currentTimeMillis()));
		ope.setPassword("123");
		
		OperatorDaoImpl opedao = new OperatorDaoImpl();
		opedao.add(ope);
	}
}
