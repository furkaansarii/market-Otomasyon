package com.example.market.dtos;

import com.example.market.entities.ProductSales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopSellingProduct {
	
	private String productName;
	
	private Double saleQuantity;
	
	public static TopSellingProduct of(ProductSales productSales) {
		TopSellingProduct topSellingProduct = new TopSellingProduct();
		topSellingProduct.setProductName(productSales.getProduct().getProductName());
		topSellingProduct.setSaleQuantity(productSales.getSaleQuantity());
		return topSellingProduct;
	}

}
