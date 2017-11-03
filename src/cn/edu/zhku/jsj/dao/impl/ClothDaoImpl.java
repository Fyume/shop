package cn.edu.zhku.jsj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import javax.management.RuntimeErrorException;

import cn.edu.zhku.jsj.dao.ClothDao;
import cn.edu.zhku.jsj.domain.Cloth;
import cn.edu.zhku.jsj.domain.Store;
import cn.edu.zhku.jsj.web.utils.JdbcUtil;
import cn.edu.zhku.jsj.web.utils.ResultToBean;

public class ClothDaoImpl implements ClothDao {
	@Override
	public int add(Cloth cloth){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql = "insert into cloth values(null,?,?,?,?,?,?,?,?,?)";
			pres = con.prepareStatement(sql);
			
			pres.setString(1, cloth.getClothname());
			pres.setString(2, cloth.getVersion());
			pres.setFloat(3, cloth.getPrice());
			pres.setInt(4,cloth.getTotalnum());
			pres.setString(5, cloth.getSize());
			pres.setString(6, cloth.getColor());
			pres.setString(7, cloth.getImages());
			pres.setString(8, cloth.getDescription());
			pres.setInt(9, cloth.getStore_id());
			
			int num = pres.executeUpdate();
			return num;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	
	@Override
	public List<Cloth> find(String cloth_name){

		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		List<Cloth> clothlist;
		try{
			String sql = "select * from cloth where clothname like ? or description like ?";
			pres = con.prepareStatement(sql);
			pres.setString(1, "%"+cloth_name+"%");
			pres.setString(2, "%"+cloth_name+"%");
			rs = pres.executeQuery();
			clothlist = ResultToBean.getBeanList(Cloth.class, rs); //调工具类 （封装 数据到 bean的工具类）
			return clothlist;
		}catch(Exception e){ 
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	
	@Override
	public List<Cloth> findAll(){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		List<Cloth> clothlist;
		try{
			String sql = "select * from cloth";
			pres = con.prepareStatement(sql);
			rs = pres.executeQuery();
			clothlist = ResultToBean.getBeanList(Cloth.class, rs); //调工具类 （封装 数据到 bean的工具类）
			if(clothlist.isEmpty()){
				System.out.println("clothlist为空！！");
			}
			return clothlist;
		}catch(Exception e){ 
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	
	@Override
	public boolean update(Cloth cloth){
		boolean b = false;
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql = "update cloth set clothname=?,version=?,price=?,totalnum=?,description=?,size=?,color=? where cloth_id=?";
			pres = con.prepareStatement(sql);
			pres.setString(1, cloth.getClothname());
			pres.setString(2, cloth.getVersion());
			pres.setFloat(3, cloth.getPrice());
			pres.setInt(4, cloth.getTotalnum());
			pres.setString(5, cloth.getDescription());
			pres.setString(6, cloth.getSize());
			pres.setString(7, cloth.getColor());
			pres.setInt(8, cloth.getCloth_id());
			
			int num = pres.executeUpdate();
			if(num!=0){
				b = true;
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
		return b;
	}
	
	@Override
	public boolean delete(int cloth_id){
		boolean b = false;
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql = "delete from cloth where cloth_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, cloth_id);
			int num = pres.executeUpdate();
			if(num!=0){
				b = true;
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
		return b;
	}

	@Override
	public List<Cloth> findCloth(int store_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		Cloth cloth = null;
		List<Cloth> clothlist;
		try{
			String sql = "select * from cloth where store_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, store_id);
			rs = pres.executeQuery();
			
			clothlist = ResultToBean.getBeanList(Cloth.class, rs); //调工具类 （封装 数据到 bean的工具类）
			
			return clothlist;
		}catch(Exception e){ 
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}

	@Override
	public Cloth findcloth(int cloth_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		Cloth cloth = null;
		List<Cloth> clothlist;
		try{
			String sql = "select * from cloth where cloth_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, cloth_id);
			rs = pres.executeQuery();
			
			clothlist = ResultToBean.getBeanList(Cloth.class, rs); //调工具类 （封装 数据到 bean的工具类）
			cloth = clothlist.get(0);
			return cloth;
		}catch(Exception e){ 
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}

	@Override
	public List<Cloth> search_cloth(int store_id, String goodname) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		List<Cloth> clothlist;
		try{
			String sql = "";
			if(store_id!=0){
				sql = "select * from cloth where store_id=? and clothname like ?";
				pres = con.prepareStatement(sql);
				pres.setInt(1, store_id);
				pres.setString(2, "%"+goodname+"%");
			}else{
				sql = "select * from cloth where clothname like ?";
				pres = con.prepareStatement(sql);
				pres.setString(1, "%"+goodname+"%");
			}
			rs = pres.executeQuery();
			clothlist = ResultToBean.getBeanList(Cloth.class, rs); //调工具类 （封装 数据到 bean的工具类）
			return clothlist;
		}catch(Exception e){ 
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	@Override
	public Store findcloth_store(int cloth_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		List<Store> storelist = new LinkedList<Store>();
		Store s=new Store();
		try{
			String sql = "select * from store where store_id=(select store_id from cloth where cloth_id=?)";
			pres = con.prepareStatement(sql);	
			pres.setInt(1, cloth_id);
			rs = pres.executeQuery();
			storelist = ResultToBean.getBeanList(Store.class, rs); //调工具类 （封装 数据到 bean的工具类）
			if(storelist.isEmpty()){
				System.out.println("storelist为空！！");
			}else{
			s=storelist.get(0);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
		return s;
	}
}	
