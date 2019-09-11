package com.yash.fooddeliverysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.fooddeliverysystem.model.Product;
import com.yash.fooddeliverysystem.serviceImpl.ProductServiceImpl;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	@Autowired
	ProductServiceImpl impl;
	
	@GetMapping(value = "/{id}")
	public Product getProduct(@PathVariable int id) {
		return impl.get(id);
	}
	
	@GetMapping(value = "/")
	public List<Product> getProductList() {
		return impl.list();
	}

}
