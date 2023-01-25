import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit(): void {
  }

  onSubmitLabTest(){
    console.log();
    this.route.navigate(['/labtest']);
    
  }

  onSubmitPatient(){
    this.route.navigate(['/patients']);
  }

  onSubmitReport(){
    this.route.navigate(['/report']);
  }
}
