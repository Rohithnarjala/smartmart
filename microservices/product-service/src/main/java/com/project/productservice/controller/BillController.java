package com.project.productservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.productservice.model.Bill;
import com.project.productservice.model.BillFetch;
import com.project.productservice.service.BillService;

@RestController
@CrossOrigin("*")
@RequestMapping("/smartmart")
public class BillController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BillController.class);
	
	@Autowired
	BillService billService;
	
	@GetMapping
	public List<Bill> getAllBills(){
		LOGGER.info("start");
		LOGGER.info("End"); 
		return billService.getAllBills();
	}
	@PostMapping("/bills")
	void postBills(@RequestBody BillFetch billFetch) {
		 billService.userBills(billFetch);
	}
	
	@GetMapping("/bills/{id}")
	List<Bill> getBill(@PathVariable String id) {
		return billService.getBill(id);
	}
}
