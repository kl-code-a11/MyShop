package com.dao;

import java.util.List;

import bean.Goods;
import bean.GoodsType;

public interface GoodsTypeDao {
    GoodsType findById(int tid);
    
    
    List<GoodsType> findAll();
}
