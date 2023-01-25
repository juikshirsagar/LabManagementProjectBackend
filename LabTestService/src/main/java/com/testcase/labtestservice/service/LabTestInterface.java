package com.testcase.labtestservice.service;

import java.util.List;

import com.testcase.labtestservice.exception.LabTestIDAlreadyExistsException;
import com.testcase.labtestservice.model.LabTest;

public interface LabTestInterface {


	public List<LabTest> getalltest();
	public List<LabTest> getallidstest(List<Integer> lids);

	public void deleteAllById(int id);

	public LabTest updateById(int id, LabTest labtest);

	LabTest add(LabTest labTest) throws LabTestIDAlreadyExistsException;
}
