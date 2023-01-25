package com.testcase.reportservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Patient")
public class Patient {

	
@Id private int pid;
private String name;
private String address;
private String dob;

public Patient(){
	
}
public Patient(int pid, String name, String address, String dob) {
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
