package com.aurionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.course;

public interface CourseRepository extends JpaRepository<course, Long> {

}
