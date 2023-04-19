package com.aurionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>  {

}
