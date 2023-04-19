package com.aurionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
