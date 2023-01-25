import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  headers=new HttpHeaders().set("Access-Control-Allow-Origin", "http://localhost:4200");
  constructor(private http:HttpClient) { }

  getAutheticate(req:any){
    console.log(req);
    return this.http.post<any>('http://localhost:8088/authenticate',req)
  }
  signUp(req:any){
    return this.http.post<any>('http://localhost:8034/Registration/user/add',req)
  }

  checkUserName(str:string){
    return this.http.get<any>(`http://localhost:8088/checkusername/${str}`,{
      headers:this.headers
    })
  }
}
