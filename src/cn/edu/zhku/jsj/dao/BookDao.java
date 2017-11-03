package cn.edu.zhku.jsj.dao;

import java.util.List;

import cn.edu.zhku.jsj.domain.Book;
import cn.edu.zhku.jsj.domain.Store;

public interface BookDao {

	//添加图书
	int add(Book book);


	List<Book> findBook(String book_name);
	
	Book findbook(int book_id);

	List<Book> findAll();

	boolean update(Book book);

	boolean delete(int book_id);
	
	List<Book> findBook(int store_id);
	
	List<Book> search_book(int store_id, String goodname);
	
	Store findbook_store(int book_id);
}