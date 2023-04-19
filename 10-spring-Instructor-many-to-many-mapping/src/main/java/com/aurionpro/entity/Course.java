package com.aurionpro.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Transactional
@Table(name="courseTB")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_id")
	private Long id;
	private String name;
	private String duration;
	
	
	public Course() {
	}


	public Course(Long id, String name, String duration) {
		this.id = id;
		this.name = name;
		this.duration = duration;
	}

	@ManyToMany(mappedBy = "courses")
	@JsonIgnore
	private List<Student> student;
	
	
	public List<Student> getStudent() {
		return student;
	}


	public void setStudent(List<Student> student) {
		this.student = student;
	}


	public Long getId() {
		return id;
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
