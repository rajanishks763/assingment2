package com.assignment3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name = "email")
	private String email;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "name")
	private String name;
	@Column(name = "skills")
	private String skills;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSkills() {
		return skills;
	}
	public void setRole(String skills) {
		this.skills = skills;
	}
	public User(String email, String mobile, String name, String skills) {
		super();
		this.email = email;
		this.mobile = mobile;
		this.name = name;
		this.skills = skills;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", mobile=" + mobile + ", name=" + name + ", skills=" + skills + "]";
	}
	
}
