package com.aurionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

}
