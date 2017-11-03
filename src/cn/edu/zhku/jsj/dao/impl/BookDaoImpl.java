package cn.edu.zhku.jsj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.edu.zhku.jsj.dao.BookDao;
import cn.edu.zhku.jsj.domain.Book;
import cn.edu.zhku.jsj.domain.Cloth;
import cn.edu.zhku.jsj.domain.Food;
import cn.edu.zhku.jsj.domain.Store;
import cn.edu.zhku.jsj.web.utils.JdbcUtil;
import cn.edu.zhku.jsj.web.utils.ResultToBean;

public class BookDaoImpl implements BookDao {
	
	//添加图书
	@Override
	public int add(Book book){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql = "insert into book values(null,?,?,?,?,?,?,?,?,?,?)";
			pres = con.prepareStatement(sql);
			
			pres.setString(1, book.getBookname());
			pres.setString(2, book.getAuthor());
			pres.setString(3, book.getPress());
			pres.setInt(4,book.getTotalnum());
			pres.setFloat(5, book.getPrice());
			pres.setString(6, book.getVersion());
			pres.setString(7, book.getImages());
			pres.setString(8, book.getISBN());
			pres.setString(9, book.getDescription());
			pres.setInt(10, book.getStore_id());
			
			int num = pres.executeUpdate();
			return num;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	
	@Override
	public List<Book> findBook(String book_name){


		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		List <Book> list= new ArrayList();
		Book book=null;
		try{
			String sql = "select * from book where bookname like ? or description like ?";
			pres = con.prepareStatement(sql);
			pres.setString(1, "%"+book_name+"%");
			pres.setString(2, "%"+book_name+"%");
			rs = pres.executeQuery();
			if(rs.next()){
				book = new Book();
				book.setAuthor(rs.getString("author"));
				book.setImages(rs.getString("B_images"));
				book.setBook_id(rs.getInt("book_id"));
				book.setBookname(rs.getString("bookname"));
				book.setDescription(rs.getString("B_description"));
				book.setISBN(rs.getString("ISBN"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getFloat("B_price"));
				book.setTotalnum(rs.getInt("totalnum"));
				book.setStore_id(rs.getInt("B_store_id"));
				book.setVersion(rs.getString("B_version"));
				list.add(book);
				
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
		return list;
		
	}
	@Override
	public List<Book> findAll(){
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		List<Book> booklist;
		try{
			String sql = "select * from book";
			pres = con.prepareStatement(sql);
			rs = pres.executeQuery();
			booklist = ResultToBean.getBeanList(Book.class, rs); //调工具类 （封装 数据到 bean的工具类）
			if(booklist.isEmpty()){
				System.out.println("booklist为空！！");
			}
			return booklist;
		}catch(Exception e){ 
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
	}
	
	@Override
	public boolean update(Book book){ 
		boolean b = false;
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql = "update book set bookname=?,totalnum=?,price=?,version=?,description=?,press=?,author=? where book_id=?";
			pres = con.prepareStatement(sql);
			pres.setString(1, book.getBookname());
			pres.setInt(2, book.getTotalnum());
			pres.setFloat(3, book.getPrice());
			pres.setString(4, book.getVersion());
			pres.setString(5, book.getDescription());
			pres.setString(6, book.getPress());
			pres.setString(7, book.getAuthor());
			pres.setInt(8, book.getBook_id());
			int num =  pres.executeUpdate(); 
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
	public boolean delete(int book_id){
		boolean b = false;
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try{
			String sql = "delete from book where book_id=?";
			pres = con.prepareStatement(sql);
			pres.setInt(1, book_id);
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
	public List<Book> findBook(int store_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		List<Book> booklist = new LinkedList<Book>();
		try{
			String sql = "select * from book where store_id=?";
			pres = con.prepareStatement(sql);	
			pres.setInt(1, store_id);
			rs = pres.executeQuery();
			booklist = ResultToBean.getBeanList(Book.class, rs); //调工具类 （封装 数据到 bean的工具类）
 			
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
		return booklist;
	}

	@Override
	public Book findbook(int book_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		List<Book> booklist = new LinkedList<Book>();
		Book book = null;
		try{
			String sql = "select * from book where book_id=?";
			pres = con.prepareStatement(sql);	
			pres.setInt(1, book_id);
			rs = pres.executeQuery();
			booklist = ResultToBean.getBeanList(Book.class, rs); //调工具类 （封装 数据到 bean的工具类）
			book = booklist.get(0);
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
		return book;
	}

	@Override
	public List<Book> search_book(int store_id, String goodname) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		List<Book> booklist = null;
		try{
			String sql = "";
			if(store_id!=0){ 
				sql = "select * from book where store_id=? and bookname like ?";
				pres = con.prepareStatement(sql);
				pres.setInt(1, store_id);
				pres.setString(2, "%"+goodname+"%");
			}else{
				sql = "select * from book where bookname like ?";
				pres = con.prepareStatement(sql);
				pres.setString(1, "%"+goodname+"%");
			}
			rs = pres.executeQuery();
			booklist = ResultToBean.getBeanList(Book.class, rs); //调工具类 （封装 数据到 bean的工具类）
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(con, pres, rs);
		}
		return booklist;
	}
	@Override
	public Store findbook_store(int book_id) {
		Connection con = null;
		PreparedStatement pres = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		List<Store> storelist = new LinkedList<Store>();
		Store s=new Store();
		try{
			String sql = "select * from store where store_id=(select store_id from book where book_id=?)";
			pres = con.prepareStatement(sql);	
			pres.setInt(1, book_id);
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
