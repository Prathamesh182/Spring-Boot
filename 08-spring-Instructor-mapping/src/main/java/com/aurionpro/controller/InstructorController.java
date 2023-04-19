package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Instructor;
import com.aurionpro.repository.InstructorRepository;



@RestController
public class InstructorController {
	
	@Autowired
	private InstructorRepository insRepository;
	
	@PostMapping("/saveInstructor")
	public ResponseEntity<String> saveInstructor(@RequestBody List<Instructor> insData){
		insRepository.saveAll(insData);
		return ResponseEntity.ok("Data saved");
	}
}

//	@PutMapping("/updateInstrutor/{instructor_id}/detailId{detail_id}")
//	public Instructor updateInstructor
	
	