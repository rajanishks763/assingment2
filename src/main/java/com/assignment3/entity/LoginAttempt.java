package com.assignment3.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LoginAttempt")
public class LoginAttempt {
	
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long attempt;
	
	private String email;
	private LocalDateTime attemptTime;
	
	
	public LoginAttempt(long attempt, String email, LocalDateTime attemptTime) {
		super();
		this.attempt = attempt;
		this.email = email;
		this.attemptTime = attemptTime;
	}
	public LoginAttempt() {
		super();
	}
	@Override
	public String toString() {
		return "LoginAttempt [attempt=" + attempt + ", email=" + email + ", attemptTime=" + attemptTime + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getAttempt() {
		return attempt;
	}
	public void setAttempt(long attempt) {
		this.attempt = attempt;
	}
	public LocalDateTime getAttemptTime() {
		return attemptTime;
	}
	public void setAttemptTime(LocalDateTime attemptTime) {
		this.attemptTime = attemptTime;
	}
}
