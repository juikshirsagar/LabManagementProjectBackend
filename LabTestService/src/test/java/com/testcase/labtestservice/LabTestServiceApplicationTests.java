package com.testcase.labtestservice;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.testcase.labtestservice.exception.LabTestIDAlreadyExistsException;
import com.testcase.labtestservice.model.LabTest;
import com.testcase.labtestservice.repository.LabTestRepository;
import com.testcase.labtestservice.service.LabTestSevice;
import static org.mockito.BDDMockito.given;


@SpringBootTest
class LabTestServiceApplicationTests {
	@Autowired
	private LabTestSevice service;
	
	@MockBean
	private LabTestRepository labrepo;
	
	
	@Test

	@DisplayName("Test For AllLabTest")
	public void getAllTestTest() {
		when(labrepo.findAll()).thenReturn((List<LabTest>) Stream
				.of(new LabTest(33, "Blood Test", "positive"), new LabTest(34, "Hb Test", "negative"))
				.collect(Collectors.toList()));
		assertEquals(2, service.getalltest().size());
	}
	
	@Test
	@DisplayName("Test for AddLabTest")
	public void addLabTestTest() throws LabTestIDAlreadyExistsException  {
		LabTest labtest= new LabTest(14,"corona","positive");
		given(labrepo.existsById(labtest.getId())).willReturn(true);
		
		 assertThrows(LabTestIDAlreadyExistsException.class,()-> service.add(labtest));
		
	}
	
	@Test
	@DisplayName("Test for DeleteLabTest")
	public void deleteAllByIdTest() {
		LabTest  labtest= new LabTest(14,"corona","positive");
		int id = 0;
		service.deleteAllById(id);
		
	}
	
	@Test
	@DisplayName("Updating test")
	public void updateByIdTest() {
		LabTest labtest= new LabTest(14,"corona","positive");
		int id = 14;
		service.updateById(id, labtest);
	}

}
