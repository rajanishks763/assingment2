package com.assignment3.entity;

import javax.persistence.*;

@Entity
@Table(name="Notes")
public class Notes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long contentId;
	@Column(name = "email")
	private String email;
	
	@Column(name = "skills")
	private String skills;
	
	@Column(name = "content",length = 250)
	private String content;
	
	
	
	public Notes(Long contentId, String email, String skills, String content) {
		super();
		this.contentId = contentId;
		this.email = email;
		this.skills = skills;
		this.content = content;
	}
	public Notes() {
		super();
	}
	@Override
	public String toString() {
		return "Notes [contentId=" + contentId + ", email=" + email + ", skills=" + skills + ", content=" + content
				+ "]";
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public Long getContentId() {
		return contentId;
	}
	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}
	
	

}
