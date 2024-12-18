package com.flightmanagement.service;

import com.flightmanagement.dao.UserDao;
import com.flightmanagement.model.User;

public class UserService {
private UserDao userDao;
public UserService(UserDao userDao) {
	this.userDao=userDao;
}
public void addUser(User user) {
	userDao.addUser(user);
}
public User getUser(String userId) {
	return userDao.getUser(userId);
}
}
