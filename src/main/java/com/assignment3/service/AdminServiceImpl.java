package com.assignment3.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment3.entity.User;
import com.assignment3.payload.UserDto;
import com.assignment3.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public String createOneUserDetails(UserDto userDto) {
		User user=new User();
		
		if(!userRepo.findByEmail(userDto.getEmail()).isPresent())
		{
			
			
		user.setEmail(userDto.getEmail());
		user.setMobile(userDto.getMobile());
		user.setName(userDto.getName());
		user.setRole(userDto.getSkills());
		
		userRepo.save(user);
		
		return "User successfully created";
		
		}else {
			return "user is already exist";
		}
	}

	@Override
	public List<UserDto> viewAllUsersDetails() {
		List<User> users = userRepo.findAll();
		
		List<UserDto> userList=new ArrayList<>();
		for (User user1 : users) {
			UserDto userDto=new UserDto();
		userDto.setEmail(user1.getEmail());
		userDto.setMobile(user1.getMobile());
		userDto.setName(user1.getName());
		userDto.setRole(user1.getSkills());
		
		userList.add(userDto);
		}
		
		return userList;
	}


	@Override
	public List<User> viewUserDetailsById(long id) {
				
			List<User> user = userRepo.findByUserId(id).get();
			
		return user;
		
	
	}
}
