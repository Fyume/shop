package cn.edu.zhku.jsj.dao;


import cn.edu.zhku.jsj.domain.Store;
import cn.edu.zhku.jsj.domain.User;

public interface UserDao {

	// 用户注册
	int add(User user);

	// 注册时查找 是否已经存在
	User find(String user_id);

	// 用户登录时的查找
	User find(String user_id, String password);

	// 忘记登录密码查询时
	User find(String user_id, String phonenum, String email);

	// 忘记密码时，修改密码
	int change(String user_id, String password);

	// 用户开店时，添加用户的身份证信息，保存用户的身份信息
	int update_user(String user_id, String cardID, int role);

	// 用户修改个人资料
	int changeInformation(User user);

	// 用户登录后查看我的店铺
	Store myStore(String owner_id);
}