package com.testcase.reportservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Report")

public class ReportWithDetails {

	@Id private int rid;
	private Patient pDetails;
	private List<LabTest> labTests;
	private String rname;
	private String status;
	
	public ReportWithDetails() {
		super();
		
	}

	public ReportWithDetails(int rid, Patient pDetails, List<LabTest> labTests, String rname, String status) {
		super();
		this.rid = rid;
		this.pDetails = pDetails;
		this.labTests = labTests;
		this.rname = rname;
		this.status = status;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public Patient getpDetails() {
		return pDetails;
	}

	public void setpDetails(Patient pDetails) {
		this.pDetails = pDetails;
	}

	public List<LabTest> getLabTests() {
		return labTests;
	}

	public void setLabTests(List<LabTest> labTests) {
		this.labTests = labTests;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
