package cn.edu.zhku.jsj.service;

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
import cn.edu.zhku.jsj.domain.User;

public class Good_selectService {
	private BookDao bd = new BookDaoImpl();
	private FoodDao fd = new FoodDaoImpl();
	private ClothDao cd = new ClothDaoImpl();
	private StoreDao sd = new StoreDaoImpl();
	//找商品
	public Book findbook(int book_id){
		Book b=bd.findbook(book_id);
		return b;
	}
	public Food findfood(int food_id){
		Food f=fd.findfood(food_id);
		return f;
	}
	public Cloth findcloth(int cloth_id){
		Cloth c=cd.findcloth(cloth_id);
		return c;
	}
	//找商品所在的店铺
	public Store findbook_store(int book_id){
		Store s=bd.findbook_store(book_id);
		return s;
	}
	public Store findfood_store(int food_id){
		Store s=fd.findfood_store(food_id);
		return s;
	}
	public Store findcloth_store(int cloth_id){
		Store s=cd.findcloth_store(cloth_id);
		return s;
	}
	public User findowner(String owner_id){
		User u = sd.findowner(owner_id);
		return u;
	}
}
