package com.sameer.fullstack.common;

import com.sameer.fullstack.entity.Student;

public class StudentCourseResponse {

    private Student student;
    private Course course;

    public StudentCourseResponse(){

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public StudentCourseResponse(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
}
