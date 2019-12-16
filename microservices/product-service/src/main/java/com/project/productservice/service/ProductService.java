package com.project.productservice.service;

import java.util.List;

import com.project.productservice.model.Product;

public interface ProductService {
	public List<Product> getAllProducts();

	public void addProduct(Product product);

	public void updateProduct(Product product);

	public Product getProduct(int id);

	public void deleteProduct(int id);

	public List<Product> getSortByPopularity();
}
