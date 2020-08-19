package com.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.UserDao;
import com.util.DBUtil;

import bean.User;

public class UerDaoImpl extends DBUtil<User> implements UserDao {

	@Override
	public User login(String account, String password) {
		List<User> list=Query("select * from user where name=? and password=?",account,password);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public boolean register(User user) {
		String sql="insert into user values(null,?,?,?)";
		List<Object> list=new ArrayList<>();
		list.add(user.getName());
		list.add(user.getPassword());
		list.add(user.getMoney());
		return update(sql,list);
	}

	@Override
	public boolean findByName(String name) {
		List<User> list=Query("select * from user where name=?",name);
		if(list.size()>0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		String sql="update user set password=?,money=?  where id=?";
		List<Object> list=new ArrayList<>();
		list.add(user.getPassword());
		list.add(user.getMoney());
		list.add(user.getId());
		return update(sql,list);
	}


	@Override
	public User getEntity(ResultSet rs) throws Exception {
		User user=new User();
		user.setId(rs.getInt(1));
		user.setName(rs.getString(2));
		user.setPassword(rs.getString(3));
		user.setMoney(rs.getDouble(4));
		return user;
	}

	@Override
	public User findById(int uid) {
		// TODO 自动生成的方法存根
		List<User> list=Query("select * from user where id=?",uid);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}



}
