import { Component, OnInit } from '@angular/core';
import {StudentService} from '../student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {


  student:any;
  course:any;
  recieved:any;
  students:any;
  courses:any;
  constructor(private studentService:StudentService) { 
    this.student = {
      name:"",
      age:"",
      email:"",
    }

    this.course = {
      name:"",
      description:""
    }

  }

  ngOnInit() {
    this.getAllStudent();
  }

  register(){
    let body = {
      student:this.student,
      course:this.course
    }
    this.studentService.registerStudentwithCourse(body).subscribe((response) => {
     console.log("created",response);
     this.student = {};
     this.course = {};
     this.getAllStudent();
    });
    
  }
  getAllStudent(){
    this.studentService.getAllDetails().subscribe((response) => {
      this.recieved = true;
      this.students = response;
     });
  }

  getDetails(id){
    this.studentService.getDetails(id).subscribe((response) => {
      this.recieved = true;
      this.student = response.student;
     });
  }

  getCourses() {
    this.studentService.getCourses().subscribe((response) => {
      this.courses = response.courses;
     });
  }

}
