package com.dao;

import bean.User;

public interface UserDao {
      User login(String account,String password);
      
      boolean register(User user);
      
      boolean findByName(String name);
      
      boolean updateUser(User user);
       
      User findById(int uid);


}

