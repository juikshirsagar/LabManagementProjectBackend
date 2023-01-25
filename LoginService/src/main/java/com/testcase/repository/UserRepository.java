package com.testcase.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testcase.model.UserInfo;

public interface UserRepository extends MongoRepository<UserInfo,String>{

}
