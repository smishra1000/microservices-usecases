package com.sameer.fullstack.repository;

import com.sameer.fullstack.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
