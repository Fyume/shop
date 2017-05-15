package cn.edu.zhku.jsj.dao;

import java.util.List;

import cn.edu.zhku.jsj.daomain.Cloth;

public interface ClothDao {

	int add(Cloth cloth);

	Cloth find(String cloth_name);

	List<Cloth> findAll();

	boolean update(Cloth cloth);

	boolean delete(Cloth cloth);

}