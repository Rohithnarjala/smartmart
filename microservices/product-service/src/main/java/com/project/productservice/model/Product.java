package com.project.productservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pt_id")
	int id;
	@Column(name = "pt_name")
	String name;
	@Column(name = "pt_type")
	int type;
	@Column(name = "pt_brand")
	String brand;
	@Column(name = "pt_quantity_type")
	String quantityType;
	@Column(name = "pt_rate_per_quantity")
	int ratePerQuantity;
	@Column(name = "pt_stock_count")
	int stockCount;
	@Column(name = "pt_add_date")
	Date addDate;
	@Column(name = "pt_aisle")
	String aisle;
	@Column(name = "pt_shelf")
	String shelf;
	@Column(name = "pt_date_of_manufacture")
	Date dateOfManufacture;
	@Column(name = "pt_date_of_expiry")
	Date dateOfExpiry;
	@Column(name = "pt_image")
	String image;

	public Product() { 
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, int type, String brand, String quantityType, int ratePerQuantity,
			int stockCount, Date addDate, String aisle, String shelf, Date dateOfManufacture, Date dateOfExpiry,
			String image) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.brand = brand;
		this.quantityType = quantityType;
		this.ratePerQuantity = ratePerQuantity;
		this.stockCount = stockCount;
		this.addDate = addDate;
		this.aisle = aisle;
		this.shelf = shelf;
		this.dateOfManufacture = dateOfManufacture;
		this.dateOfExpiry = dateOfExpiry;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public String getCode() {
//		return code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getQuantityType() {
		return quantityType;
	}

	public void setQuantityType(String quantityType) {
		this.quantityType = quantityType;
	}

	public int getRatePerQuantity() {
		return ratePerQuantity;
	}

	public void setRatePerQuantity(int ratePerQuantity) {
		this.ratePerQuantity = ratePerQuantity;
	}

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public String getAisle() {
		return aisle;
	}

	public void setAisle(String aisle) {
		this.aisle = aisle;
	}

	public String getShelf() {
		return shelf;
	}

	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	public Date getDateOfManufacture() {
		return dateOfManufacture;
	}

	public void setDateOfManufacture(Date dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", brand=" + brand
				+ ", quantityType=" + quantityType + ", ratePerQuantity=" + ratePerQuantity + ", stockCount="
				+ stockCount + ", addDate=" + addDate + ", aisle=" + aisle + ", shelf=" + shelf + ", dateOfManufacture="
				+ dateOfManufacture + ", dateOfExpiry=" + dateOfExpiry + ", image=" + image + "]";
	}

}
