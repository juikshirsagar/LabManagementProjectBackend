package com.testcase.registrationservice.service;

import com.testcase.registrationservice.exception.UserIsAlreadyExistsException;
import com.testcase.registrationservice.model.User;
import com.testcase.registrationservice.model.UserInfo;

public interface UserInterface {

	public UserInfo addUser(User user) throws UserIsAlreadyExistsException;
}
