package com.aurionpro.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Transactional
@Table(name = "instructor_db")

public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "i_id")
	private Long iId;
	private String iName;
	private String email;

	// One to one mapping
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_add_id") // to have the custom column name
	private Instructor_details iDetailsS;

	public Instructor(Long iId, String iName, String email, Instructor_details iDetailsS) {
		super();
		this.iId = iId;
		this.iName = iName;
		this.email = email;
		this.iDetailsS = iDetailsS;
	}

	public Instructor() {
		super();
	}

	public Long getiId() {
		return iId;
	}

	public void setiId(Long iId) {
		this.iId = iId;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Instructor_details getiDetailsS() {
		return iDetailsS;
	}

	public void setiDetailsS(Instructor_details iDetailsS) {
		this.iDetailsS = iDetailsS;
	}

	@Override
	public String toString() {
		return "Instructor [iId=" + iId + ", iName=" + iName + ", email=" + email + ", iDetailsS=" + iDetailsS + "]";
	}

}