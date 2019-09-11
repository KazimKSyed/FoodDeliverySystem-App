package com.yash.fooddeliverysystem.serviceImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.fooddeliverysystem.model.Category;
import com.yash.fooddeliverysystem.repository.CategoryRepository;
import com.yash.fooddeliverysystem.service.CategoryService;

@Service()
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category get(int id) {
		
		return null;
	}

	@Override
	public List<Category> getAll() {
		
		List<Category> list=categoryRepository.findAll();
		Comparator<Category> sortingByName=new Comparator<Category>() {
			
			@Override
			public int compare(Category o1, Category o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		};
		Collections.sort(list, sortingByName);
		return list;
	}

}
