package com.sameer.fullstack.controller;


import com.sameer.fullstack.common.StudentCourseRequest;
import com.sameer.fullstack.common.StudentCourseResponse;
import com.sameer.fullstack.entity.Student;
import com.sameer.fullstack.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("/createStudent")
    public StudentCourseResponse createStudent(@RequestBody StudentCourseRequest request){
        return service.createStudent(request);
    }

    @GetMapping("/{studentId}")
    public Optional<Student> getStudentDetailsById(@PathVariable int studentId){
        return service.getStudentDetailsById(studentId);
    }
}
