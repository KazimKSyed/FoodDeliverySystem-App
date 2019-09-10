package com.yash.fooddeliverysystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yash.fooddeliverysystem.model.Category;

@Service
public interface CategoryService {
	Optional<Category> getById(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);

}
