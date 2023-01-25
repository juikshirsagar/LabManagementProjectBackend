import { Component, OnInit } from '@angular/core';
import { Ipatient } from '../patientInterface';
import { ILabTests } from '../LabInterface';
import { ReportService } from '../service/report.service';


export class Report{
  rid!:number;
  pDetails!:Ipatient;
  labTests!:ILabTests;
  rname!:string;
  status!:string
}

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  public report:Report[]=[];
  constructor(private reportservice:ReportService) { }

  ngOnInit(): void {
    this.getall();
  }

  private getall() {
    this.reportservice.getallreports().subscribe(
      (      data: any) => {
        this.report = data;
      });
  }
}
