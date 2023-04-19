package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Student;
import com.aurionpro.exception.StudentNotFoundException;
import com.aurionpro.repository.IStudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements IStudentService{

	
	@Autowired
	private IStudentRepository repository;
	
	@Override
	public List<Student> findAll() {
		return repository.findAll();
	}

	@Override
	public Student findById(int id) {
		List<Student> studentList = repository.findAll();
		boolean flag=false;
		for(Student x:studentList) {
			if(x.getId()==id) {
				flag=true;
				break;
			}
		}
			if(flag) {
				return repository.findById(id).get();
			}
			else {
				throw new StudentNotFoundException("STudent with id "+id+ " not found");
			}
		}
		
	

	@Override
	@Transactional
	public Student save(Student student) {
		return repository.save(student);
	}

//	@Override
//	@Transactional
//	public Student updateStudent(Student student) {
//		return repository.saveStudent(student);
//	}

	@Override
	@Transactional
	public void deleteById(int id) {
		repository.deleteById(id);
	}

@Override
public List<Student> saveAll(List<Student> studentList) {
	return repository.saveAll(studentList);
}

	
}
