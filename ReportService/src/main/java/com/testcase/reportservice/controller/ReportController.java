package com.testcase.reportservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.testcase.reportservice.exception.ReportIdAlreadyExistsException;
import com.testcase.reportservice.model.Report;
import com.testcase.reportservice.model.ReportWithDetails;
import com.testcase.reportservice.service.ReportService;

@RestController
@RequestMapping("/Report")
@CrossOrigin(origins="http://localhost:4200")
public class ReportController {

	
	
	@Autowired
	private ReportService reportservice;

	// create operation
	@PostMapping("/addReport")
	public Report addTest(@RequestBody Report patient) throws ReportIdAlreadyExistsException {
		return reportservice.addReport(patient);
	}

	// read all report
	@GetMapping("/allReport")
	public List<ReportWithDetails> getAllTest() {
		return (reportservice.getAllReport());

	}

	// deleting the test of particular id
	@DeleteMapping("/delete/{rid}")
	public void delete(@PathVariable int rid) {
		reportservice.deleteAllById(rid);

	}

	// updating the test by id
	@PutMapping("/updateReport/{rid}")
	public Report updateById(@PathVariable int rid, @RequestBody Report report) {
		return reportservice.updateById(rid, report);

	}

}
