package com.yash.fooddeliverysystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yash.fooddeliverysystem.model.User;

public interface UserRepository extends CrudRepository<User,Integer> {

}
