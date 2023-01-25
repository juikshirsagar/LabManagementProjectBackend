package com.testcase.registrationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testcase.registrationservice.model.UserInfo;

public interface UserRepository extends MongoRepository<UserInfo,String>{

}
