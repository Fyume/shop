package cn.edu.zhku.jsj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.dao.StoreDao;
import cn.edu.zhku.jsj.domain.Book;
import cn.edu.zhku.jsj.domain.Cloth;
import cn.edu.zhku.jsj.domain.Food;
import cn.edu.zhku.jsj.domain.Store;
import cn.edu.zhku.jsj.domain.User;
import cn.edu.zhku.jsj.web.utils.JdbcUtil;
import cn.edu.zhku.jsj.web.utils.ResultToBean;

public class StoreDaoImpl implements StoreDao {
	//添加店铺 开店
	@Override
	public int add(Store store){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql = "insert into store values(null,?,?,?,?,?)";
			pres = con.prepareStatement(sql);
			pres.setString(1, store.getStorename());
			pres.setString(2, store.getOwner_id());
			pres.setString(3, store.getDescription());
			pres.setInt(4, store.getControl());
			pres.setString(5, store.getImages());

			int num = pres.executeUpdate();
			return num;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	
	//店铺中 查找商品
	@Override
	public List findProduce(int store_id,String produce_name){
		return null;//三张表查找  存在 map集合里 
	}
	
	//对三种商品信息更新  重载
	@Override
	public boolean updateInfo(Book book){
		return false;
	}
	
	@Override
	public boolean updateInfo(Food food){
		return false;
	}
	@Override
	public boolean updateInfo(Cloth cloth){
		return false;
	}
	
	//下架商品  三种商品
	@Override
	public boolean delete(Book book){
		return false;  
	}           
	            
	@Override
	public boolean delete(Food food){
		return false;  
	}           
	@Override
	public boolean delete(Cloth cloth){
		return false;
	}	
	@Override
	public List<Store> find(String storename){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		List<Store> storelist;
		try{
			String sql = "select * from store where storename like ? or description like ?";
			pres = con.prepareStatement(sql);
			pres.setString(1, "%"+storename+"%");
			pres.setString(2, "%"+storename+"%");
			rs = pres.executeQuery();
			storelist = ResultToBean.getBeanList(Store.class, rs); //调工具类 （封装 数据到 bean的工具类）
			return storelist;
		}catch(Exception e){ 
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	@Override
	public User findowner(String owner_id){
	Connection con = null;
	PreparedStatement pres = null;
	ResultSet rs = null;
	con = JdbcUtil.getCon();
	List<User> userlist;
	User u = new User(); 
	try{
		String sql = "select * from user where user_id=?";
		pres = con.prepareStatement(sql);
		pres.setString(1,owner_id);
		rs = pres.executeQuery();
		userlist = ResultToBean.getBeanList(User.class, rs); //调工具类 （封装 数据到 bean的工具类）
		if(userlist.isEmpty()){
			System.out.print("userlist空");
		}else{
		u = userlist.get(0);
		}
		return u;
	}catch(Exception e){ 
		throw new RuntimeException(e);
	}finally{
		JdbcUtil.release(con, pres, rs);
	}
}

	@Override
	public Store findstoreinfo(int store_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		List<Store> storelist;
		try{
			String sql = "select * from store where store_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, store_id);
			rs = pres.executeQuery();
			storelist = ResultToBean.getBeanList(Store.class, rs); //调工具类 （封装 数据到 bean的工具类）
			return storelist.get(0);
		}catch(Exception e){ 
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	@Override
	public Store findstore(int store_id){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		List<Store> storelist;
		Store s = new Store(); 
		try{
			String sql = "select * from store where store_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1,store_id);
			rs = pres.executeQuery();
			storelist = ResultToBean.getBeanList(Store.class, rs); //调工具类 （封装 数据到 bean的工具类）
			if(storelist.isEmpty()){
				System.out.print("userlist空");
			}else{
			s = storelist.get(0);
			}
			return s;
	}catch(Exception e){ 
		throw new RuntimeException(e);
	}finally{
		JdbcUtil.release(con, pres, rs);
	}
	}

	@Override
	public boolean updatestore(Store store) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		boolean b = false;
		try{
			String sql = "update store set description=?,storename=? where store_id=?";
			pres = con.prepareStatement(sql);
			pres.setString(1, store.getDescription());
			pres.setString(2, store.getStorename());
			pres.setInt(3, store.getStore_id());
			int num = pres.executeUpdate();
			if(num!=0)
				b = true;
			return b;
		}catch(Exception e){ 
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}

}
