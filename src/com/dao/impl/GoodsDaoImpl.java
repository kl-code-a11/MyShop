package com.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.GoodsDao;
import com.dao.GoodsTypeDao;
import com.util.DBUtil;

import bean.Goods;

public class GoodsDaoImpl extends DBUtil<Goods> implements GoodsDao {
	
	GoodsTypeDao gtd=new GoodsTypeDaoImpl();
	
	@Override
	public List<Goods> findByTid(int tid) {
		// TODO 自动生成的方法存根
		return Query("select * from goods where tid=?",tid);
	}

	@Override
	public boolean updateGoods(Goods goods) {
		// TODO 自动生成的方法存根
		List<Object> obj=new ArrayList<>();
		obj.add(goods.getNum());
		obj.add(goods.getGid());
		return update("update goods set num=? where gid=?",obj);
	}

	@Override
	public Goods findById(int gid) {
		// TODO 自动生成的方法存根
		List<Goods> list=Query("select * from goods where gid=?",gid);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Goods getEntity(ResultSet rs) throws Exception {
		Goods goods=new Goods();
		goods.setGid(rs.getInt(1));
		goods.setName(rs.getString(2));
		goods.setGtype(gtd.findById(rs.getInt(3)));
		goods.setPrice(rs.getDouble(4));
		goods.setNum(rs.getInt(5));
		goods.setAddress(rs.getString(6));
		return goods;
	}

}
