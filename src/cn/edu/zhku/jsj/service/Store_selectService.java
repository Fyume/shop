package cn.edu.zhku.jsj.service;

import cn.edu.zhku.jsj.dao.StoreDao;
import cn.edu.zhku.jsj.dao.impl.StoreDaoImpl;
import cn.edu.zhku.jsj.domain.Store;

public class Store_selectService {
	private StoreDao sd = new StoreDaoImpl();
	private Store s=new Store();
	public Store findstore(int store_id){
		s=sd.findstore(store_id);
		return s;
	}
}
