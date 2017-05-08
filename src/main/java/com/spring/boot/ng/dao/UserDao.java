package com.spring.boot.ng.dao;

import java.util.List;

import com.spring.boot.ng.model.User;

public interface UserDao {

	void saveUser(User data) throws Exception;

	List<User> getUsers() throws Exception;

}
