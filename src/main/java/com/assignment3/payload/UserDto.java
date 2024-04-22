package com.assignment3.payload;

import javax.persistence.Column;

public class UserDto {

	private String email;

	private String mobile;

	private String name;
	
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
	public UserDto(String email, String mobile, String name, String skills) {
		super();
		this.email = email;
		this.mobile = mobile;
		this.name = name;
		this.skills = skills;
	}
	public UserDto() {
		super();
	}
	@Override
	public String toString() {
		return "UserDto [email=" + email + ", mobile=" + mobile + ", name=" + name + ", skills=" + skills + "]";
	}
	
}
