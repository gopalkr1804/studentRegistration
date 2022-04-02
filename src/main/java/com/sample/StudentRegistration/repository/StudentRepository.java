package com.sample.StudentRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.StudentRegistration.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
