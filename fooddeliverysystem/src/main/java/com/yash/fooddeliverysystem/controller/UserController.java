package com.yash.fooddeliverysystem.controller;

import java.net.URI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yash.fooddeliverysystem.model.User;
import com.yash.fooddeliverysystem.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping(value="/user")
@CrossOrigin(origins ="http://localhost:4200")
public class UserController {
	@Autowired
	UserServiceImpl serviceImpl;

	@GetMapping(value="/")
	public Iterable<User> getAllUser(){
		return serviceImpl.getUserList();
	}
	
	@PostMapping(value="/")
	public ResponseEntity<Void> saveUser(@RequestBody User user){
		User createUser=serviceImpl.saveUser(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createUser.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value="/{email}/{password}")
	public ResponseEntity<User> login(@PathVariable("email") String email,@PathVariable("password") String password) {
		User user=serviceImpl.findByEmailAndPassword(email, password);
		System.out.println(user.getFirstName());
		if(user!=null ) {
			System.out.println("Log in Successfull...!");
			return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id){
		serviceImpl.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
}
