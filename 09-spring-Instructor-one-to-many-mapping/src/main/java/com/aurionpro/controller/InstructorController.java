package com.aurionpro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Course;
import com.aurionpro.entity.Instructor;
import com.aurionpro.entity.InstructorDetails;
import com.aurionpro.repository.CourseRepository;
import com.aurionpro.repository.InstructorDetailsRepository;
import com.aurionpro.repository.InstructorRepository;

@RestController
public class InstructorController {
	@Autowired
	private InstructorRepository insRepo;
	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private InstructorDetailsRepository insDetailsRepo;
	
	@PostMapping("/saveInstructor")
	public ResponseEntity<String> saveInstructor(@RequestBody List<Instructor> insData){
		insRepo.saveAll(insData);
		return ResponseEntity.ok("Data Saved");
	}
	
	@PutMapping("/updateInstructor/{instructor_id}/detailId/{detail_id}")
	public ResponseEntity<String> UpdateInstructor(@PathVariable Long instructor_id,@PathVariable Long detail_id){
			Instructor instructor = insRepo.findById(instructor_id).get();
			InstructorDetails instructorDetails = insDetailsRepo.findById(detail_id).get();
			instructor.setInstructorDetails(instructorDetails);
			insRepo.save(instructor);
			return ResponseEntity.ok("Instructor Data updated");
	 }
	@DeleteMapping("/deleteinstructor/{instructor_id}")
	public ResponseEntity<String> deleteInstructor(@PathVariable Long instructor_id){
		insRepo.deleteById(instructor_id);
		return ResponseEntity.ok("Data Deleted");
	}
	@GetMapping("/getCoursebyInstructorId/{instructor_id}")
	public List<Course> showCourse(@PathVariable Long instructor_id){
		Instructor instructor = insRepo.findById(instructor_id).get();
		return instructor.getCourses();
	}
	@GetMapping("/getInstructorByCourseId/{course_id}")
	public Instructor showInstructor(@PathVariable Long course_id){
		Course course = courseRepo.findById(course_id).get();
		Instructor instructor= course.getInstructor();
		 return instructor;
	}

	
}
	

