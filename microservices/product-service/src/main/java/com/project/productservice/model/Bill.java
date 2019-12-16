package com.project.productservice.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bi_id")
	private int id;
	
	@Column(name="bi_purchase_date")
	private Date purchaseDate;
	
	@Column(name="bi_total_amount",columnDefinition = "DECIMAL(8,2)")
	private double totalAmount;
	
	@Column(name = "bi_discounted_amount", columnDefinition = "DECIMAL(8,2)")
	private int discountedTotal;
	
	public int getDiscountedTotal() {
		return discountedTotal;
	}

	public void setDiscountedTotal(int discountedTotal) {
		this.discountedTotal = discountedTotal;
	}

	@Column(name="bi_reward_points")
	private int rewardPoints;
	
	@Column(name="bi_user_reward_points", columnDefinition = "DECIMAL(8,2)")
	private int userRewardPoints;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "bill_details",
//        joinColumns = @JoinColumn(name = " bd_bi_id"), 
//        inverseJoinColumns = @JoinColumn(name = "bd_pt_id"))
//    private List<Product> productList;

	@ManyToOne
	@JoinColumn(name="bi_us_id")
	private Users user;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="bd_bi_id")
	private List<BillDetails> billDetailsList;

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(int id, Date purchaseDate, double totalAmount, int rewardPoints) {
		super();
		this.id = id;
		this.purchaseDate = purchaseDate;
		this.totalAmount = totalAmount;
		this.rewardPoints = rewardPoints;
		//this.productList = productList;
		//this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}
	public int getUserRewardPoints() {
		return userRewardPoints;
	}

	public void setUserRewardPoints(int userRewardPoints) {
		this.userRewardPoints = userRewardPoints;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

//	public List<Product> getProductList() {
//		return productList;
//	}
//
//	public void setProductList(List<Product> productList) {
//		this.productList = productList;
//	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", purchaseDate=" + purchaseDate + ", totalAmount=" + totalAmount + ", rewardPoints="
				+ rewardPoints + ", user=" + user + "]";
	}

	public List<BillDetails> getBillDetailsList() {
		return billDetailsList;
	}

	public void setBillDetailsList(List<BillDetails> billDetailsList) {
		this.billDetailsList = billDetailsList;
	}
	
	
	
}