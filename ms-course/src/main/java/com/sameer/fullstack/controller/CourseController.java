package com.sameer.fullstack.controller;


import com.sameer.fullstack.entity.Course;
import com.sameer.fullstack.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CourseController {
    @Autowired
private CourseService service;
    @PostMapping("/createCourse")
    public Course createCourse(@RequestBody Course course){
        return service.createCourse(course);
    }

    @GetMapping("/")
    public List<Course> getCourses() {
        return service.getCourses();
    }

}
