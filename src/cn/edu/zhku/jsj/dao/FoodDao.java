package cn.edu.zhku.jsj.dao;

import java.util.List;

import cn.edu.zhku.jsj.daomain.Food;

public interface FoodDao {

	int add(Food food);

	Food find(String food_name);

	List<Food> find();

	boolean update(Food food);

	boolean delete(Food food);

}