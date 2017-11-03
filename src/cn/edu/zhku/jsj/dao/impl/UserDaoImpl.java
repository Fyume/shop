package cn.edu.zhku.jsj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.edu.zhku.jsj.dao.UserDao;
import cn.edu.zhku.jsj.domain.Store;
import cn.edu.zhku.jsj.domain.User;
import cn.edu.zhku.jsj.web.utils.JdbcUtil;

public class UserDaoImpl implements UserDao {

	// 用户注册
	@Override
	public int add(User user) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();

		try {
			String sql = "insert into user values(?,?,?,?,?,?,?,?,?)";
			pres = con.prepareStatement(sql);   
			pres.setString(1, user.getUser_id());//user_id 表示 用户的账号 
			pres.setString(2, user.getNickname());
			pres.setString(3, user.getPassword());
			pres.setString(4, user.getPhonenum());
			pres.setString(5, user.getEmail());
			pres.setString(6, user.getAddress());
			pres.setString(7, user.getCardID());
			pres.setInt(8, user.getRole()); // 顾客默认为 1 顾客变为店家 是 改为 2
			pres.setString(9, user.getImage());

			int num = pres.executeUpdate();
			return num;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}
	}

	// 注册时查找 是否已经存在,更新个人资料时用于更新session中的user
	@Override
	public User find(String user_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try {
			String sql = "select * from user where user_id=?";
			pres = con.prepareStatement(sql);
			pres.setString(1, user_id);
			rs = pres.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUser_id(rs.getString("user_id"));
				user.setAddress(rs.getString("address"));
				user.setCardID(rs.getString("cardID"));
				user.setEmail(rs.getString("email"));
				user.setImage(rs.getString("image"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getInt("role"));
				user.setPhonenum(rs.getString("phonenum"));
				return user;
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}

	}

	// 用户登录时查找
	@Override
	public User find(String user_id, String password) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try {
			String sql = "select * from user where user_id=? and password=?";
			pres = con.prepareStatement(sql);
			pres.setString(1, user_id);
			pres.setString(2, password);
			rs = pres.executeQuery();
			User user = null;
			while (rs.next()) {
				user = new User();
				user.setUser_id(rs.getString("user_id"));
				user.setAddress(rs.getString("address"));
				user.setCardID(rs.getString("cardID"));
				user.setEmail(rs.getString("email"));
				user.setImage(rs.getString("image"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getInt("role"));
				user.setPhonenum(rs.getString("phonenum"));
			}
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}

	}

	// 忘记登录密码时，检验用户
	public User find(String user_id, String phonenum, String email) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		String sql = "select * from user where user_id=? and phonenum=? and email=?";
		try {
			pres = con.prepareStatement(sql);
			pres.setString(1, user_id);
			pres.setString(2, phonenum);
			pres.setString(3, email);
			rs = pres.executeQuery();
			User user = null;
			while (rs.next()) {
				user = new User();
				user.setUser_id(rs.getString("user_id"));
				user.setAddress(rs.getString("address"));
				user.setCardID(rs.getString("cardID"));
				user.setEmail(rs.getString("email"));
				user.setImage(rs.getString("image"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getInt("role"));
				user.setPhonenum(rs.getString("phonenum"));
			}
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}

	}

	// 忘记密码时，修改密码
	public int change(String user_id, String password) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try {
			String sql = "update user set password=? where user_id=?";
			pres = con.prepareStatement(sql);
			pres.setString(1, password);
			pres.setString(2, user_id);
			int num = pres.executeUpdate();
			return num;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}
	}
	
	//用户开店，在用户的数据库中增加身份证号，店主身份
	public int update_user(String user_id,String cardID,int role){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql="update user set cardID=?,role=? where user_id=?";
			pres = con.prepareStatement(sql);
			pres.setString(1, cardID);
			pres.setInt(2, role);
			pres.setString(3, user_id);
			int num = pres.executeUpdate();
			return num;
		}catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}
		
	}
	
	//用户修改个人资料
	public int changeInformation(User user){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql="update user set phonenum=?,email=?,nickname=?,address=? where user_id=?";
			pres = con.prepareStatement(sql);
			pres.setString(1, user.getPhonenum());
			pres.setString(2, user.getEmail());
			pres.setString(3, user.getNickname());
			pres.setString(4, user.getAddress());
			pres.setString(5, user.getUser_id());
			int num = pres.executeUpdate();
			return num;
		}catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}
		
	}
	
	//用户登录后查看我的店铺
	public Store myStore(String owner_id){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		String sql="select * from store where owner_id=?";
		Store store=null;
		try{
			pres = con.prepareStatement(sql);
			pres.setString(1, owner_id);
			rs = pres.executeQuery();
			
			while(rs.next()){
				store=new Store();
				store.setControl(rs.getInt("control"));
				store.setDescription(rs.getString("description"));
				store.setOwner_id(rs.getString("owner_id"));
				store.setStore_id(rs.getInt("store_id"));
				store.setStorename(rs.getString("storename"));
			}
			return store;
		}catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}
	}
}
