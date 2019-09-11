package com.yash.fooddeliverysystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yash.fooddeliverysystem.model.Category;

@Service
public interface CategoryService {
 Category get(int id);
 List<Category> getAll();
 

}
