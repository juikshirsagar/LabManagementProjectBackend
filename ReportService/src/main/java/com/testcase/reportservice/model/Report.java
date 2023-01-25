package com.testcase.reportservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Report")
public class Report {

	@Id private int rid;
	private int pid;
	private List<Integer> lid;
	private String rname;
	private String status;
	
	public Report() {
		super();
		
	}
	public Report(int rid, int pid, List<Integer> lid, String rname, String status) {
		super();
		this.rid = rid;
		this.pid = pid;
		this.lid = lid;
		this.rname = rname;
		this.status = status;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public List<Integer> getLid() {
		return lid;
	}
	public void setLid(List<Integer> lid) {
		this.lid = lid;
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
