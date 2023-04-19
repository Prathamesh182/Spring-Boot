package com.aurionpro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.Student;

public interface IStudentRepository extends JpaRepository<Student,Integer>{
	

	
}
