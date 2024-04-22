package com.assignment3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment3.payload.NotesDto;
import com.assignment3.payload.UserLoginRequest;
import com.assignment3.payload.UserResponse;
import com.assignment3.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserDetailController {
	
	@Autowired
	private UserService userService;
    
    @PostMapping("/login")
    public String userLogin(@RequestBody UserLoginRequest user) {
    	
    	String email = user.getUserId();
    	String mobile = user.getPassword();
    	String loginByUserIdAndPassword = userService.loginByUserIdAndPassword(email,mobile);
    	return loginByUserIdAndPassword;
    		
    }
    
    @GetMapping("/login/userDetails")
    public ResponseEntity<?> userDetails(@RequestBody UserLoginRequest user) {
    	
    	String userId = user.getUserId();
    	String password = user.getPassword();
    	
    	if(userId.isEmpty()||password.isEmpty()) {
    		String str="null userId or password";
    		return new ResponseEntity<>(str,HttpStatus.NOT_FOUND);
    	}
    	UserResponse userDetails = userService.userDetails(userId,password);
    	return new ResponseEntity<>(userDetails,HttpStatus.ACCEPTED);
    }

    @PostMapping("/submit")
    public String addNotes(@RequestBody NotesDto notesDto) {
    	
    return userService.createNotesOnSkills(notesDto); 
        
    }

    @GetMapping("/logout")
    public String userLogout(@RequestParam String email) {
    		userService.logoutUser(email);
       
    	return "Logout Successfull";
    }
}
