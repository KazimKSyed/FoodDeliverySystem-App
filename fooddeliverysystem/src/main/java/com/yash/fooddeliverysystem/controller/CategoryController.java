package com.yash.fooddeliverysystem.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yash.fooddeliverysystem.model.Category;
import com.yash.fooddeliverysystem.repository.CategoryRepository;
import com.yash.fooddeliverysystem.serviceImpl.CategoryServiceImpl;

@RestController
@RequestMapping(value = "/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
	
	@Autowired
	CategoryRepository catRepository;
	@Autowired
	CategoryServiceImpl impl;

	@GetMapping(value = "/{id}")
	public Category get(@PathVariable int id) {
		return catRepository.findById(id).get();
	}

	@GetMapping(value = "/")
	public List<Category> getAll() {
		return impl.getAll();
	}

	@PostMapping("/")
	public ResponseEntity<Void> createCategory(@RequestBody Category category) {

		Category createCategory = catRepository.save(category);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createCategory.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Category> update(@PathVariable int id, @RequestBody Category category) {
		Category cat = catRepository.findById(id).get();
		cat.setId(category.getId());
		cat.setName(category.getName());
		cat.setDescription(category.getDescription());
		cat.setActive(category.isActive());
		Category categoryUpdated = catRepository.save(cat);
		System.out.println(categoryUpdated);
		return new ResponseEntity<Category>(categoryUpdated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
		catRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
