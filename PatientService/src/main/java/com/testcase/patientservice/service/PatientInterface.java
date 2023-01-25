package com.testcase.patientservice.service;

import java.util.List;

import com.testcase.patientservice.exception.PatientIDisAlreadyExistsException;
import com.testcase.patientservice.model.Patient;

public interface PatientInterface {

	
	public List<Patient> getAllPatient();

	public void deleteAllById(int pid);

	public Patient getPatient(int pid);
	public Patient updateById(int pid, Patient patient);

	public Patient addPatient(Patient patient) throws PatientIDisAlreadyExistsException;
}
