package com.inventory.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sale_orders")
public class Sale{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer saleId;
	Integer productId;
	Integer productQuantity;
	Double salePrice;
	Timestamp saleDate;
	//Double productPrice;
	public Sale() {
		super();

	}

	public Sale(Integer saleId, Integer productId, Integer productQuantity, Double salePrice, Timestamp saleDate) {
		super();
		this.saleId = saleId;
		this.productId = productId;
		this.productQuantity = productQuantity;
		this.salePrice = salePrice;
		this.saleDate = saleDate;
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
	

	/*public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}*/

	@Override
	public String toString() {
		return "Sale [saleId=" + saleId + ", productId=" + productId + ", productQuantity=" + productQuantity
				+ ", salePrice=" + salePrice + ", saleDate=" + saleDate + "]";
	}

	
	

	

	

}
