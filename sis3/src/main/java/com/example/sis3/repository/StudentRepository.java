package com.example.sis3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sis3.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCourse(int course);

    List<Student> findByLastnameContaining(String lastname);
}