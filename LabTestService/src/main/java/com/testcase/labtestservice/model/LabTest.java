package com.testcase.labtestservice.model;

import javax.validation.constraints.NotBlank;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "LabTest")
public class LabTest {
	@Id
	private int id;
	@NotBlank(message="Add title ")
	private String title;
	@NotBlank(message="Data should not be empty")
	private String data;

	//default constructor
	public LabTest() {

	}
	// parameterised contructor
	public LabTest(@NotBlank(message = "ID should not be empty") int id, @NotBlank(message = "Add title ") String title,
			@NotBlank(message = "Data should not be empty") String data) {
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
