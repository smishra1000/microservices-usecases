package com.sameer.fullstack.repository;

import com.sameer.fullstack.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
