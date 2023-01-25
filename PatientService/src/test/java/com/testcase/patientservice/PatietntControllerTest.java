package com.testcase.patientservice;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.testcase.patientservice.model.Patient;

@SpringBootTest
class PatietntControllerTest extends AbstractTest {

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	
	@Test

	@DisplayName("All Patient test")
	public void getAllPatient() throws Exception {
		String uri = "/Patient/allPatient";
		Patient allPatient = new Patient(1, "xyz", "pune", "1999-01-17");
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Patient[] productlist = (Patient[]) super.mapFromJson(content, Patient[].class);
		assertTrue(productlist.length > 0);
	}

	@Test
	@DisplayName("Add Patient")
	public void addPatient() throws Exception {
		String uri = "/Patient/addPatient";
		Patient addpatient = new Patient(1,"xyz","pune","1999-01-17");

		mvc.perform(MockMvcRequestBuilders.delete("/Patient/delete/" + addpatient.getPid())).andReturn();
		
		String jsonString = mapToJson(addpatient);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonString))
				.andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	@Test
	public void deleteLabTest() throws Exception {
		String uri = "/Patient/delete/20";
		Patient delete = new Patient(20, "abc", "pune","17-01-99");
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	@Test
	public void updatePatient() throws Exception {

		Patient patient = new Patient(20, "abc", "pune","17-01-99");
		String uri = "/Patient/updatePatient/20";
		patient.setName("jui");;
		String inputJson = super.mapToJson(patient);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Patient product = super.mapFromJson(content, Patient.class);
		assertEquals("jui", product.getName());
	}

}
