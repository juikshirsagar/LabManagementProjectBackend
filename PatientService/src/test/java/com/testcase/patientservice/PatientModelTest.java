package com.testcase.patientservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.testcase.patientservice.model.Patient;

@SpringBootTest
class PatientModelTest {

	private Patient p;

	@BeforeEach
	void init() {
	p=new  Patient(1,"jui","pune","1999-01-17");
	}

	@Test
	void testGetId()
	{
	assertEquals(1, p.getPid());
	}

	@Test
	void testGetName()
	{
	assertEquals("jui", p.getName());
	}
	
	@Test
	void testGetAddress()
	{
	assertEquals("pune", p.getAddress());
	}

	@Test
	void testGetDOB()
	{
	assertEquals("1999-01-17",p.getDob());
	}
}
