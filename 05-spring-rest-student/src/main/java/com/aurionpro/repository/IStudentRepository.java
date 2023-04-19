package com.aurionpro.repository;

import java.util.List;

import com.aurionpro.entity.Student;

public interface IStudentRepository {
	List<Student> findAllStudent();

	Student findById(int id);

	Student saveStudent(Student student);

	void deleteStudent(int id);

	
}
