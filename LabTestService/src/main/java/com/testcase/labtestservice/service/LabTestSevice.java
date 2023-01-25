package com.testcase.labtestservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testcase.labtestservice.exception.LabTestIDAlreadyExistsException;
import com.testcase.labtestservice.model.LabTest;
import com.testcase.labtestservice.repository.LabTestRepository;

@Service
public class LabTestSevice implements LabTestInterface {

	@Autowired
	private LabTestRepository labrepo;

	// to save labtest save()
	@Override
	public LabTest add(LabTest labTest) throws LabTestIDAlreadyExistsException {

		if(labrepo.existsById(labTest.getId()))
			throw new LabTestIDAlreadyExistsException();
		else {
		return labrepo.save(labTest);}
	}

	// to getalltest
	@Override
	public List<LabTest> getalltest() {

		return labrepo.findAll();
	}

	// delete the record by id
	@Override
	public void deleteAllById(int id) {
		labrepo.deleteById(id);

	}

	@Override
	public LabTest updateById(int id, LabTest labtest) {
		
		return labrepo.save(labtest);
	}

	@Override
	public List<LabTest> getallidstest(List<Integer> lids) {
		// TODO Auto-generated method stub
		return (List<LabTest>) labrepo.findAllById(lids);
	}

	
}
