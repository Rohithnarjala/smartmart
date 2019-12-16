package com.project.productservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.productservice.model.Product;
import com.project.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	ProductRepository productRepository;
	@Override 
	public List<Product> getAllProducts() {
		LOGGER.info("Start");
		LOGGER.info("End"); 
		return productRepository.findAll();
	}
	@Override
	public void addProduct(Product product) {
		LOGGER.info("Start");
		LOGGER.info("End");
		productRepository.save(product);
		
	}
	@Override
	public void updateProduct(Product product) {
		LOGGER.info("Start");
		LOGGER.info("End");
		productRepository.save(product);
		
	}
	@Override
	public Product getProduct(int id) {
		LOGGER.info("Start");
		LOGGER.info("End");
		return productRepository.findById(id);
		
		
	}
	@Override
	public void deleteProduct(int id) {
		LOGGER.info("Start");
		Product product =productRepository.findById(id);
		productRepository.delete(product);
		LOGGER.info("End");
		
	}
	@Override
	public List<Product> getSortByPopularity() {
		List<Product> productArray = productRepository.getProductArray1();
		productArray.addAll(productRepository.getProductArray2());
		System.out.println(productArray);
		return productArray;
	}

}
