import { Injectable } from '@angular/core';
import { HttpClient ,HttpClientModule} from '@angular/common/http';
import { tokenToString } from 'typescript';
@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  // baseUrl = "http://localhost:8088/"

  constructor(private http:HttpClient) { }

  GenrateToken(credentials:any)
  {
    return this.http.post("http://localhost:8088/authenticate",credentials);
  }

      //to calling token from server
   loginUser(token: string){
    localStorage.setItem("token",token);
    return true;
    }
    
    //
    isLoggedIn(){
    let token=localStorage.getItem("token");
    if(token==undefined || token=='' || token==null)
    {
    return false;
    }else{
    return true;
    }
    }
    
    //
    logout(){
    localStorage.removeItem('token');
    return true
    }
    
}
