import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LabtestService } from '../service/labtest.service';


export class LabTests{
  id!: number;
   title!: string;
   data!: string; 
   
}

@Component({
  selector: 'app-update-test',
  templateUrl: './update-test.component.html',
  styleUrls: ['./update-test.component.css']
})
export class UpdateTestComponent implements OnInit {

  id!: number;
  labtest: LabTests =new LabTests();
  
  constructor(private labservice:LabtestService,
    private router: Router,private route: ActivatedRoute,) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.labservice.getLabTestById(this.id).subscribe(data => {
      this.labtest = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.labservice.updateLabTest(this.id, this.labtest).subscribe( data =>{
      this.goToList();
     console.log(data);
     alert("The LabTest Got Updated..")
    }
    , error => console.log(error));
  }

  goToList(){
    this.router.navigate(['/labtest']);
  }
}
