package com.testcase.patientservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testcase.patientservice.exception.PatientIDisAlreadyExistsException;
import com.testcase.patientservice.model.Patient;
import com.testcase.patientservice.repository.PatientRepository;

@Service
public class PatientService implements PatientInterface{

	@Autowired
	private PatientRepository patientrepo;
	
	@Override
	public List<Patient> getAllPatient() {
		
		return patientrepo.findAll();
	}

	@Override
	public void deleteAllById(int pid) {
		patientrepo.deleteById(pid);
	}

	@Override
	public Patient updateById(int pid, Patient patient) {
		
		return patientrepo.save(patient);
	}

	@Override
	public Patient addPatient(Patient patient) throws PatientIDisAlreadyExistsException {
		if(patientrepo.existsById(patient.getPid()))
			throw new PatientIDisAlreadyExistsException();
		else {
		return patientrepo.save(patient);}
	}

	@Override
	public Patient getPatient(int pid) {
		Optional<Patient> findById = patientrepo.findById(pid);
		return findById.get();
	}

}
