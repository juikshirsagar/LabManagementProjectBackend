import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ILabTest } from '../LabTestInterface';
import { LabtestService } from '../service/labtest.service';

@Component({
  selector: 'app-lab-test',
  templateUrl: './lab-test.component.html',
  styleUrls: ['./lab-test.component.css']
})
export class LabTestComponent implements OnInit {

  public labtests: ILabTest[]=[];
  constructor(private labservice:LabtestService, private router:Router) { }

  ngOnInit(): void {
    this.getalltest();
  }

  private getalltest(){
    this.labservice.getalltest().subscribe(
      (      data: any) => {
        this.labtests = data;
      });
   }
   
  
  deleteLabTest(id: number){
    this.labservice.deleteLabTest(id).subscribe( (data: any) => {
      console.log(data);
      this.getalltest();
    })
  }

  addLabTest(){
    return this.router.navigate(['/addlab'])
  }
  

  updateLabTest(id: number){
    return this.router.navigate(['update/:id'])
  }
}
