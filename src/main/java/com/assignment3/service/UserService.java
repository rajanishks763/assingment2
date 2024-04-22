package com.assignment3.service;

import com.assignment3.payload.NotesDto;
import com.assignment3.payload.UserResponse;

public interface UserService {

	String loginByUserIdAndPassword(String email, String mobile);

	UserResponse userDetails(String userId, String password);

	String createNotesOnSkills(NotesDto notesDto);

	void logoutUser(String email);

}
