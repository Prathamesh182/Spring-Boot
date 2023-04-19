package com.aurionpro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Course;
import com.aurionpro.entity.Student;
import com.aurionpro.repository.CourseRepository;
import com.aurionpro.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	public StudentRepository studentRepo;
	
	@Autowired
	public CourseRepository courseRepo;
	
	@PostMapping("/saveStudent")
	public ResponseEntity<String> saveStudent(@RequestBody List<Student> insData){
		studentRepo.saveAll(insData);
		return ResponseEntity.ok("Data Saved");
	}
	
	@PostMapping("/savecourse")
	public ResponseEntity<String> saveCourse(@RequestBody List<Course> insCourse){
		courseRepo.saveAll(insCourse);
		return ResponseEntity.ok("Course Saved");
	}
	
	@PutMapping("/student/{student_id}/course/{course_id}")
	public ResponseEntity<String> UpdateStudent(@PathVariable Long student_id,@PathVariable Long course_id){
		Student student = studentRepo.findById(student_id).get();
		List<Course> courses = student.getCourses();
		Course course = courseRepo.findById(course_id).get();
		courses.add(course);
		student.setCourses(courses);
		studentRepo.save(student);
		return ResponseEntity.ok("Data Saved");
	}
	
	@DeleteMapping("/deletemapping/{student_id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long student_id){
		studentRepo.deleteById(student_id);
		return ResponseEntity.ok("Data Deleted");
	}




}
