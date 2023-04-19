package com.aurionpro.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aurionpro.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentRepositoryImpl implements IStudentRepository{

	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Student> findAllStudent() {
		TypedQuery<Student> query = entityManager.createQuery("select e from Student e",Student.class);
		List<Student>resultList = query.getResultList();
		
		return resultList;
	}

	@Override
	public Student findById(int id) {
		Student student = entityManager.find(Student.class,id);
		
		return student;
	}

	@Override				
	public Student saveStudent(Student student) {
		return	entityManager.merge(student);
		
	}

	@Override
	public void deleteStudent(int id) {
		Student student = entityManager.find(Student.class, id);
		 entityManager.remove(student);
		  
	}

}
