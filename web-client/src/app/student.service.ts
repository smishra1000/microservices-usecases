import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { map } from "rxjs/operators";
import { HttpClient,HttpErrorResponse} from '@angular/common/http';
import {environment} from '../environments/environment';
import { catchError } from 'rxjs/operators'
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  studentApiUrl:any;
  courseApiUrl:any;
  paymentApiUrl:any;
  constructor(private httpClient:HttpClient) {
    this.studentApiUrl =  environment.student;
    this.courseApiUrl = environment.course;
    this.paymentApiUrl = environment.payment;

   }
   public registerStudentwithCourse(body):Observable<any> {
     //To do need to move in shared palce as a intercepter
    const  headers = {'Content-Type': 'application/json', 
    'Access-Control-Allow-Origin': '*',
    'Access-Control-Allow-Headers':'Content-Type',
    'Access-Control-Allow-Methods': 'GET',}
    
    
    return this.httpClient.post(this.studentApiUrl+'student/createStudent',body, {headers:headers});
  }

  public getDetails(id):Observable<any> {
    return this.httpClient.get(this.studentApiUrl+'student/'+id);
  }
  public getAllDetails():Observable<any> {
    return this.httpClient.get(this.studentApiUrl+'student/');
  }
  //For now creating course here only;
  //Todo--need to create separate service 
  public getCourses():Observable<any> {
    return this.httpClient.get(this.courseApiUrl+'course/');
  }

  public getPayment():Observable<any> {
    return this.httpClient.get(this.paymentApiUrl+'payment/').pipe(
      catchError(this.handleError)
      );;
  }

  handleError(error: HttpErrorResponse){
      return throwError(error);
    }
}
