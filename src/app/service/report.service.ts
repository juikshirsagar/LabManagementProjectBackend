import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ListFormat } from 'typescript';

import { Ipatient } from '../patientInterface';


export class LabTests{
  id!: number;
   title!: string;
   data!: string; 
   
}

export class Report{
  rid!:number;
  pDetails!:Ipatient;
  labTests!: LabTests[];
  rname!:string;
  status!:string
}


@Injectable({
  providedIn: 'root'
})
export class ReportService {

  constructor(private httpClient:HttpClient) { }

  getallreports(){
    console.log("test call");
    return this.httpClient.get<Report[]>('http://localhost:8033/Report/allReport');
  }

}
