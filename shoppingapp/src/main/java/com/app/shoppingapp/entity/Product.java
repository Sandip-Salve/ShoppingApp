package com.app.shoppingapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PRODUCTS")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PRODUCT_ID")
	private Long pId;
	
	@Size(min = 1, max = 20, message = "productName must be between 1-20 characters.")
	@Column(name = "PRODUCT_NAME", length = 20)
	private String pName;
	
	@Size(min = 1, max = 20, message = "productBrand must be between 1-20 characters.")
	@Column(name = "PRODUCT_BRAND", length = 20)
	private String pBrand;
	
	@Min(1)
	@Column(name = "PRODUCT_PRICE")
	private Integer pPrice;
	
	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpBrand() {
		return pBrand;
	}

	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}

	public Integer getpPrice() {
		return pPrice;
	}

	public void setpPrice(Integer pPrice) {
		this.pPrice = pPrice;
	}

	
	
	
}
