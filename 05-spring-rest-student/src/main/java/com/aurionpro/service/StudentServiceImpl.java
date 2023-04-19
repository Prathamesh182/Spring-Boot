package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Student;
import com.aurionpro.repository.IStudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements IStudentService{

	
	@Autowired
	private IStudentRepository repository;
	
	@Override
	public List<Student> findAllStudent() {
		return repository.findAllStudent();
	}

	@Override
	public Student findStudentById(int id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Student saveStudent(Student student) {
		return repository.saveStudent(student);
	}

	@Override
	@Transactional
	public Student updateStudent(Student student) {
		return repository.saveStudent(student);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		repository.deleteStudent(id);
	}

}
