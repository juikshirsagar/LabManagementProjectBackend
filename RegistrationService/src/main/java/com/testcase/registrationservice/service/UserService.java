package com.testcase.registrationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testcase.registrationservice.exception.UserIsAlreadyExistsException;
import com.testcase.registrationservice.model.User;
import com.testcase.registrationservice.model.UserInfo;
import com.testcase.registrationservice.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService implements UserInterface {

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Override
	public UserInfo addUser(User user) throws UserIsAlreadyExistsException{
//		if(userrepo.existsById(user.getUsername())) {
//
//			throw new UserIsAlreadyExistsException();
//		}
//		else {
			String encodedPass = bcryptEncoder.encode(user.getPassword());
			UserInfo newuser = new UserInfo(user.getUsername(), encodedPass);
			return userrepo.save(newuser);
	//	}
	}

}
