package com.assignment3.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment3.entity.LogOutEntity;
import com.assignment3.entity.LoginAttempt;
import com.assignment3.entity.LoginDetails;
import com.assignment3.entity.Notes;
import com.assignment3.entity.User;
import com.assignment3.payload.NotesDto;
import com.assignment3.payload.UserResponse;
import com.assignment3.repository.LogOutRepository;
import com.assignment3.repository.LoginAttemptRepository;
import com.assignment3.repository.LoginDetailsRepository;
import com.assignment3.repository.NotesRepository;
import com.assignment3.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	 @Autowired
	    private NotesRepository noteRepo;
	 @Autowired
		private UserRepository userRepo;
	 @Autowired
	    private LoginDetailsRepository loginDetailsRepo;
	 @Autowired 
	    private LoginAttemptRepository loginAttemptRepo;
	 @Autowired
	    private LogOutRepository logoutRepo;
	    
	
	@Override
	public String loginByUserIdAndPassword(String email, String mobile) {
		Optional<User> user1 = userRepo.findByEmail(email);
		if(user1.isPresent()) {
			User user2 = user1.get();
	
	    	if (user2 != null && user2.getMobile().equals(mobile)) {
	    		LoginDetails loginDetails=new LoginDetails();
	    		
	    		loginDetails.setEmail(email);
	    		loginDetails.setLastLoginDateTime(LocalDateTime.now());
	    		
	    		loginDetailsRepo.save(loginDetails);
	            return "User login succsseful";
	        }
	    		else {
	    			
	    			  LoginAttempt loginAttempt = new LoginAttempt();
	    			  
	    			  loginAttempt.setEmail(email);
	    			  loginAttempt.setAttemptTime(LocalDateTime.now());
	    			  
	    			  loginAttemptRepo.save(loginAttempt);
	    			  
	    			  List<LoginAttempt> records = loginAttemptRepo.findByEmail(email);
	    			  if(records.stream().count()>3) {
	    				  
	    				  return "You are blocked";
	    			  }		    			  
	    	          return "Enter Incorrect Password";
	             }
		}else {
			
			return "Invalid UserID";
		}

}

	@Override
	public UserResponse userDetails(String userId, String password) {
		Optional<User> user1 = userRepo.findByEmail(userId);
    	if(user1.isPresent()) {
    	User user2 = user1.get();
    	
      	if (user1 != null && user2.getMobile().equals(password)) {  		
    	
    	UserResponse response = new UserResponse();
    	response.setEmail(user2.getEmail());
    	response.setMobileNumber(user2.getMobile());
    	response.setCurrentLoginDateTime(LocalDateTime.now());
    	response.setName(user2.getName());
    	response.setPrimarySkillSet(user2.getSkills());
    	
    	
    	
    	Optional<LoginDetails> findByEmail = loginDetailsRepo.findByEmail(userId);
    	LoginDetails loginDetails = findByEmail.get();
    	 	
    	response.setLastLoginDateTime(loginDetails.getLastLoginDateTime());
    	
    	loginDetails.setLastLoginDateTime(response.getCurrentLoginDateTime());
    	loginDetailsRepo.save(loginDetails);
    	
  
        return response;
        
        }
      	throw new IllegalArgumentException("Incorrect password");
        
    	}else {
    		throw new IllegalArgumentException("User Id is Not Valid");
    	}
    }

	@Override
	public String createNotesOnSkills(NotesDto notesDto) {
		Optional<User> user1 = userRepo.findByEmail(notesDto.getEmail());
		
		if (user1.isPresent()) {
	        User user = user1.get();
	        Notes note = new Notes();
	        note.setContent(notesDto.getContent());
	        note.setEmail(notesDto.getEmail());
	        note.setSkills(user.getSkills());
	        noteRepo.save(note);
	        return "Notes added successfully.";
		}else {
		return "email id is not valid";
		}
	}

	@Override
	public void logoutUser(String email) {
		LogOutEntity logoutEntity=new LogOutEntity();
    	logoutEntity.setEmail(email);
    	logoutEntity.setLogoutTime(LocalDateTime.now());
    	logoutRepo.save(logoutEntity);
		
	}
}
