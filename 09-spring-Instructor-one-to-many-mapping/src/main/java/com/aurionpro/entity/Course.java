package com.aurionpro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Transactional
@Table(name = "course")
public class Course {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "course_id")
 private Long id;
 private String name;
 private String duration;

 
 
 public Course() {
  super();
 }

 public Course(Long id, String name, String duration) {
  super();
  this.id = id;
  this.name = name;
  this.duration = duration;
 }
 
 @ManyToOne(fetch=FetchType.EAGER)
 @JoinColumn(name="fk_course_id")
 @JsonIgnore
 private Instructor instructor;

 public Long getId() {
  return id;
 }

 public Instructor getInstructor() {
	return instructor;
}

public void setInstructor(Instructor instructor) {
	this.instructor = instructor;
}

public Course(Instructor instructor) {
	this.instructor = instructor;
}

public void setId(Long id) {
  this.id = id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getDuration() {
  return duration;
 }

 public void setDuration(String duration) {
  this.duration = duration;
 }

 @Override
 public String toString() {
  return "Course [id=" + id + ", name=" + name + ", duration=" + duration + "]";
 }

}
