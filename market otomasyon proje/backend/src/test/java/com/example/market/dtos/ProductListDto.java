package com.example.market.dtos;

import com.example.market.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListDto {

	private String productName;
	
	private Double buyingQuantity;
	
	public static ProductListDto of(Product product) {
		ProductListDto productListDto = new ProductListDto();
		productListDto.setProductName(product.getProductName());
		productListDto.setBuyingQuantity(product.getBuyingQuantity());
		return productListDto;
	}

}
