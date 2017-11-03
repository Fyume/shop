package cn.edu.zhku.jsj.dao;

import java.util.List;

import cn.edu.zhku.jsj.domain.Food;
import cn.edu.zhku.jsj.domain.Store;

public interface FoodDao {

	int add(Food food);

	List<Food> find(String food_name);

	List<Food> findAll();

	List<Food> findFood(int store_id);
	
	boolean update(Food food);

	boolean delete(int food_id);
	
	Food findfood(int food_id);
	
	List<Food> search_food(int store_id, String goodname);
	
	Store findfood_store(int food_id);
}