package com.assignment3.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="LogoutDetails")
public class LogOutEntity {

	@Id
	
	@Column(name="email")
	private String email;
	
	@Column(name = "logoutTime")
	private LocalDateTime logoutTime;

	public LogOutEntity(String email, LocalDateTime logoutTime) {
		super();
		
		this.email = email;
		this.logoutTime = logoutTime;
	}

	public LogOutEntity() {
		super();
	}

	@Override
	public String toString() {
		return "LogOutEntity [email=" + email + ", logoutTime=" + logoutTime + "]";
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(LocalDateTime logoutTime) {
		this.logoutTime = logoutTime;
	}
	
	
}
