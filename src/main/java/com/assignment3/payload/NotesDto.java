package com.assignment3.payload;

public class NotesDto {

	private String email;
	private String content;
	public NotesDto(String email, String content) {
		super();
		this.email = email;
		this.content = content;
	}
	public NotesDto() {
		super();
	}
	@Override
	public String toString() {
		return "NotesDto [email=" + email + ", content=" + content + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
