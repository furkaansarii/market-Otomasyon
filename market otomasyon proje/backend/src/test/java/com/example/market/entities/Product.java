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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "productSales" })
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "buying_price")
	private Double buyingPrice;

	@Column(name = "buying_quantity")
	private Double buyingQuantity;
	
	@Column(name = "sale_price")
	private Double salePrice;

	/*
	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
	private ProductSales productSales;
	*/
	  @OneToMany(mappedBy = "product")
	private List<ProductSales> productSales;
	 

	@ManyToOne()
	@JoinColumn(name = "wholesaler_id")
	private Wholesaler wholesaler;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_id")
	private Admin admin;

	public Product(String productName, Double buyingPrice, Double buyingQuantity, Wholesaler wholesaler) {
		super();
		this.productName = productName;
		this.buyingPrice = buyingPrice;
		this.buyingQuantity = buyingQuantity;
		this.wholesaler = wholesaler;
	}

	//bu yeni const
	public Product(String productName, Double buyingPrice, Double buyingQuantity, List<ProductSales> productSales) {
		super();
		this.productName = productName;
		this.buyingPrice = buyingPrice;
		this.buyingQuantity = buyingQuantity;
		this.productSales = productSales;
	}
	
	public Product(String productName, Double buyingPrice, Double buyingQuantity, Double salePrice, Wholesaler wholesaler, Admin admin) {
		super();
		this.productName = productName;
		this.buyingPrice = buyingPrice;
		this.buyingQuantity = buyingQuantity;
		this.salePrice = salePrice;
		this.wholesaler = wholesaler;
		this.admin = admin;
	}
/*
	public Product(String productName, Double buyingPrice, Double buyingQuantity, ProductSales productSales) {
		super();
		this.productName = productName;
		this.buyingPrice = buyingPrice;
		this.buyingQuantity = buyingQuantity;
		this.productSales = productSales;
	}
	*/
	
	

}
