package com.project.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.productservice.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
	
//	Product findByName(String name);
	public Product findById(int id);
//	boolean existsByName(String name);
//	boolean existsByCode(String code);
//	List<Product> findAllByType(int type);
//	
//	@Query(nativeQuery = true, value = "SELECT * FROM product ORDER BY pt_name ASC;")
//	List<Product> getSortByName();
//	
//	@Query(nativeQuery = true, value = "SELECT * FROM product ORDER BY pt_ratePerQuantity ASC;")
//	List<Product> getSortByPrice();
//	
//	@Query(nativeQuery = true, value = "SELECT * FROM product ORDER BY pt_stockCount DESC;")
//	List<Product> getSortByAvailability();
	@Query(nativeQuery = true, value = "select * from product INNER JOIN bill_details ON (pt_id = bd_pt_id) group by  bd_pt_id Order by sum(quantity) desc;")
	List<Product> getProductArray1();
	
	@Query(nativeQuery = true, value = "SELECT * FROM product where pt_id not in (select pt_id from product INNER JOIN bill_details ON (pt_id = bd_pt_id) group by bd_pt_id Order by sum(quantity) desc);")
	List<Product> getProductArray2();
	
}
