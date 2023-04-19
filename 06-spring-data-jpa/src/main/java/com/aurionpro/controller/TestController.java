package com.aurionpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/test")
public class TestController {
	
	List<Student> studentList =new ArrayList<Student>();
	@PostConstruct
	public void init() {
		studentList.add(new Student(1,"Ajay","Pal","pal@gmail.com"));
		studentList.add(new Student(2,"Vijay","Pal","val@gmail.com"));
		studentList.add(new Student(3,"Sujay","Pal","sal@gmail.com"));
		studentList.add(new Student(4,"Dinesh","Pal","dal@gmail.com"));
	}
	
	@GetMapping("/students")
	public List<Student> findAllStudents(){
		return studentList;
	}
	
	@GetMapping("/students/{studID}")
	public Student findStudentById(@PathVariable(name="studID")int id){
		for(Student x:studentList) {
			if(x.getId()==id) {
				return x;
			}
		}
		
		
		return null;
		
	}
//	@GetMapping("/hello")
//	public String showMessage() {
//		return "Hello All Student";
//	}
//	
//	@GetMapping("/welcome")
//	public String showWelcome() {
//		return "Welcome All Student";
//	}
}
