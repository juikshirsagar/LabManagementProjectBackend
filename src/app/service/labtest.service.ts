import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';



export class LabTest{
  constructor(
    public id:number,
    public title:string,
    public data:string
  ) { }
}

@Injectable({
  providedIn: 'root'
})
export class LabtestService {

  constructor(private httpClient:HttpClient) { }

  getalltest(){
    console.log("test call");
    return this.httpClient.get<LabTest[]>('http://localhost:8031/LabTest/allTest');
  }

  createLabTest(labtest:any): Observable<Object>{
    return this.httpClient.post('http://localhost:8031/LabTest/addTest',labtest );
  }
  
  deleteLabTest(id: number): Observable<Object>{
    return this.httpClient.delete(`http://localhost:8031/LabTest/delete/${id}`);
  }

  
  getLabTestById(id: number): Observable<LabTest>{
    return this.httpClient.get<LabTest>(`http://localhost:8031/LabTest/allIdsTest/${id}`);
  }


  updateLabTest(id: number, labtest:any): Observable<Object>{
    return this.httpClient.put(`http://localhost:8031/LabTest/updateTest/${labtest.id}`, labtest);
  }


}
