package com.assignment3.service;

import java.util.List;

import com.assignment3.entity.User;
import com.assignment3.payload.UserDto;

public interface AdminService {

	String createOneUserDetails(UserDto userDto);

	List<UserDto> viewAllUsersDetails();

	List<User> viewUserDetailsById(long id);

}
