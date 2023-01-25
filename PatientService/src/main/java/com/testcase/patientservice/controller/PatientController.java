package com.testcase.patientservice.controller;

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

import com.testcase.patientservice.exception.PatientIDisAlreadyExistsException;
import com.testcase.patientservice.model.Patient;
import com.testcase.patientservice.service.PatientService;



@RestController
@RequestMapping("/Patient")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

	
	@Autowired
	 private PatientService patientservice;
	
	//create operation
   @PostMapping("/addPatient")
   public Patient addTest(@RequestBody @Valid Patient patient) throws PatientIDisAlreadyExistsException {
  	return patientservice.addPatient(patient);
   	}
   
   //read all patient
   @GetMapping("/allPatient")
   public List<Patient> getAllTest() {
       return (patientservice.getAllPatient());
     
   }
   
   //read patient by id
   @GetMapping("/patient/{pid}")
   public Patient getTest(@PathVariable int pid) {
	   return (patientservice.getPatient(pid));
	   
   }
   
   //deleting the test of particular id
   @DeleteMapping("/delete/{pid}")
   public void delete(@PathVariable int pid) {
	   patientservice.deleteAllById(pid);
   
   	
   }
   
   //updating the test by id
   @PutMapping("/updatePatient/{pid}")
   public Patient updateById(@PathVariable int pid, @RequestBody Patient patient) {
		return patientservice.updateById(pid, patient);
   	
   }

}
