package com.example.market.dtos;

import com.example.market.entities.ProductSales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellProductDto {
	
	private Double salePrice;
	
	public static SellProductDto of(ProductSales productSales) {
		SellProductDto sellProductDto = new SellProductDto();
		sellProductDto.setSalePrice(productSales.getProduct().getSalePrice());
		return sellProductDto;
	}

}
