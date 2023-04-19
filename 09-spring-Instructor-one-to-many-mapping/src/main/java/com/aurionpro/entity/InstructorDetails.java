package com.aurionpro.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Transactional
@Table(name="instructor_details")
public class InstructorDetails {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Details_id")
	
	
	
	private Long DeId;
	private String youtubeChannel;
	private String gitUrl;
	
	@OneToOne(mappedBy = "instructorDetails")
	private Instructor instructor;
	public InstructorDetails() {
	}

	public Long getDeId() {
		return DeId;
	}

	public void setDeId(Long deId) {
		DeId = deId;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getGitUrl() {
		return gitUrl;
	}

	public void setGitUrl(String gitUrl) {
		this.gitUrl = gitUrl;
	}

	@Override
	public String toString() {
		return "InstructorDetails [DeId=" + DeId + ", youtubeChannel=" + youtubeChannel + ", gitUrl=" + gitUrl + "]";
	}
	
	
}
