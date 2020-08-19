package com.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.CarDao;
import com.dao.GoodsDao;
import com.dao.UserDao;
import com.util.DBUtil;

import bean.Car;


public class CarDaoImpl extends DBUtil<Car> implements CarDao {

	UserDao ud=new UerDaoImpl();
	GoodsDao gd=new GoodsDaoImpl();
	@Override
	public boolean save(Car car) {
		// TODO 自动生成的方法存根
		List<Object> list=new ArrayList<>();
		list.add(car.getUser().getId());
		list.add(car.getGoods().getGid());
		list.add(car.getCarnum());
		list.add(car.getTotal());
	    return update("insert into car values(null,?,?,?,?)",list);
	}

	@Override
	public List<Car> findAll(int uid) {
		// TODO 自动生成的方法存根
		return 	Query("select * from car where uid=?",uid);
		
	}

	@Override
	public boolean updateCar(int carnum, int carid) {
		// TODO 自动生成的方法存根
		List<Object> list=new ArrayList<>();

		list.add(carnum);
		list.add(carid);
		return update("update car set carnum=? where carid=?",list);
	}

	@Override
	public Car getEntity(ResultSet rs) throws Exception {
		// TODO 自动生成的方法存根
		Car car=new Car();
		car.setCarid(rs.getInt(1));
		car.setUser(ud.findById(rs.getInt(2)));
		car.setGoods(gd.findById(rs.getInt(3)));
		car.setCarnum(rs.getInt(4));
		car.setTotal(rs.getDouble(5));
		return car;
	}

	@Override
	public boolean deleteCar(int uid) {
		List<Object> list=new ArrayList<>();
		list.add(uid);
		return update("delete from car where uid=?",list);
	}

}
