package com.project.productservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.productservice.model.Bill;
import com.project.productservice.model.BillDetails;
import com.project.productservice.model.BillFetch;
import com.project.productservice.model.Product;
import com.project.productservice.model.ProductDetails;
import com.project.productservice.model.Users;
import com.project.productservice.repository.BillRepository;
import com.project.productservice.repository.OfferRepository;
import com.project.productservice.repository.ProductRepository;
import com.project.productservice.repository.UserRepository;

@Service
public class BillServiceImpl implements BillService {
	private static final Logger LOGGER = LoggerFactory.getLogger(BillServiceImpl.class);
	@Autowired
	BillRepository billRepository;
	@Autowired
	UserRepository  userRepository;
	@Autowired
	ProductRepository  productRepository;
	@Autowired
	OfferRepository offerRepository;
	@Override
	public List<Bill> getAllBills() {
		// TODO Auto-generated method stub
		LOGGER.info("start");
		LOGGER.info("End");
		return billRepository.findAll();
	}
	
 
	@Override
	public List<Bill> getBill(String id) {
		// TODO Auto-generated method stub
		return billRepository.getBill(id);
	}

	@Override
	public void userBills(BillFetch userBill) {
		int total = 0;
		Bill bill = new Bill();
		int discountedTotal = 0;
		//bill.setId(userBill.getBillId());
		bill.setPurchaseDate(userBill.getPurchaseDate());
		Users userDetails = userRepository.findById(userBill.getUserId()).get();
		bill.setUser(userDetails);
		
		billRepository.save(bill);
	
		int billId = billRepository.findMaximunBillId();
		Bill bill1 = billRepository.findById(billId).get();
	
		List<BillDetails> billDetailsList = new ArrayList<BillDetails>();
		List<Integer> offerCodes = offerRepository.findOfferCodes(userBill.getPurchaseDate());
		
		int dt= 0 ;
	
		for(int i=0; i<userBill.getProductList().size() ;i++) {	
				ProductDetails pd = userBill.getProductList().get(i);
				Product product = productRepository.findById(pd.getProductId());
				if(offerCodes.contains(pd.getProductId())) {
					float rate1 = (float)(( offerRepository.findDiscountByCode(pd.getProductId()) * product.getRatePerQuantity()/100));
					int quantity = pd.getQuantity();
					dt +=(rate1 * quantity);
				}
				int rate = product.getRatePerQuantity();
				int quantity = pd.getQuantity();
				total+=(rate * quantity);
				product.setStockCount(product.getStockCount()-quantity);
				billDetailsList.add( new BillDetails(billId, pd.getProductId(), pd.getQuantity()));
		}
		discountedTotal = total-dt;
		bill1.setDiscountedTotal(discountedTotal);
		bill1.setTotalAmount(total);
		bill1.setRewardPoints((total/100) *20);
		bill1.setBillDetailsList(billDetailsList);
			
		billRepository.save(bill1);
		
	}
		
	}


