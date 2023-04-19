package com.aurionpro.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aurionpro.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository//it will create bean 
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private EntityManager manager;
	
	@Override
	@Transactional
	public Student save(Student student) {
		 manager.persist(student);//for saving the object in DB
		 return manager.find(Student.class, student.getId());
	}

	@Override
	public Student findById(int id) {
		return manager.find(Student.class,id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student>query=manager.createQuery("select e from Student e",Student.class);
		return query.getResultList();
	}

	@Override
	public List<Student> findStudentByFirstName(String firstName) {
		TypedQuery<Student>query=manager.createQuery("select e from Student e where e.firstName=:theFirstName",Student.class);
		query.setParameter("theFirstName", firstName);
		return query.getResultList();
	}

	@Override
	public List<Student> findByEmail(String email) {
		TypedQuery<Student>query=manager.createQuery("select e from Student e where e.email=:theEmail",Student.class);
		query.setParameter("theEmail", email);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void update(Student student) {
		Student student1= manager.merge(student);
		System.out.println(student1);
		//		TypedQuery<Student>query=manager.createQuery("update Student set firstName=:theFirstName, lastName=:theLastName, email=:theEmail where id=:theId ",Student.class);
//		query.setParameter("theFirstName", student.getFirstName());	
//		query.setParameter("theLastName", student.getLastName());
//		query.setParameter("theEmail", student.getEmail());
//		query.setParameter("theId", student.getId());
		
		
	}

	@Override
	@Transactional
	public  void deleteStudentById(int id) {
		Student temp= manager.find(Student.class, id);
		manager.remove(temp);
		
	}

	@Override
	@Transactional
	public Object deleteAll() {
		int rows= manager.createQuery("delete from Student").executeUpdate();
		return System.out.println(rows);
	}

	

}
