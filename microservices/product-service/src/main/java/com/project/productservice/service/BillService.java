package com.project.productservice.service;

import java.util.List;

import com.project.productservice.model.Bill;
import com.project.productservice.model.BillFetch;


public interface BillService {

	public List<Bill> getAllBills();


	public List<Bill> getBill(String id);

	public void userBills(BillFetch userBill);
}
