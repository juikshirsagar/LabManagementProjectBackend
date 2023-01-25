import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthServiceService } from '../service/auth-service.service';

@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.css']
})
export class SignupPageComponent implements OnInit {

  constructor(private router:Router,private service:AuthServiceService) { }

  ngOnInit(): void {
  }

  RegForm=new FormGroup({
    user:new FormControl('',[Validators.required,Validators.pattern('[a-zA-Z]+$')]),
    password:new FormControl('',[Validators.required,Validators.minLength(4)]),
    confirmPassword: new FormControl('', [Validators.required,Validators.minLength(4)]),
  });
  signup(){
    this.service.signUp(this.RegForm.value).subscribe({
      next:res=>{

        window.alert("done")
        this.router.navigate(["/login"])
      },
      error:err=>{
        window.alert(err.message)
      }
    })
  }

   get user(){
    return this.RegForm.get('user');
  }

  get password(){
    return this.RegForm.get('password');
  }
   
  get confirmpassword(){
    return this.RegForm.get('confirmpassword');
  }
  get f() {
    return this.RegForm.controls;
  }


}
