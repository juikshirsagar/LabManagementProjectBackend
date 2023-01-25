import { HttpClient } from '@angular/common/http';
import { JitEvaluator } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

export class patients{
 
  pid!: number;
  name!: string;
  address!: string;
  dob!: string;
 
}

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private httpClient:HttpClient) { }

  getallpatient(){
    console.log("test call");
    return this.httpClient.get<patients[]>('http://localhost:8032/Patient/allPatient');
  }

  deletePatient(pid: number): Observable<Object>{
    return this.httpClient.delete(`http://localhost:8032/Patient/delete/${pid}`);
  }

  createPatient(patient:any): Observable<Object>{
    return this.httpClient.post('http://localhost:8032/Patient/addPatient', patient);
  }

  getPatientById(pid: number): Observable<patients>{
    return this.httpClient.get<patients>(`http://localhost:8032/Patient/patient/${pid}`);
  }


  updatePatient(pid: number, patient:any): Observable<Object>{
    return this.httpClient.put(`http://localhost:8032/Patient/updatePatient/${patient.pid}`, patient);
  }

}
