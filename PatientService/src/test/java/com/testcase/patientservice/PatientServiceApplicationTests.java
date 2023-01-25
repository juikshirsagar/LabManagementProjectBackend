package com.testcase.patientservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.testcase.patientservice.exception.PatientIDisAlreadyExistsException;
import com.testcase.patientservice.model.Patient;
import com.testcase.patientservice.repository.PatientRepository;
import com.testcase.patientservice.service.PatientService;



@SpringBootTest
class PatientServiceApplicationTests {
	@Autowired
	private PatientService service;
	
	@MockBean
	private PatientRepository repo;
	
	
	
	@Test

	@DisplayName("Test For AllLabTest")
	public void getAllTestTest() {
		when(repo.findAll()).thenReturn((List<Patient>) Stream
				.of(new Patient(1, "jui", "pune", "1999-01-17"), new Patient(1, "jui", "pune", "1999-01-17"))
				.collect(Collectors.toList()));
		assertEquals(2, service.getAllPatient().size());
	}
	 
	
	@Test
	@DisplayName("Test for AddPatient")
	public void addLabTestTest() throws PatientIDisAlreadyExistsException  {
		Patient labtest= new Patient(1,"jui","pune","1999-01-17");
		when(repo.save(labtest)).thenReturn(labtest);
		assertEquals(labtest,service.addPatient(labtest));
		
	}
	
	@Test
	@DisplayName("Test for DeletePAtient")
	public void deleteAllByIdTest() {
		Patient  test= new Patient(1,"jui","pune","1999-01-17");
		int id = 0;
		service.deleteAllById(id);
		
	}
	
	@Test
	@DisplayName("Updating test")
	public void updateByIdTest() {
		Patient test= new Patient(1,"jui","pune","1999-01-17");
		int id = 0;
		service.updateById(id, test);
	}


}
