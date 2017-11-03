package cn.edu.zhku.jsj.dao;

import java.util.List;

import cn.edu.zhku.jsj.domain.Operator;
import cn.edu.zhku.jsj.domain.Store;

public interface OperatorDao {

	//管理员的注册
	int add(Operator operator);

	//运营人员登录
	Operator find(String name, String password);
	
	// 管理员登录后添加登录时间
	 int Time(Operator operator);

	//管理员登录后，获取店铺的信息
	List Information();
	
	//店铺管理
	int control(int control,String storename);
	
	//根据店铺名查找店铺
	Store operator_FindStore(String storename);
}