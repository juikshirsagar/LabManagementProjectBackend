package com.testcase.reportservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Report")
public class Report2T {

	@Id private int rid;
	private String pname;
	private String rname;
	private String status;
	
	public Report2T() {
		
	}
	
	public Report2T(int rid, String pname, String rname, String status) {
		super();
		this.rid = rid;
		this.pname = pname;
		this.rname = rname;
		this.status = status;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
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
