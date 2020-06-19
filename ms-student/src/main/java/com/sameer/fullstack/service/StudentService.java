package com.sameer.fullstack.service;

import com.sameer.fullstack.common.Course;
import com.sameer.fullstack.common.StudentCourseRequest;
import com.sameer.fullstack.common.StudentCourseResponse;
import com.sameer.fullstack.entity.Student;
import com.sameer.fullstack.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RefreshScope
public class StudentService {
    @Autowired
    private StudentRepository repository;
    @Autowired
    @Lazy
    private RestTemplate template;
    @Value("${micorservices.course-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;

    public StudentCourseResponse createStudent(StudentCourseRequest request){
        Course course = request.getCourse();
        Course CourseResponse  = template.postForObject(ENDPOINT_URL,course,Course.class);
        Student student = request.getStudent();
         repository.save(student);
         return new StudentCourseResponse(student,CourseResponse);
    }

    public Optional<Student> getStudentDetailsById(int studentId) {
        return repository.findById(studentId);
    }

    public List<Student> getAllStudent() {
        return repository.findAll();
    }
}
