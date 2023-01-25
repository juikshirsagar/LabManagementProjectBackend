package com.testcase.reportservice.service;

import java.util.List;

import com.testcase.reportservice.exception.ReportIdAlreadyExistsException;
import com.testcase.reportservice.model.Report;
import com.testcase.reportservice.model.ReportWithDetails;



public interface ReportInterface {

	public Report addReport(Report report) throws ReportIdAlreadyExistsException;
	
	public List<ReportWithDetails> getAllReport();

	public void deleteAllById(int rid);

	public Report updateById(int rid, Report report);

	
}
