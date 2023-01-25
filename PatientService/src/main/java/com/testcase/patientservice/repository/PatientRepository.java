package com.testcase.patientservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testcase.patientservice.model.Patient;

public interface PatientRepository  extends MongoRepository<Patient,Integer>{

}
