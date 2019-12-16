package com.project.productservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bill_details")
public class BillDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bd_id")
	int billDetailsId;
	
	@Column(name = "bd_bi_id")
	private int billId;
	
	@Column(name = "bd_pt_id")
	private int productId;
	
	@Column(name = "quantity")
	int quantity;

	public BillDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillDetails(int billDetailsId, int billId, int productId, int quantity) {
		super();
		this.billDetailsId = billDetailsId;
		this.billId = billId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public BillDetails(int billId, int productId, int quantity) {
		super();
		this.billId = billId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getBillDetailsId() {
		return billDetailsId;
	}

	public void setBillDetailsId(int billDetailsId) {
		this.billDetailsId = billDetailsId;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BillDetails [billDetailsId=" + billDetailsId + ", billId=" + billId + ", productId=" + productId
				+ ", quantity=" + quantity + "]";
	}
	
	
}