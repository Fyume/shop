package cn.edu.zhku.jsj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.dao.OrderDao;
import cn.edu.zhku.jsj.domain.Order;
import cn.edu.zhku.jsj.web.utils.JdbcUtil;
import cn.edu.zhku.jsj.web.utils.ResultToBean;

public class OrderDaoImpl implements OrderDao {
	@Override
	public int add(Order order){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		/*List<Order> listorder = new LinkedList<Order>();*/
		/*Order order = null;*/
		try{
			con = JdbcUtil.getCon();
			String sql = "insert into orders values(null,?,?,?,?,?,?,?)";
			pres = con.prepareStatement(sql);
			pres.setInt(1, order.getGood_id());
			pres.setString(2, order.getUser_id());
			pres.setInt(3, order.getStore_id());
			pres.setInt(4, order.getQuantity());
			
			Timestamp time = new Timestamp(order.getOrdertime());
			pres.setTimestamp(5, time);
			
			pres.setInt(6, order.getState());
			pres.setFloat(7, order.getPrice());
			
			int num = pres.executeUpdate();
			return num;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	@Override
	public List<Map> findAll(){
		//查找 order 表  将 订单项（可能是书 食物或者衣服）
		//将信息存在 map集合 里（关键字是 order表的字段名 value是字段名对应值）然后再将map存在 list中,最后返回list集合
		return null;
	}
	@Override
	public boolean delete(int order_id){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		try{
			con = JdbcUtil.getCon();
			String sql = "delete from orders where order_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, order_id);
			int num = pres.executeUpdate();
			if(num!=0)
				return true;
			else
				return false;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	@Override
	public List<Order> getstore_Orders(int store_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		List<Order> listorder = new LinkedList<Order>();
		/*Order order = null;*/
		try{
			con = JdbcUtil.getCon();
			String sql = "select * from orders where store_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, store_id);
			rs = pres.executeQuery();
			listorder = ResultToBean.getBeanList(Order.class, rs);
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
		return listorder;
	}
	@Override
	public List<Order> getstore_BFOrders(int store_id, int states) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		List<Order> listorder = new LinkedList<Order>();
		/*Order order = null;*/
		try{
			con = JdbcUtil.getCon();
			String sql = "select * from orders where store_id=? and state=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, store_id);
			pres.setInt(2, states);
			rs = pres.executeQuery();
			listorder = ResultToBean.getBeanList(Order.class, rs);
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
		return listorder;
	}
	@Override
	public boolean updateState(int order_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		try{
			con = JdbcUtil.getCon();
			String sql = "update Orders set state=? where order_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, 2);
			pres.setInt(2, order_id);
			int num = pres.executeUpdate();
			if(num!=0)
				return true;
			else
				return false;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	@Override
	public List<Order> findOrder(String user_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		List<Order> listorder = new LinkedList<Order>();
		Order order = new Order();
		try{
			con = JdbcUtil.getCon();
			String sql = "select * from orders where user_id=?";
			pres = con.prepareStatement(sql);
			pres.setString(1, user_id);
			rs = pres.executeQuery();
			listorder = ResultToBean.getBeanList(Order.class, rs);
			return listorder;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	@Override

	public List<Order> findOrder(String user_id,int state) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		List<Order> listorder = new LinkedList<Order>();
		Order order = new Order();
		try{
			con = JdbcUtil.getCon();
			String sql = "select * from orders where user_id=? and state=?";
			pres = con.prepareStatement(sql);
			pres.setString(1, user_id);
			pres.setInt(2, state);
			rs = pres.executeQuery();
			listorder = ResultToBean.getBeanList(Order.class, rs);
			return listorder;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}

	public boolean updateState2(int order_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		try{
			con = JdbcUtil.getCon();
			String sql = "update Orders set state=? where order_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, 3);
			pres.setInt(2, order_id);
			int num = pres.executeUpdate();
			if(num!=0)
				return true;
			else
				return false;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	@Override
	public Order getstore_Orders2(int order_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		Order order = null;
		List<Order> listorder = new LinkedList<Order>();
		try{
			con = JdbcUtil.getCon();
			String sql = "select * from Orders where order_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, order_id);
			rs = pres.executeQuery();
			listorder = ResultToBean.getBeanList(Order.class, rs);
			order = listorder.get(0);
			return order;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	@Override
	public boolean deleteorder(int order_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		try{
			con = JdbcUtil.getCon();
			String sql = "delete from Orders where order_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, order_id);
			int num = pres.executeUpdate();
			if(num!=0)
				return true;
			else
				return false;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	
	
}
