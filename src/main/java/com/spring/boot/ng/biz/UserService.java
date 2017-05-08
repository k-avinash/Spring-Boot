package com.spring.boot.ng.biz;

import java.util.List;

import com.spring.boot.ng.model.User;

public interface UserService {

	void doSaveUser(User data) throws Exception;

	List<User> doGetUsers() throws Exception;

}
