package com.example.market.dtos;

import com.example.market.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheapBuyingPrice {
	
	private String productName;
	private Double buyingPrice;
	private Double salePrice;
	
	public static CheapBuyingPrice of(Product product) {
		CheapBuyingPrice cheapBuyingPrice = new CheapBuyingPrice();
		cheapBuyingPrice.setProductName(product.getProductName());
		cheapBuyingPrice.setBuyingPrice(product.getBuyingPrice());
		cheapBuyingPrice.setSalePrice(product.getSalePrice());
		return cheapBuyingPrice;
	}

}
