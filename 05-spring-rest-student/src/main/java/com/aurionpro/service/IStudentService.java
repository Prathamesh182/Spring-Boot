package com.aurionpro.service;

import java.util.List;

import com.aurionpro.entity.Student;

public interface IStudentService {

	List<Student> findAllStudent();

	Student findStudentById(int id);

	Student saveStudent(Student student);

	Student updateStudent(Student student);

	void deleteStudent(int id);

	
}
