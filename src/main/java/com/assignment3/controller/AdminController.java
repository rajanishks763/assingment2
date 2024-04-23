package com.assignment3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment3.entity.User;
import com.assignment3.payload.UserDto;

import com.assignment3.service.AdminService;
//admin access
@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	
	@PostMapping("/saveUser")
	public String createOneUser(@RequestBody UserDto userDto) {
		return adminService.createOneUserDetails(userDto);
		
	}
	@PostMapping("/save")
	public String csave(@RequestBody UserDto userDto) {
		return "save";

	}
	
	@GetMapping("/allUsers")
	public List<UserDto> viewAllUsers(){
		
		return adminService.viewAllUsersDetails();
	}
	
	@GetMapping("/oneUser")
	public ResponseEntity<?> viewOneUser(@RequestParam("id")long id) {
	
    List<User> lists = adminService.viewUserDetailsById(id);
    if (lists.isEmpty()) {
        String errorMessage = "User with ID "+ id +" not found";
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<List<User>>(lists,HttpStatus.ACCEPTED);
	}	
	
}
