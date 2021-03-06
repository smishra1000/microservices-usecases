package com.sameer.fullstack.service;


import com.sameer.fullstack.entity.Course;
import com.sameer.fullstack.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;
    public Course createCourse(Course course){
        return repository.save(course);
    }

    public List<Course> getCourses() {
        return repository.findAll();
    }
}
