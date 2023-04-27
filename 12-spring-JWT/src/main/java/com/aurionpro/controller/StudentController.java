package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Student;
import com.aurionpro.service.StudentService;


@RestController
@RequestMapping("/studentapp")
@CrossOrigin("*")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Student> findAllStudents(){
		return studentService.findAll();
	}
	
	@GetMapping("/students/{sid}")
	public Student findStudent(@PathVariable(name="sid")int id){
		return studentService.findById(id);
	}
	
	@GetMapping("/students/byname")
	public List<Student> findStudentByFirstName(@RequestParam String name) {
		return studentService.findByFirstName(name);
	}
	
	@GetMapping("/students/byemail")
	public List<Student> findStudentByEmail(@RequestParam String name) {
		return studentService.findByEmail(name);
	}
	
	@PostMapping("/students")
	public Student saveStudent(@RequestBody Student student) {
		student.setId(0);
		return studentService.save(student);
	}
	
	@PostMapping("/students/all")
	public List<Student> saveStudent(@RequestBody List<Student> studentList) {
		return studentService.saveAll(studentList);
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.save(student);
	}
	
	@DeleteMapping("/students/{sid}")
	public void deleteStudent(@PathVariable(name="sid")int id){
		studentService.deleteById(id);
	}
	
}