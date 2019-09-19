package com.yash.fooddeliverysystem.service;



import com.yash.fooddeliverysystem.model.User;

public interface UserService {
 public User saveUser(User user);
 public Iterable<User> getUserList();
}
