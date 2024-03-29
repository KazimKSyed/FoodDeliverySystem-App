package com.yash.fooddeliverysystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;



@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String brand;
	private String description;
	@Column(name = "unit_price")
	private double unitPrice;
	private int quantity;
	@Column(name = "is_active")	
	private boolean active;
	@Column(name = "category_id")
	private int categoryId;
	@Column(name = "supplier_id")
	private int supplierId;
	private int purchases;
	private int views;
	@Transient
	private byte[]  imgSrc;
	@Column(name="File_Path")
	private String filePath;
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	
	public byte[] getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(byte[] imgSrc) {
		this.imgSrc = imgSrc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getPurchases() {
		return purchases;
	}
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public Product() {
		super();
		
	}
	
	

}
