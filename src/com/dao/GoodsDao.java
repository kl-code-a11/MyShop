package com.dao;
	

import java.util.List;
import bean.Goods;
	
	
public interface GoodsDao {

		List<Goods> findByTid(int tid);
		
		boolean updateGoods(Goods goods);
		
		Goods findById(int gid);
	}


