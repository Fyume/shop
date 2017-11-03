package cn.edu.zhku.jsj.service;

import java.util.List;

import cn.edu.zhku.jsj.dao.BookDao;
import cn.edu.zhku.jsj.dao.ClothDao;
import cn.edu.zhku.jsj.dao.FoodDao;
import cn.edu.zhku.jsj.dao.impl.BookDaoImpl;
import cn.edu.zhku.jsj.dao.impl.ClothDaoImpl;
import cn.edu.zhku.jsj.dao.impl.FoodDaoImpl;
import cn.edu.zhku.jsj.domain.Book;
import cn.edu.zhku.jsj.domain.Cloth;
import cn.edu.zhku.jsj.domain.Food;

public class Client_PartialSelectService {
	private BookDao bd=new BookDaoImpl(); 
	private FoodDao fd=new FoodDaoImpl();
	private ClothDao cd=new ClothDaoImpl();
	public List<Book> select_b(){
		List<Book> list=bd.findAll();
		return list;
	}
	public List<Food> select_f(){
		List<Food> list=fd.findAll();
		return list;
	}
	public List<Cloth> select_c(){
		List<Cloth> list=cd.findAll();
		return list;
	}
}
