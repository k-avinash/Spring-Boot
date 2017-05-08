package com.spring.boot.ng.biz.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.ng.biz.UserService;
import com.spring.boot.ng.dao.UserDao;
import com.spring.boot.ng.model.User;

@Service
public class UserServiceImpl implements UserService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserDao userDao;

	@Override
	public void doSaveUser(User data) {
		try {
			userDao.saveUser(data);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public List<User> doGetUsers() throws Exception {
		List<User> users = null;
		try {
			users = userDao.getUsers();
		} catch (Exception e) {
			e.getMessage();
		}
		return users;
	}
}
