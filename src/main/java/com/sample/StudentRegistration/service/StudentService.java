package com.sample.StudentRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.StudentRegistration.domain.Student;
import com.sample.StudentRegistration.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	public List<Student> listAll(){
		return studentRepo.findAll();
	}
	
	public void save(Student student) {
		studentRepo.save(student);
	}
	
	public Student get(int id) {
		return studentRepo.findById(id).get();
	}
	
	public void delete(int id) {
		studentRepo.deleteById(id);
	}
}
