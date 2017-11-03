package cn.edu.zhku.jsj.web.utils;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	private static Properties dbconfig = new Properties();
	static{
		//读取配置文件 的数据库连接的信息
		InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			dbconfig.load(in);
			Class.forName(dbconfig.getProperty("driver"));
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	public static Connection getCon(){
		String url = dbconfig.getProperty("url");
		String username = dbconfig.getProperty("username");
		String password = dbconfig.getProperty("password");
		try {
			return DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void release(Connection con,Statement st,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			st = null;
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			con = null;
		}
	}
}
