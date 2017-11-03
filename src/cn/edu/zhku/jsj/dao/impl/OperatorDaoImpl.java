package cn.edu.zhku.jsj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zhku.jsj.dao.OperatorDao;
import cn.edu.zhku.jsj.domain.Operator;
import cn.edu.zhku.jsj.domain.Store;
import cn.edu.zhku.jsj.web.utils.JdbcUtil;

public class OperatorDaoImpl implements OperatorDao {
	@Override
	public int add(Operator operator) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		String sql = "insert into operator values(null,?,?,null)";
		try {
			pres = con.prepareStatement(sql);
			pres.setString(1, operator.getName());
			pres.setString(2, operator.getPassword());

			// long time = operator.getLoginTime().getTime();
			// Timestamp timestamp = new Timestamp(time);
			// pres.setTimestamp(3, timestamp);

			int num = pres.executeUpdate();
			return num;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}
	}

	// 运营人员登录
	@Override
	public Operator find(String name, String password) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		String sql = "select * from operator where name=? and password=?";
		try {

			pres = con.prepareStatement(sql);
			pres.setString(1, name);
			pres.setString(2, password);
			rs = pres.executeQuery();
			Operator operator = null;
			while (rs.next()) {
				operator = new Operator();
				operator.setO_id(rs.getInt("o_id"));
				operator.setName(rs.getString("name"));
				operator.setPassword(rs.getString("password"));
				operator.setLoginTime(rs.getDate("loginTime"));
			}
			return operator;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}

	}

	// 管理员登录后添加登录时间
	public int Time(Operator operator) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		String sql = "update operator set loginTime=? where name=?";
		try {
			pres = con.prepareStatement(sql);

			long time = operator.getLoginTime().getTime();
			Timestamp timestamp = new Timestamp(time);
			pres.setTimestamp(1, timestamp);
			pres.setString(2, operator.getName());
			int num = pres.executeUpdate();
			return num;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}
	}

	// 管理员登录后，获取店铺的信息
	public List Information() {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		String sql = "select * from store";
		try {
			pres = con.prepareStatement(sql);
			rs = pres.executeQuery();
			List list = new ArrayList<Store>();
			Store store =null;
			while (rs.next()) {
				store=new Store();
				store.setStore_id(rs.getInt("store_id"));
				store.setControl(rs.getInt("control"));
				store.setDescription(rs.getString("description"));
				store.setOwner_id(rs.getString("owner_id"));
				store.setStorename(rs.getString("storename"));
				list.add(store);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}
	}
	
	//店铺管理
	public int control(int control,String storename){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		String sql = "update store set control=? where storename=?";
		try {
			pres = con.prepareStatement(sql);
			pres.setInt(1, control);
			pres.setString(2, storename);
			int num = pres.executeUpdate();
			return num;
		}catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}
	}
	
	//根据店铺名查找店铺
	public Store operator_FindStore(String storename){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		String sql = "select * from store where storename=?";
		try {
			pres = con.prepareStatement(sql);
			pres.setString(1, storename);
			rs = pres.executeQuery();	
			Store store = null;
			while (rs.next()) {
				store=new Store();
				store.setStore_id(rs.getInt("store_id"));
				store.setControl(rs.getInt("control"));
				store.setDescription(rs.getString("description"));
				store.setOwner_id(rs.getString("owner_id"));
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
