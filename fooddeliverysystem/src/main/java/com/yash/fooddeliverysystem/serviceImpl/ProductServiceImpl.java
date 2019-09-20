package com.yash.fooddeliverysystem.serviceImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.fooddeliverysystem.model.Product;
import com.yash.fooddeliverysystem.repository.ProductRepository;
import com.yash.fooddeliverysystem.service.ProductService;

@Service("impl")
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product get(int productId) {
	
		return  productRepository.findById(productId).get();
	}

	@Override
	public List<Product> list() {
		List<Product> productList=productRepository.findAll();
		Comparator<Product> productSorting=new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(productList, productSorting);
		return  productList;
	}

	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public void saveProduct(Product product) {
		 productRepository.save(product);
	}

	
}
