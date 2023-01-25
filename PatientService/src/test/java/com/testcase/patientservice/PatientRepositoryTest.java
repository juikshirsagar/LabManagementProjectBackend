package com.testcase.patientservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.testcase.patientservice.model.Patient;
import com.testcase.patientservice.repository.PatientRepository;

@SpringBootTest
class PatientRepositoryTest {

	@Autowired
	private PatientRepository patientrepo;

	@Test
	@DisplayName("RepositoryTest")
	public void isDBExist() {
	Patient p=new Patient(101,"jui","pune","99-01-17");
		patientrepo.save(p);
		assertNotNull(patientrepo.findById((int) 101).get());
		
	}


}
