package cn.edu.zhku.jsj.web.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSetMetaData;

public class ResultToBean {
	public static <T> List<T> getBeanList(Class<T> clazz, ResultSet rs)  {

		Field field = null;
		List<T> lists = new ArrayList<T>();
		// 取得类里边的所有方法
		try {
			// 取得ResultSet列名
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			// 获取记录集中的列数
			int counts = rsmd.getColumnCount();
			// 定义counts个String 变量
			String[] columnNames = new String[counts];
			// 给每个变量赋值 记录每个 字段的名字
			for (int i = 0; i < counts; i++) {
				//rsmd.getColumnLabel(i + 1); 给数据库 列名取个 别名
				/*getColumnName返回的是sql语句中field的原始名字。getColumnLabel是field的SQL AS的值。
				比如：select a.name as name,a.description as description,b.description as relatedDescription from a,b where ...
				此时,getColumnName(3) == "description";而getColumnLabel(3) == "relatedDescription"。
				如果你想将ResultSet的结果映射到HashMap中，注意一定使用getColumnLabel，而不要用getColumnName。*/
				columnNames[i] = rsmd.getColumnLabel(i + 1);  // rsmd.getColumnLabel(i) 就是输出 响应的的列名
				//所以columnNaes 存放的就是 所有的列的名字
			}

			// 变量ResultSet
			while (rs.next()) {
				T t = clazz.newInstance();
				// 反射, 从ResultSet绑定到JavaBean
				for (int i = 0; i < counts; i++) {
					// 根据 rs 列名 ，组装javaBean里边的其中一个set方法，object 就是数据库第一行第一列的数据了
					String sss=rs.getString(columnNames[i]);
/*					System.out.println(i+":"+sss);*/
					if(null==sss){
						/*System.out.println(sss+"为空 跳过");*/
						continue;
					}
					Object value = rs.getObject(columnNames[i]);
/*					System.out.print(columnNames[i]);
					System.out.println(":\nvalue:"+value.getClass());*/
					//这里是获取数据库字段的类型
					Class<?> dbType = value.getClass();
					//设置参数类型，此类型应该跟javaBean 里边的类型一样，而不是取数据库里边的类型
					field = clazz.getDeclaredField(columnNames[i]);
/*					System.out.println("field:"+field.getType());*/
					Class<?> beanType = field.getType();
					//如果发生从数据库获取到得类型跟javaBean类型不同，先按String类型取  然后在转换为 具体的类型
					if(beanType!=dbType){
						/*System.out.println("beantype!=dbtype");*/
						value = rs.getString(columnNames[i]);
						if(dbType.getSimpleName().equals("Integer")){
							value = Integer.parseInt((String)value);
						}else if(dbType.getSimpleName().equals("Float")){
							value = Float.parseFloat((String) value);
						}else if(dbType.getSimpleName().equals("String")){
							//如果是String 类型的话那么就 不做什么
						}else{
							value = Timestamp.valueOf((String)value).getTime();
						}
				 	}
					String setMethodName = "set" + firstUpperCase(columnNames[i]);
					// 第一个参数是传进去的方法名称，第二个参数是 传进去的类型；
					Method m = t.getClass().getMethod(setMethodName,beanType);
					// 第二个参数是传给set方法数据；如果是get方法可以不写
					m.invoke(t, value);
					}
				lists.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}
	
	//首写字母变大写
	  public static String firstUpperCase(String old){
 		  return old.substring(0, 1).toUpperCase()+old.substring(1);
	  }  
}
