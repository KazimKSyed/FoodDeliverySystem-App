package com.yash.fooddeliverysystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.yash.fooddeliverysystem.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


}
