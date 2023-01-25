import { Injectable } from '@angular/core';
import { AbstractControl, ValidationErrors, Validator } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class PasswordService implements Validator {

  constructor() { }
  validate(control: AbstractControl<any, any>): ValidationErrors | null {
    const {password,confirmpassword} = control.value;
       if(password===confirmpassword){
        return null;

       }
       else{
        return { passwordDontMatch:true }
       }
       
  }
}
