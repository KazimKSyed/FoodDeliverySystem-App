package com.yash.fooddeliverysystem.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.fooddeliverysystem.model.Product;
import com.yash.fooddeliverysystem.serviceImpl.ProductServiceImpl;

@RestController
@RequestMapping(value = "/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	@Autowired
	ProductServiceImpl impl;
	
	@Autowired
	ServletContext context;

	@GetMapping(value = "/{id}")
	public Product getProduct(@PathVariable int id) {
		return impl.get(id);
	}
	
	@GetMapping(value = "/")
	public List<Product> getProductList() {
		return impl.list();
	}
	
	@PostMapping(value = "/")
	public ResponseEntity saveProduct(@RequestParam ( "imgSrc") MultipartFile imgScr,@RequestParam("product") String product) throws IOException {
		
		Product prod =new ObjectMapper().readValue(product, Product.class);
		
		boolean isExist= new File(context.getRealPath("/product/")).exists();
		if(!isExist) {
			 new File(context.getRealPath("/product/")).mkdir();
		}
		
		String filename=imgScr.getOriginalFilename();
		String modifiedfilename=FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
	    File serverFile= new File(context.getRealPath("/product/"+File.separator+modifiedfilename));
	   try {
		   FileUtils.writeByteArrayToFile(serverFile, imgScr.getBytes());
	   }catch(Exception e) {
		   e.getStackTrace();
	   }
	   prod.setFilePath(modifiedfilename);
	   System.out.println(modifiedfilename);
	   
	   
	   impl.saveProduct(prod);
	   
        return new ResponseEntity("Product Save Successfully...!",HttpStatus.OK);
    
		
	}

	
	}

	
	


