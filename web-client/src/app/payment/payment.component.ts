import { Component, OnInit } from '@angular/core';

import {StudentService}  from '../student.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  payments:"";
  errorMessage:"";
  error:boolean;
  constructor(private studentService:StudentService) { }

  ngOnInit() {

    this.getPayment();
  }

  getPayment() {
    this.studentService.getPayment().subscribe((response) => {
      console.log(response);
      this.payments = response;
      this.error = false; 
     },
     (error) => {        
      console.log(error.error);   
      this.errorMessage = error.error;
      this.error = true;        
       console.error('error caught in component')
     }
   )
  }

}
