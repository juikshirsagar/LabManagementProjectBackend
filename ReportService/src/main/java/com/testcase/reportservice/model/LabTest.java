package com.testcase.reportservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "LabTest")
public class LabTest {
	@Id
	private int id;
	private String title;
	private String data;

	public LabTest() {

	}

	public LabTest(int id, String title, String data) {
		super();

		this.id = id;
		this.title = title;
		this.data = data;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
