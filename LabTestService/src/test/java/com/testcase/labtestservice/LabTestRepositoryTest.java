package com.testcase.labtestservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.testcase.labtestservice.model.LabTest;
import com.testcase.labtestservice.repository.LabTestRepository;

@SpringBootTest
class LabTestRepositoryTest {

	@Autowired
	public LabTestRepository labrepo;

	@Test
	@DisplayName("RepositoryTest")
	public void isDBExist() {
	LabTest e1=new LabTest(101,"blood test","positive");
	
		labrepo.save(e1);
		assertNotNull(labrepo.findById((int) 101).get());
		
	}

	}
