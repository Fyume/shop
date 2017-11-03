package junit.test;

import java.util.List;

import org.junit.Test;

import cn.edu.zhku.jsj.dao.impl.FoodDaoImpl;
import cn.edu.zhku.jsj.domain.Food;

public class FoodDaoTest {
	FoodDaoImpl fooddao = new FoodDaoImpl();
/*	@Test
	public void addfoodtest(){
		Food food = new Food();
		food.setFoodname("五只松鼠");
		food.setPrice(15);
		food.setTotalnum(200);
		food.setImages("d://8.jpg");
		food.setDescription("好好好吃啊");
		food.setStore_id(1);
		fooddao.add(food);
	}
	@Test
	public void findTest(){

		Food food = fooddao.find("饼干");
		System.out.println(food.getDescription());
	}
	
	@Test
	public void findAll(){

		System.out.println(fooddao.findAll().get(0).getFoodname());

	}
	
	@Test
	public void updateTest(){
		Food food = new Food();
		food.setFood_id(2);
		food.setTotalnum(250);
		food.setPrice(20);
		food.setDescription("真的好吃啊，快来啊");
		fooddao.update(food);
	}
	
	@Test
	public void deleteTest(){
		fooddao.delete(2);
	}*/
	@Test
	public void findtest(){
		List<Food> lf= fooddao.findAll();
		for(Food f:lf){
			System.out.println(f.getFoodname());
		}
	}
	@Test
	public void test(){
		String s="";
		System.out.println(s.toString());
	}
	@Test
	public void find(){
		List<Food> lf=fooddao.find("鸡");
		for(Food f:lf){
		System.out.println(f.getFoodname());
		}
	}
}
