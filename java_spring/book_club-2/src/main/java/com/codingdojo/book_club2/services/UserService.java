package com.codingdojo.book_club2.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.book_club2.models.LoginUser;
import com.codingdojo.book_club2.models.User;
import com.codingdojo.book_club2.repositories.UserRepository;

@Service
public class UserService {
// CRUD
	@Autowired
	private UserRepository userRepo;
// REGISTER
	public User register(User newUser, BindingResult result) {
//    	Reject if the email is taken (present in the database)
    	Optional<User> potentialUser =  userRepo.findByEmail(newUser.getEmail());
    	if (potentialUser.isPresent()) {
    		result.rejectValue("email", "registerErrors", "This email is taken");
    	}
//    	Reject if passwords don't match with confirm
    	if (!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "registerErrors", "this confirm pass must match the pass");
    	}
    	
//    	Return null if result has errors
    	if (result.hasErrors()) {
    		return null;
    	} else {
//    		Hash and set password, save user to the DB!
    		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    		newUser.setPassword(hashed);
//    		SAVE USER TO THE DB!!!!
    		return userRepo.save(newUser);
    	}
   
    }
// LOGIN
	public User login(LoginUser newLoginObject, BindingResult result) {
//    	FIND THE USER IN THE DB
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    	if (!potentialUser.isPresent()) {
    		result.rejectValue("email", "loginError", "email not found");
    	} else {
    		
    		User user = potentialUser.get();
//    	Reject if BCrypt pass match fails
    		if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
//    		Reject
    			result.rejectValue("password", "loginError", "invalid password");
    		}
//    	return null if result has errors
    		if (result.hasErrors()) {
    			return null;
    		} else {
//    		otherwise, return the user object
    			return user;
    		}
    	}
    	
    	return null;
	}
	
// FIND ONE
	  public User findOne(Long id) {
		  	Optional<User> potentialUser = userRepo.findById(id);
		  	if (potentialUser.isPresent()) {
		  		return potentialUser.get();
		  	} else {
		  		return null;
		  	}
		  }
}
