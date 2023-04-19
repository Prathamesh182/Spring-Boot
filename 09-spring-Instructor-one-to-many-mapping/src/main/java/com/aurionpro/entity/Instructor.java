package com.aurionpro.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Transactional
@Table(name="instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="instructor_id")
	private Long id;
	private String name;
	private String email;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_instructor_id")
	private InstructorDetails instructorDetails; 
	public Instructor() {
	}
	
	@OneToMany(cascade= {CascadeType.ALL,CascadeType.DETACH,CascadeType.MERGE,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="fk_course_id", referencedColumnName = "instructor_id")
	private List<Course> courses;
	public Instructor(Long id, String name, String email, InstructorDetails instructorDetails) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.instructorDetails = instructorDetails;
		
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public InstructorDetails getInstructorDetails() {
		return instructorDetails;
	}
	public void setInstructorDetails(InstructorDetails instructorDetails) {
		this.instructorDetails = instructorDetails;
	}
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", email=" + email   + ", courses="
				+ courses + "]";
	}
	
	
	

}
