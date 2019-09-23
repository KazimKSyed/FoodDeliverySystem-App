package com.yash.fooddeliverysystem.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.fooddeliverysystem.model.User;
import com.yash.fooddeliverysystem.repository.UserRepository;
import com.yash.fooddeliverysystem.service.UserService;
@Service()
public class UserServiceImpl implements UserService{
 @Autowired
 UserRepository userRepo;
	
	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public Iterable<User> getUserList() {
		
		return userRepo.findAll();
	}

	@Override
	public User findByEmailAndPassword(String email, String password) {
		
		return userRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public void deleteUser(int id) {
		userRepo.deleteById(id);
		
	}

	

	
}
