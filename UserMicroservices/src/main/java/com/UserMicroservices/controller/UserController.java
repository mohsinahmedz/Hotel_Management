package com.UserMicroservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserMicroservices.entities.User;
import com.UserMicroservices.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<User> createOneUser(@RequestBody User user){
		User createuser = userService.createuser(user);
		return new ResponseEntity<User>(createuser,HttpStatus.OK);
		
	}
	@GetMapping("/{userId}")
	public ResponseEntity<User> getOneUserDetails(@PathVariable String userId){
		User oneUser = userService.getOneUser(userId);
		return new ResponseEntity<User>(oneUser,HttpStatus.OK);
		
	}
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUser = userService.getAllUser();
		return new ResponseEntity<List<User>>(allUser,HttpStatus.OK);
	}

}
