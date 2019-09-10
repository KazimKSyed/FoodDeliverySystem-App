package com.yash.fooddeliverysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.fooddeliverysystem.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
