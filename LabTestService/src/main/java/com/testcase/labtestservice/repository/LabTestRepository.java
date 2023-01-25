package com.testcase.labtestservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testcase.labtestservice.model.LabTest;

public interface LabTestRepository extends MongoRepository<LabTest,Integer> {

}
