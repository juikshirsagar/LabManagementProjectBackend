package com.testcase.labtestservice.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.testcase.labtestservice.exception.LabTestIDAlreadyExistsException;
import com.testcase.labtestservice.model.LabTest;
import com.testcase.labtestservice.service.LabTestSevice;

@RestController
@RequestMapping("/LabTest")
@CrossOrigin("http://localhost:4200")
public class LabTestController {

	@Autowired
	 private LabTestSevice labservice;
	
	//create operation
    @PostMapping("/addTest")
    public LabTest addTest(@RequestBody @Valid LabTest labtest) throws LabTestIDAlreadyExistsException {
      return  labservice.add(labtest);
    	}
    
    //read all test
    @GetMapping("/allTest")
    public List<LabTest> getAllTest() {
        return (labservice.getalltest());
      
    }
    //read all test by id
    @PostMapping("/allIdsTest")
    public List<LabTest> getAllIdsTest(@RequestBody List<Integer> lids) {
    	return (labservice.getallidstest(lids));
    	
    }
    
    //deleting the test of particular id
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
    	labservice.deleteAllById(id);
    
    	
    }
    
    //updating the test by id
    @PutMapping("/updateTest/{id}")
    public LabTest updateById(@PathVariable int id, @RequestBody LabTest labtest) {
		return labservice.updateById(id, labtest);
    	
    }

}
