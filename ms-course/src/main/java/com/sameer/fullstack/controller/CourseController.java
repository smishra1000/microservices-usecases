package com.sameer.fullstack.controller;


import com.sameer.fullstack.entity.Course;
import com.sameer.fullstack.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
private CourseService service;
    @PostMapping("/createCourse")
    public Course createCourse(@RequestBody Course course){
        return service.createCourse(course);
    }

}
