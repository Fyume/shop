package junit.test;

import java.util.List;

import org.junit.Test;

import cn.edu.zhku.jsj.dao.impl.ClothDaoImpl;
import cn.edu.zhku.jsj.domain.Cloth;

public class ClothDaoTest {
	ClothDaoImpl clothdao = new ClothDaoImpl();
	@Test
	public void addTest(){
		Cloth cloth = new Cloth();
		cloth.setClothname("男士卫衣");
		cloth.setColor("蓝色");
		cloth.setDescription("帅气版");
		cloth.setImages("d://2.jpg");
		cloth.setPrice(50);
		cloth.setSize("S;M;L;XL;XXL");
		cloth.setStore_id(1);
		cloth.setTotalnum(59);
		cloth.setVersion("潮流款;小清新;均码");
		clothdao.add(cloth);
	}
	
	@Test
	public void findClothTest(){
		Cloth cloth = (Cloth) clothdao.find("秋衣款");
	}
	@Test
	public void findname(){
		List<Cloth> lc=clothdao.findAll();
		for(Cloth cl:lc){
			System.out.println(cl.getClothname());
		}
	}
	@Test
	public void findallTest(){
		List<Cloth> list = clothdao.findAll();
		for(Cloth cloth:list){
			System.out.println(cloth.getDescription());
		}
	}
	
	@Test
	public void updateTest(){
		Cloth cloth = new Cloth();
		cloth.setCloth_id(2);
		cloth.setVersion("卫衣;上衣");
		cloth.setPrice(38);
		cloth.setDescription("更帅气");
		cloth.setTotalnum(35);
		clothdao.update(cloth);
	}
	@Test
	public void deleteTest(){
		int cloth_id = 2;
		clothdao.delete(cloth_id);
	}
	
}
