package com.dao;

import java.util.List;

import bean.Car;

public interface CarDao {

	boolean save(Car car);
	List<Car> findAll(int uid);
	boolean updateCar(int carnum,int carid);
	boolean deleteCar(int uid);
}
