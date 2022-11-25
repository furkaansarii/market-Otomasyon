package com.example.market.dtos;

import com.example.market.entities.Product;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsBroughtByTheWholesaler {
	
	private String productName;
	private String companyName;
	
	public static ProductsBroughtByTheWholesaler of(Product product) {
		ProductsBroughtByTheWholesaler productsBroughtByTheWholesaler = new ProductsBroughtByTheWholesaler();
		productsBroughtByTheWholesaler.setProductName(product.getProductName());
		productsBroughtByTheWholesaler.setCompanyName(product.getWholesaler().getCompanyName());
		return productsBroughtByTheWholesaler;
		
	}

}
