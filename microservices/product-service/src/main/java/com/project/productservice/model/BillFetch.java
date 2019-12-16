package com.project.productservice.model;

import java.util.Date;
import java.util.List;

public class BillFetch {
	private int userId;
	private Date purchaseDate;
	private int discountedTotal;
	private List<ProductDetails> productList;
	private int rewardPoints;
	private int userRewardPoints;
	private int billId;
	
	
	public BillFetch() {
		super();
	}

	public BillFetch(int userId, Date purchaseDate, List<ProductDetails> productList, int billId) {
		super();
		this.userId = userId;
		this.purchaseDate = purchaseDate;
		this.productList = productList;
		this.billId = billId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<ProductDetails> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductDetails> productList) {
		this.productList = productList;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getDiscountedTotal() {
		return discountedTotal;
	}

	public void setDiscountedTotal(int discountedTotal) {
		this.discountedTotal = discountedTotal;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public int getUserRewardPoints() {
		return userRewardPoints;
	}

	public void setUserRewardPoints(int userRewardPoints) {
		this.userRewardPoints = userRewardPoints;
	}

	@Override
	public String toString() {
		return "UserBill [userId=" + userId + ", productList=" + productList + ", billId=" + billId + "]";
	}
}
