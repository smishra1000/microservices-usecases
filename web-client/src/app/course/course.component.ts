import { Component, OnInit } from '@angular/core';
import {StudentService} from '../student.service';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {
  courses:any;
  constructor(private studentService:StudentService) { }

  ngOnInit() {
    this.getAllCourses();
  }

  getAllCourses(){
    this.studentService.getCourses().subscribe((response) => {
      this.courses = response;
     });
  }

}
