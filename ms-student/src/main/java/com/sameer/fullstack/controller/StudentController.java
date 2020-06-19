package com.sameer.fullstack.controller;


import com.sameer.fullstack.common.StudentCourseRequest;
import com.sameer.fullstack.common.StudentCourseResponse;
import com.sameer.fullstack.entity.Student;
import com.sameer.fullstack.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;


//    @HystrixCommand(fallbackMethod = "fallback", groupKey = "course",
//            commandKey = "course",
//            threadPoolKey = "courseThread"
//    )
    @PostMapping("/createStudent")
    @CrossOrigin(origins = "*")
    public StudentCourseResponse createStudent(@RequestBody StudentCourseRequest request){
        return service.createStudent(request);
    }

    @GetMapping("/{studentId}")
    @CrossOrigin(origins = "*")
    public Optional<Student> getStudentDetailsById(@PathVariable int studentId){
        return service.getStudentDetailsById(studentId);
    }


    @HystrixCommand(fallbackMethod = "studentServiceDown")
    @GetMapping("/")
    public List<Student> getAllStudent() {
        return service.getAllStudent();
    }
    public String fallback(Throwable hystrixCommand) {
        return "Fall Back from student is down";
    }

    public List<Student> studentServiceDown(Throwable hystrixCommand) {
        List<Student> studentList = new ArrayList<Student>();
        Student std = new Student(1,"sameer", "sameer@gmail.com",25);
        studentList.add(std);

        return studentList;
    }
}
