package com.project.productservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.productservice.ProductServiceApplication;
import com.project.productservice.model.Product;
import com.project.productservice.model.Users;
import com.project.productservice.service.ProductService;

@RestController
@CrossOrigin("*")
@RequestMapping("/smartmart")
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ProductService productService;
 

//	@PostMapping("/products")
//	public void addProduct(@RequestBody @Valid Product product) {
//		LOGGER.info("Start");
//		productService.addProduct(product);
//		LOGGER.info("End");
//	}

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		List<Product> productList = null;
		productList=productService.getAllProducts();
		return productList;
	}
	@PostMapping("/addproduct")
	public void addProduct(@RequestBody Product product) {
		LOGGER.info("Start");
		productService.addProduct(product);
		LOGGER.info("End");
	}
	@PutMapping("/updateproduct")
	public void updateProduct(@RequestBody Product product) {
		LOGGER.info("Start");
		productService.updateProduct(product);
		LOGGER.info("End");
	}
	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable int id) {
		LOGGER.info("Start");
		LOGGER.info("End");
		return productService.getProduct(id);
		
		
	}
	@DeleteMapping("/delete/{id}")
	public void deleteProductItem(@PathVariable int id) {
		LOGGER.info("Start");
		productService.deleteProduct(id);
		LOGGER.info("End");
	}
	@GetMapping("/product-list/sort-by-popularity")
	public List<Product> sortByPopularity() {
		LOGGER.info("Start");
		return productService.getSortByPopularity();
	}
	
	
//	@GetMapping("/products/sort-by-availability")
//	public List<Product> sortByAvailability() {
//		return productService.sortByAvailability();
//	}
//	
//	@GetMapping("/products/sort-by-name")
//	public List<Product> sortByName() {
//		return productService.sortByName();
//	}
//	
//	@GetMapping("/products/sort-by-price")
//	public List<Product> sortByPrice() {
//		return productService.sortByPrice();
//	}

}