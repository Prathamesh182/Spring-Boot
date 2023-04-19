package com.aurionpro.dao;

import java.util.List;

import com.aurionpro.entity.Student;

public interface StudentDao {
	Student save(Student student);

	Student findById(int id);

	List<Student> findAll();

	

	List<Student> findStudentByFirstName(String firstName);

	List<Student> findByEmail(String email);

	void update(Student student);

	void deleteStudentById(int id);

	void deleteAll();

	
}
