package com.yash.fooddeliverysystem.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.yash.fooddeliverysystem.model.Category;
import com.yash.fooddeliverysystem.repository.CategoryRepository;
import com.yash.fooddeliverysystem.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository categoryRepo;

	

	@Override
	public List<Category> list() {
		
		return null;
	}

	@Override
	public boolean add(Category category) {
		
		return false;
	}

	@Override
	public boolean update(Category category) {
		
		return false;
	}

	@Override
	public boolean delete(Category category) {
		
		return false;
	}

	@Override
	public Optional<Category> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
