package com.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import com.dao.GoodsTypeDao;
import com.util.DBUtil;

import bean.Goods;
import bean.GoodsType;

public class GoodsTypeDaoImpl extends DBUtil<GoodsType> implements GoodsTypeDao {



	@Override
	public GoodsType getEntity(ResultSet rs) throws Exception {
		GoodsType gt=new GoodsType();
		gt.setTid(rs.getInt(1));
		gt.setTname(rs.getString(2));
		return gt;
	}

	@Override
	public GoodsType findById(int tid) {
	List<GoodsType> list=Query("select * from goodsType where tid=?",tid);
	if(list.size()>0) {
		return list.get(0);
	}
		return null;
	}

	@Override
	public List<GoodsType> findAll() {
		// TODO 自动生成的方法存根
		return Query("select * from goodstype");
	}



}
