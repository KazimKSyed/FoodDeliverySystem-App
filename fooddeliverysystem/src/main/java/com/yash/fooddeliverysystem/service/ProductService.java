package com.yash.fooddeliverysystem.service;

import java.util.List;

import com.yash.fooddeliverysystem.model.Product;


public interface ProductService {
	Product get(int productId);
	List<Product> list();	
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	

}
