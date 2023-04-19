package com.aurionpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Student;
import com.aurionpro.repository.IStudentRepository;
import com.aurionpro.repository.StudentRepositoryImpl;
import com.aurionpro.service.IStudentService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/studentapp")
public class StudentController {
	
	@Autowired
	public IStudentService service;
	
	@GetMapping("/students")
	public List<Student> findAllStudents(){
		return service.findAllStudent();
		
	}
	
	@GetMapping("/students/{sid}")
	public Student findStudentById(@PathVariable(name="sid")int id){
		return service.findStudentById(id);
		
	}
	
	@PostMapping("/students")
	public Student saveStudent(@RequestBody Student student) {
		student.setId(0);
		return service.saveStudent(student);
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}
	
	@DeleteMapping("/students/{sid}")
	public void deleteStudent(@PathVariable(name="sid")int id) {
		service.deleteStudent(id);
	}
	
	
	
	

}
