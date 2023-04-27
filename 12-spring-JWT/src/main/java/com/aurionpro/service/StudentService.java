package com.aurionpro.service;

import java.util.List;

import com.aurionpro.entity.Student;

public interface StudentService {
	
	List<Student> findAll();

	Student findById(int id);

	Student save(Student student);

//	Student updateStudent(Student student);

	void deleteById(int id);

	List<Student> saveAll(List<Student> studentList);

	List<Student> findByFirstName(String name);

	List<Student> findByEmail(String name);



}