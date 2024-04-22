package com.assignment3.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginDetails {

	@Id
	private String email;
	@Column(name="lastLoginDateTime")
	private LocalDateTime lastLoginDateTime;
	public LoginDetails(String email, LocalDateTime lastLoginDateTime) {
		super();
		this.email = email;
		this.lastLoginDateTime = lastLoginDateTime;
	}
	public LoginDetails() {
		super();
	}
	@Override
	public String toString() {
		return "LoginDetails [email=" + email + ", lastLoginDateTime=" + lastLoginDateTime + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getLastLoginDateTime() {
		return lastLoginDateTime;
	}
	public void setLastLoginDateTime(LocalDateTime lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}
	
	
}
