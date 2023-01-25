import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { PatientService } from '../service/patient.service';

export class Patients{
  pid!: number;
  name!: string;
  address!: string;
  dob!: string;
}

@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrls: ['./update-patient.component.css']
})
export class UpdatePatientComponent implements OnInit {

  pid!: number;
  patient: Patients =new Patients();
  
  constructor(private patientservice:PatientService,
    private router: Router,private route: ActivatedRoute,) { }

  ngOnInit(): void {
    this.pid = this.route.snapshot.params['pid'];

    this.patientservice.getPatientById(this.pid).subscribe(data => {
      this.patient = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.patientservice.updatePatient(this.pid, this.patient).subscribe( data =>{
      this.goToList();
     console.log(data);
     alert("The LabTest Got Updated..")
    }
    , error => console.log(error));
  }

  goToList(){
    this.router.navigate(['/patients']);
  }
}
