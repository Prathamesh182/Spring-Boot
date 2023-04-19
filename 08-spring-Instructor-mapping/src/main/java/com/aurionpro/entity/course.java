package com.aurionpro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Transactional
@Table(name = "instructor_db")

public class course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid")
	private Long id;

	private String cName;
	private String cDuration;

	public course() {
	}

	public course(Long id, String cName, String cDuration) {
		this.id = id;
		this.cName = cName;
		this.cDuration = cDuration;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcDuration() {
		return cDuration;
	}

	public void setcDuration(String cDuration) {
		this.cDuration = cDuration;
	}

	@Override
	public String toString() {
		return "course [id=" + id + ", cName=" + cName + ", cDuration=" + cDuration + "]";
	}

}
