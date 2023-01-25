import { Injectable } from '@angular/core';
import { AbstractControl, ValidationErrors } from '@angular/forms';
import { Observable, map, of, catchError } from 'rxjs';
import { AuthServiceService } from '../service/auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class UsernameService {

  static getUsernameVaildation(auth: AuthServiceService) {
    return (control: AbstractControl): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> => {
        const { value } = control;
        return auth.checkUserName(value).pipe(
            map(res=>{
                if(res.status===208){
                    console.log(res)
                    return of({ });
                }
                return null;
            }),
            catchError((err)=>{
                console.log(err)
                    return of({ SomethingWentWrong : true });                 
            })

        )
    }
}
}
