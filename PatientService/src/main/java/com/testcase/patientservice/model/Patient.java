package com.testcase.patientservice.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;

@Document(collection = "Patient")
@CrossOrigin(origins="http://localhost:4200")
public class Patient {

	@Id
	private int pid;
	@NotEmpty(message = "Please Provide Name")
	private String name;
	@NotEmpty(message = "Please Provide the Address")
	private String address;
	@NotEmpty(message = "Mention Your Date Of Birth")
	private String dob;

	//default Constructor
	public Patient() {

	}

	//constructor with argument
	public Patient(int pid, @NotEmpty(message = "Please Provide Name") String name,
			@NotEmpty(message = "Please Provide the Address") String address,
			@NotEmpty(message = "Mention Your Date Of Birth") String dob) {
		super();
		this.pid = pid;
		this.name = name;
		this.address = address;
		this.dob = dob;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

}
