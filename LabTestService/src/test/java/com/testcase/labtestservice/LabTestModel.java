package com.testcase.labtestservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.testcase.labtestservice.model.LabTest;


@SpringBootTest
class LabTestModel {
	
	private LabTest e;

	@BeforeEach
	void init() {
	e=new LabTest(1,"bloodtest","B positive");
	}

	@Test
	void testGetId()
	{
	assertEquals(1, e.getId());
	}

	@Test
	void testGetTitle()
	{
	assertEquals("bloodtest", e.getTitle());
	}
	
	@Test
	void testGetData()
	{
	assertEquals("B positive", e.getData());
	}

	


}
