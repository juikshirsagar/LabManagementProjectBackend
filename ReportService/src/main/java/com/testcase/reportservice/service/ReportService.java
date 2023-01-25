package com.testcase.reportservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.testcase.reportservice.exception.ReportIdAlreadyExistsException;
import com.testcase.reportservice.model.LabTest;
import com.testcase.reportservice.model.Patient;
import com.testcase.reportservice.model.Report;
import com.testcase.reportservice.model.ReportWithDetails;
import com.testcase.reportservice.repository.ReportRepository;

@Service
public class ReportService implements ReportInterface {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ReportRepository reportrepo;

	@Override
	public Report addReport(Report report) throws ReportIdAlreadyExistsException {

		if (reportrepo.existsById(report.getRid()))
			throw new ReportIdAlreadyExistsException();
		else {
			return reportrepo.save(report);
		}
	}

	@Override
	public List<ReportWithDetails> getAllReport() {
		List<Report> findAll = reportrepo.findAll();
//		return findAll.stream().map(item -> {
//			
//			restTemplate.getForObject("localhost:8080/Patient/allPatient",)
//		});

		/*
		 * List<ReportWithDetails> reportWithDetails = new ArrayList<>();
		 * 
		 * findAll.forEach((item)->{
		 * 
		 * Patient patient =
		 * restTemplate.getForObject("http://localhost:8032/Patient/patient/"+item.
		 * getPid(),Patient.class);
		 * 
		 * LabTest[] labtest=
		 * restTemplate.postForObject("http://localhost:8031/LabTest/allIdsTest",
		 * item.getLid(),LabTest[].class);
		 * 
		 * ReportWithDetails rwd = new
		 * ReportWithDetails(item.getRid(),patient,List.of(labtest),item.getRname(),item
		 * .getStatus()); reportWithDetails.add(rwd); });
		 * 
		 * return reportWithDetails;
		 */
		return findAll.stream().map(item -> {
			Patient patient = restTemplate.getForObject("http://localhost:8032/Patient/patient/" + item.getPid(),
					Patient.class);

			LabTest[] labtest = restTemplate.postForObject("http://localhost:8031/LabTest/allIdsTest", item.getLid(),
					LabTest[].class);
			return new ReportWithDetails(item.getRid(), patient, List.of(labtest), item.getRname(), item.getStatus());
		}).collect(Collectors.toList());

	}

	@Override
	public void deleteAllById(int rid) {
		reportrepo.deleteById(rid);
	}

	@Override
	public Report updateById(int rid, Report report) {

		return reportrepo.save(report);
	}

}
