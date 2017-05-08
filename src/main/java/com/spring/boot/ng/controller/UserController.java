package com.spring.boot.ng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.ng.biz.UserService;
import com.spring.boot.ng.constant.ServiceConstants;
import com.spring.boot.ng.model.User;
import com.spring.boot.ng.utils.ServiceResponseUtils;
import com.spring.boot.ng.vo.ServiceResponse;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ServiceResponse saveUser(@RequestBody User data) {
		try {
			userService.doSaveUser(data);
			return ServiceResponseUtils.dataResponse(ServiceConstants.DATA_INSERTION_SUCCESS_CODE,
					ServiceConstants.DATA_INSERTION_SUCCESS_MESSAGE, null);
		} catch (Exception e) {
			return ServiceResponseUtils.dataResponse(ServiceConstants.DATA_INSERTION_FAILED_CODE,
					ServiceConstants.DATA_INSERTION_FAILED_MESSAGE, e);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ServiceResponse getUser() {
		try {
			List<User> users = userService.doGetUsers();
			if (users != null && !users.isEmpty()) {
				return ServiceResponseUtils.dataResponse(ServiceConstants.DATA_RETRIEVAL_SUCCESS_CODE,
						ServiceConstants.DATA_RETRIEVAL_SUCCESS_MESSAGE, users);
			} else {
				return ServiceResponseUtils.dataResponse(ServiceConstants.NO_RECORDS_FOUND_ERROR_CODE,
						ServiceConstants.NO_RECORDS_FOUND_ERROR_MESSAGE, null);
			}

		} catch (Exception e) {
			return ServiceResponseUtils.dataResponse(ServiceConstants.DATA_RETRIEVAL_FAILED_CODE,
					ServiceConstants.DATA_RETRIEVAL_FAILED_MESSAGE, e);
		}
	}

}
