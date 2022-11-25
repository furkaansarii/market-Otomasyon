package com.example.market.entities;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productSalesId;
	/*
	@Column(name = "sale_price")
	private Double salePrice;
	*/
	@Column(name = "price_date")
	private String priceDate;
	
	@Column(name = "sale_quantity")
	private Double saleQuantity;
	
	/*
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	*/
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_id")
	private Admin admin;
	 
	
	
	public ProductSales(//Double salePrice,
			String priceDate, Double saleQuantity) {
		super();
		//this.salePrice = salePrice;
		this.priceDate = priceDate;
		this.saleQuantity = saleQuantity;
	}
	public ProductSales(Double saleQuantity) {
		this.saleQuantity = saleQuantity;
	}


	public ProductSales(//Double salePrice,
			String priceDate, Double saleQuantity, Product product, Admin admin) {
		super();
		//this.salePrice = salePrice;
		this.priceDate = priceDate;
		this.saleQuantity = saleQuantity;
		this.product = product;
		this.admin = admin;
	}
	
	
	
	
	
}
