package com.inventory.entity;

import java.sql.Timestamp;


public class ProductSale {
	Integer saleId;
	Integer productId;
	Integer productQuantity;
	Double productPrice;
	Double salePrice;
	Timestamp saleDate;
	
	public ProductSale() {
		super();

	}

    
	public ProductSale(Integer saleId, Integer productId, Integer productQuantity, Double salePrice, Timestamp saleDate,
			Double productPrice) {
		super();
		this.saleId = saleId;
		this.productId = productId;
		this.productQuantity = productQuantity;
		this.salePrice = salePrice;
		this.saleDate = saleDate;
		this.productPrice = productPrice;
	}


	public Integer getSaleId() {
		return saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Timestamp getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Timestamp saleDate) {
		this.saleDate = saleDate;
	}
	

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "ProductSale [saleId=" + saleId + ", productId=" + productId + ", productQuantity=" + productQuantity
				+ ", productPrice=" + productPrice
				+ ", salePrice=" + salePrice + ", saleDate=" + saleDate + "]";
	}

	
	

	

	


}
