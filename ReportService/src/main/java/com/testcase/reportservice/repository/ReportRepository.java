package com.testcase.reportservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testcase.reportservice.model.Report;

public interface ReportRepository extends MongoRepository<Report,Integer>{

}
