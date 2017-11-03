package cn.edu.zhku.jsj.service;

import java.util.List;

import cn.edu.zhku.jsj.dao.BookDao;
import cn.edu.zhku.jsj.dao.ClothDao;
import cn.edu.zhku.jsj.dao.FoodDao;
import cn.edu.zhku.jsj.dao.StoreDao;
import cn.edu.zhku.jsj.dao.impl.BookDaoImpl;
import cn.edu.zhku.jsj.dao.impl.ClothDaoImpl;
import cn.edu.zhku.jsj.dao.impl.FoodDaoImpl;
import cn.edu.zhku.jsj.dao.impl.StoreDaoImpl;
import cn.edu.zhku.jsj.domain.Book;
import cn.edu.zhku.jsj.domain.Cloth;
import cn.edu.zhku.jsj.domain.Food;
import cn.edu.zhku.jsj.domain.Store;

public class Client_FuzzySelectService {
	private BookDao bd = new BookDaoImpl();
	private FoodDao fd = new FoodDaoImpl();
	private ClothDao cd = new ClothDaoImpl();
	private StoreDao sd = new StoreDaoImpl();

	public List<Book> select_b(String str) {
		List<Book> list = bd.findBook(str);
		return list;
	}
	
	public List<Food> select_f(String str) {
		List<Food> list = fd.find(str);
		return list;
	}

	public List<Cloth> select_c(String str) {
		List<Cloth> list = cd.find(str);
		return list;
	}

	public List<Store> select_s(String str) {
		List<Store> list = sd.find(str);
		return list;
	}
}
