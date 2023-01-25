import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LabtestService } from '../service/labtest.service';


export class LabTests{
  id!: number;
   title!: string;
   data!: string; 
   
}
@Component({
  selector: 'app-add-lab-test',
  templateUrl: './add-lab-test.component.html',
  styleUrls: ['./add-lab-test.component.css']
})
export class AddLabTestComponent implements OnInit {

  labtest: LabTests =new LabTests();
  constructor( private labservice:LabtestService,
    private router: Router) { }

  ngOnInit(): void {
   }

   Add=new FormGroup({
    Id:new FormControl('',[Validators.required,Validators.pattern(/^[0-9]+$/)]),
    // title:new FormGroup('',[Validators.required,Validators.pattern(/^[A-Za-z]+$/)]),
    // Data:new FormGroup('',[Validators.required,Validators.pattern(/^[A-Za-z]+$/)])
   });
  saveLabTest(){
    this.labservice.createLabTest(this.labtest).subscribe( data =>{
     console.log(data);
     this.goToLabTestList();
    },
    error => console.log(error));
  }

  goToLabTestList(){
    this.router.navigate(['/labtest']);
  }
  
  onSubmit(){
    console.log(this.labtest);
    this.saveLabTest();
    alert("New Filed is added");
  }

  get Id(){
    return this.Add.get('Id');
  }

  get Title(){
    return this.Add.get("Title");
  }

  get Data(){
    return this.Add.get('Data');
  }
}
