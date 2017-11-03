package junit.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import cn.edu.zhku.jsj.dao.impl.UserDaoImpl;
import cn.edu.zhku.jsj.domain.User;
import cn.edu.zhku.jsj.exception.UserexistException;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;
import cn.edu.zhku.jsj.web.utils.JdbcUtil;

public class UserDaoTest {
	@Test
	public void addTest(){
		User user = new User();
		user.setUser_id("我就是叨叨");
		user.setNickname("我就wowo");
		user.setPassword("123");
		user.setPhonenum("123456789");
		user.setEmail("12123@github.com");
		user.setAddress("广东省广州市");
		user.setRole(1);  
		user.setCardID(null);
		user.setImage("c://haha2.jpg");
		/*UserDaoImpl userdao = new UserDaoImpl();*/
		BusinessService bus = new BusinessServiceImpl();
		try {
			bus.adduser(user);
		} catch (UserexistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*@Test
	public void rsTest(){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql = "select * from book";
			pres = con.prepareStatement(sql);
			rs = pres.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("数据库列数 "+rsmd.getColumnCount());
			String name = rsmd.getColumnLabel(1);
			System.out.println(name);
			System.out.println(rsmd.getColumnLabel(2));
			
			String name = "";
			while(rs.next()){
				for(int i=1;i<=rsmd.getColumnCount();i++){
					name = rsmd.getColumnLabel(i);
					Object value = rs.getObject(name);
					Class<?> type = value.getClass();
					System.out.println(type);
				}
				
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			
		}
	}*/
	
	@Test
	public void rsTest(){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql = "select * from book";
			pres = con.prepareStatement(sql);
			rs = pres.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("数据库列数 "+rsmd.getColumnCount());
			/*String name = rsmd.getColumnLabel(1);
			System.out.println(name);
			System.out.println(rsmd.getColumnLabel(2));
			*/
			String name = "";
			while(rs.next()){
				for(int i=1;i<=rsmd.getColumnCount();i++){
					name = rsmd.getColumnLabel(i);
					Object value = rs.getObject(name);
					Class<?> type = value.getClass();
					System.out.println(type);
				}
				
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			
		}
	}
	
	@Test
	public void TestString(){
		String str = "aadd,adsdfasf,";
		int strnum = str.lastIndexOf(",");
		String str1 = str.substring(0,strnum);
		System.out.println(str1);
	}
	
}
