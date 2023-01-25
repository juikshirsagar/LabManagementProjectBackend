package com.testcase.registrationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testcase.registrationservice.exception.UserIsAlreadyExistsException;
import com.testcase.registrationservice.model.User;
import com.testcase.registrationservice.model.UserInfo;
import com.testcase.registrationservice.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/Registration/user")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/add")
	public UserInfo addUser(@RequestBody User user) throws UserIsAlreadyExistsException {
		return service.addUser(user);
	}
}
