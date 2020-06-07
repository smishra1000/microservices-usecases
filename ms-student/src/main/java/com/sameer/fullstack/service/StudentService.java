package com.sameer.fullstack.service;

import com.sameer.fullstack.common.Course;
import com.sameer.fullstack.common.StudentCourseRequest;
import com.sameer.fullstack.common.StudentCourseResponse;
import com.sameer.fullstack.entity.Student;
import com.sameer.fullstack.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private RestTemplate template;

    public StudentCourseResponse createStudent(StudentCourseRequest request){
        Course course = request.getCourse();
        Course CourseResponse  = template.postForObject("http://COURSE-SERVICE/course/createCourse",course,Course.class);
        Student student = request.getStudent();
         repository.save(student);
         return new StudentCourseResponse(student,CourseResponse);
    }

    public Optional<Student> getStudentDetailsById(int studentId) {
        return repository.findById(studentId);
    }
}
