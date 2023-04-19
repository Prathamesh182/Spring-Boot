package com.aurionpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Student;
import com.aurionpro.exception.NoStudentRecordFoundException;
import com.aurionpro.exception.StudentErrorResponse;
import com.aurionpro.exception.StudentNotFoundException;
import com.aurionpro.repository.IStudentRepository;

import com.aurionpro.service.IStudentService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/studentapp")
public class StudentController {
	
	@Autowired
	public IStudentService service;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> findAllStudents(){
		
		List<Student> studentList = service.findAll();
		studentList=new  ArrayList<Student>();
		if(studentList.size()==0) {
			throw new NoStudentRecordFoundException("No Record Was Found");
		}
		
		
		return new ResponseEntity<>(studentList,HttpStatus.I_AM_A_TEAPOT);
		
	}
	
	@GetMapping("/students/{sid}")
	public ResponseEntity<Student >findStudentById(@PathVariable(name="sid")int id){
		Student student = service.findById(id);
		return new ResponseEntity<>(student,HttpStatus.CONFLICT);
				
		
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		student.setId(0);
		
		Student std = service.save(student);
		return new ResponseEntity<>(std,HttpStatus.ALREADY_REPORTED);
	}
	
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		Student stud = service.save(student);
		return  new ResponseEntity<>(stud,HttpStatus.IM_USED);
				
	}
	
	@DeleteMapping("/students/{sid}")
	public ResponseEntity<?> deleteStudent(@PathVariable(name="sid")int id) {
		service.deleteById(id);
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	
	@PostMapping("/students/all")
	public List<Student> saveAllStudents(@RequestBody List<Student> studentList){
		return service.saveAll(studentList);
	}
	


}
