package com.flightmanagement.dao;

import java.util.Map;

import com.flightmanagement.model.User;

import java.util.HashMap;

public class UserDao {
  private Map<String,User> userMap=new HashMap<>();
  public void addUser(User user) {
	  userMap.put(user.getUserId(), user);
  }
  public User getUser(String userId) {
	  return userMap.get(userId);
  }
}
