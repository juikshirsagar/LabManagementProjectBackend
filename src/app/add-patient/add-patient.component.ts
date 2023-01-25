import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientService } from '../service/patient.service';

export class Patients{
  pid!: number;
  name!: string;
  address!: string;
  dob!: string;
}

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {
 

  patient: Patients =new Patients();
 
  constructor( private router:Router,private patientservice:PatientService,) { }

  ngOnInit(): void {
  }

  savePatient(){
    this.patientservice.createPatient(this.patient).subscribe((data: any) =>{
      console.log(data);
      this.goToPatientList();
     },
      (     error: any) => console.log(error));
   }

   goToPatientList(){
    this.router.navigate(['/patients']);
  }
  
  onSubmit(){
    console.log(this.patient);
    this.savePatient();
    alert("New Filed is added");
  }

}
