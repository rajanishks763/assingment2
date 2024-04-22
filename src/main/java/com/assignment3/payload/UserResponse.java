package com.assignment3.payload;

import java.time.LocalDateTime;
import java.util.Date;

public class UserResponse {
    private String name;
    private LocalDateTime currentLoginDateTime;
    private LocalDateTime lastLoginDateTime;
    private String mobileNumber;
    private String email;
    private String primarySkillSet;
	
	public UserResponse(String name, LocalDateTime currentLoginDateTime, LocalDateTime lastLoginDateTime,
			String mobileNumber, String email, String primarySkillSet) {
		super();
		this.name = name;
		this.currentLoginDateTime = currentLoginDateTime;
		this.lastLoginDateTime = lastLoginDateTime;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.primarySkillSet = primarySkillSet;
	}
	public UserResponse() {
		super();
	}
	
	@Override
	public String toString() {
		return "UserResponse [name=" + name + ", currentLoginDateTime=" + currentLoginDateTime + ", lastLoginDateTime="
				+ lastLoginDateTime + ", mobileNumber=" + mobileNumber + ", email=" + email + ", primarySkillSet="
				+ primarySkillSet + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getCurrentLoginDateTime() {
		return currentLoginDateTime;
	}
	public void setCurrentLoginDateTime(LocalDateTime currentLoginDateTime) {
		this.currentLoginDateTime = currentLoginDateTime;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPrimarySkillSet() {
		return primarySkillSet;
	}
	public void setPrimarySkillSet(String primarySkillSet) {
		this.primarySkillSet = primarySkillSet;
	}
	public LocalDateTime getLastLoginDateTime() {
		return lastLoginDateTime;
	}
	public void setLastLoginDateTime(LocalDateTime lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}
	
    
}