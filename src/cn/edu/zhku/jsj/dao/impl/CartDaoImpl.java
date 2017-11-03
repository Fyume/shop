package cn.edu.zhku.jsj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.dao.CartDao;
import cn.edu.zhku.jsj.domain.Cart;
import cn.edu.zhku.jsj.domain.Cloth;
import cn.edu.zhku.jsj.web.utils.JdbcUtil;
import cn.edu.zhku.jsj.web.utils.ResultToBean;

public class CartDaoImpl implements CartDao {
	// 顾客选中物品加入购物车
	@Override
	public int add(Cart cart) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try {
			String sql = "insert into cart values(null,?,?,?,?,?,?)";
			pres = con.prepareStatement(sql);
			pres.setInt(1, cart.getGood_id());
			pres.setString(2, cart.getUser_id());
			pres.setInt(3, cart.getQuantity());
			pres.setFloat(4, cart.getTotalprice());
			pres.setString(5, cart.getType());
			pres.setString(6, cart.getVersion());
			int num = pres.executeUpdate();
			return num;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}
	}

	@Override
	public List<Map> findAll(String user_id) {
		// 查找 cart 表 将 购物项 找出
		// 将信息存在 map集合 里（关键字是 order表的字段名 value是字段名对应值）然后再将map存在 list中,最后返回list集合
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		con = JdbcUtil.getCon();
		List<Map> list = new ArrayList<Map>();
		try {
			String sql = "select * from cart where user_id=?";
			pres = con.prepareStatement(sql);
			pres.setString(1, user_id);
			rs = pres.executeQuery();
			// 获得ResultSetMetaData对象
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获得返回此 ResultSet 对象中的列数
			int count = rsmd.getColumnCount();
			System.out.println(count);
			while (rs.next()) {
				Map map = new HashMap();
				int id=rs.getInt("good_id");
				for (int i = 1; i <= count; i++) {
					// 获取指定列的表目录名称
					String label = rsmd.getColumnLabel(i);
					System.out.println("label:"+label);
					// 以 Java 编程语言中 Object 的形式获取此 ResultSet 对象的当前行中指定列的值
					Object object = rs.getObject(i);
					System.out.println("object:"+object);
					if(label.equals("type")){
						String sql1 = "select images from "+object+" where "+object+"_id=?";
						pres = con.prepareStatement(sql1);
						pres.setInt(1, id);
						rs1 = pres.executeQuery();
						while(rs1.next()){
						map.put("images", rs1.getString("images"));
						}
					}
					// 把数据库中的字段名和值对应为一个map对象中的一个键值对
					map.put(label.toLowerCase(), object);
				}
				// 把每条对象封装成的map对象放进list中
				list.add(map);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}
	}

	// 修改商品的数量
	@Override
	public boolean update(int cart_id, int quantity) { // 可以修改数量
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try {
			int num = 0;
			String sql = "update cart set quantity=? where cart_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, quantity);
			pres.setInt(2, cart_id);
			num = pres.executeUpdate();
			if(num!=0){
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}
	}

	@Override
	public boolean delete(int cart_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try {
			int num = 0;
			String sql = "delete from cart where cart_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, cart_id);
			num = pres.executeUpdate();
			if(num!=0){
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}
	}

	@Override
	public int countCart(String user_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try {
			int num = 0;
			String sql = "select count(*) as num from cart where user_id=?";
			pres = con.prepareStatement(sql);
			pres.setString(1, user_id);
			rs = pres.executeQuery();
			while (rs.next()) {
				num = rs.getInt("num");
			}
			return num;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}
	}
	@Override
	public Cart findCart(int cart_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		Cart c=new Cart();
		List<Cart> cartlist=new ArrayList<Cart>();
		try {
			String sql = "select * from cart where cart_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, cart_id);
			rs = pres.executeQuery();
			cartlist = ResultToBean.getBeanList(Cart.class, rs); //调工具类 （封装 数据到 bean的工具类）
			c=cartlist.get(0);
			return c;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(con, pres, rs);
		}
	}
}
