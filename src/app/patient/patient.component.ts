import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Ipatient } from '../patientInterface';
import { PatientService } from '../service/patient.service';

export class Patient{
  pid!: number;
  name!: string;
  address!: string;
  dob!: string;
}


@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

  public patient:Patient[]=[];
  constructor(private patientservice:PatientService,
              private router:Router) { }

  ngOnInit(): void {
    this.getall();
  }
  private getall() {
    this.patientservice.getallpatient().subscribe(
      (      data: any) => {
        this.patient = data;
      });
  }

  delete(pid: number){
    this.patientservice.deletePatient(pid).subscribe( (data: any) => {
      console.log(data);
      this.getall();
    })
  }
  
  addPatient(){
    return this.router.navigate(['/addpatient'])
  }

  updatePatient(id: number){
    return this.router.navigate(['/patientupdate'])
  }
}
