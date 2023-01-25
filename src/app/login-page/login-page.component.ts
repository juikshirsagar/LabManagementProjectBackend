import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginServiceService } from '../login-service.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
 

  credentials={
    username:'',
    password:''
  }
    constructor(private ls:LoginServiceService,
      private route:Router) { }

  ngOnInit(): void {
  }

   Login= new FormGroup({
    user:new FormControl('',[Validators.required,Validators.pattern(/^[A-Za-z0-9]+$/)]),
    password:new FormControl('',[Validators.required,Validators.minLength(4)]),
   });



  onSubmit(){
    // console.warn(this.Login.value);
    // this.route.navigate(['/dashboard']);
    

    if((this.credentials.username!='' && this.credentials.password!='')&&(this.credentials.username!=null && this.credentials.password!=null))
    {
     this.ls.GenrateToken(this.credentials).subscribe(
       (response:any) => {
          console.log(response);
        // localStorage.setItem("token",response.accessToken);
        this.route.navigate(['/dashboard']);
       },
       error=>{
         console.log(error);
         alert("Enter the correct username and password")
       }
       )
     //console.warn(this.LoginForm.value);
     // this.route.navigate(['/dashboard']);
     }else{
     console.log("values are empty")
     }
  }
   get user(){
    return this.Login.get('user');
  }

  get password(){
    return this.Login.get('password');
  }

  get f() {
    return this.Login.controls;
  }

}
