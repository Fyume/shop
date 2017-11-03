package cn.edu.zhku.jsj.dao;

import java.util.List;

import cn.edu.zhku.jsj.domain.Book;
import cn.edu.zhku.jsj.domain.Cloth;
import cn.edu.zhku.jsj.domain.Food;
import cn.edu.zhku.jsj.domain.Store;
import cn.edu.zhku.jsj.domain.User;

public interface StoreDao {

	//添加店铺 开店
	int add(Store store);

	//店铺中 查找商品
	List findProduce(int store_id, String produce_name);

	//对三种商品信息更新  重载
	boolean updateInfo(Book book);

	boolean updateInfo(Food food);

	boolean updateInfo(Cloth cloth);

	//下架商品  三种商品
	boolean delete(Book book);

	boolean delete(Food food);

	boolean delete(Cloth cloth);
	//查找店铺名为storename的店铺
	List<Store> find(String storename);
	//找到店铺所有者的信息
	User findowner(String owner_id);
	
	Store findstore(int store_id);
	
	Store findstoreinfo(int store_id);
	
	boolean updatestore(Store store);
	

}