package com.testcase.labtestservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.testcase.labtestservice.model.LabTest;

@SpringBootTest
class LabTestController extends AbstractTest {

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	@Test
	@DisplayName("All test")
	public void getAllEmployee() throws Exception {
		String uri = "/LabTest/allTest";
		LabTest alllabtest = new LabTest(1, "xyz", "positive");
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		LabTest[] productlist = (LabTest[]) super.mapFromJson(content, LabTest[].class);
		assertTrue(productlist.length > 0);
	}

	@Test
	@DisplayName("Add LabTest")
	public void addEmployee() throws Exception {
		String uri = "/LabTest/addTest";
		LabTest add = new LabTest(20, "abc", "positive");

		mvc.perform(MockMvcRequestBuilders.delete("/LabTest/delete/" + add.getId())).andReturn();

		String jsonString = mapToJson(add);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonString))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	@Test
	public void deleteLabTest() throws Exception {
		String uri = "/LabTest/delete/20";
		LabTest deletelab = new LabTest(20, "abc", "positive");
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	@Test
	public void updateProduct() throws Exception {

		LabTest lab = new LabTest(20, "abc", "positive");
		String uri = "/LabTest/updateTest/20";
		lab.setTitle("Thyroid");
		String inputJson = super.mapToJson(lab);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		LabTest product = super.mapFromJson(content, LabTest.class);
		assertEquals("Thyroid", product.getTitle());
	}

}
