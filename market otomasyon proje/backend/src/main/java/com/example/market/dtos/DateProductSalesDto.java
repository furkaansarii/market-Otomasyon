package com.example.market.dtos;

import com.example.market.entities.ProductSales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateProductSalesDto {
	
	private Long productSalesId;
	
	private Double salePrice;

	private String priceDate;

	private Double saleQuantity;

	private String productName;
	
	public static DateProductSalesDto of(ProductSales productSales) {
		DateProductSalesDto dateProductSalesDto = new DateProductSalesDto();
		dateProductSalesDto.setProductSalesId(productSales.getProductSalesId());
		dateProductSalesDto.setSalePrice(productSales.getProduct().getSalePrice());
		dateProductSalesDto.setPriceDate(productSales.getPriceDate());
		dateProductSalesDto.setSaleQuantity(productSales.getSaleQuantity());
		dateProductSalesDto.setProductName(productSales.getProduct().getProductName());
		return dateProductSalesDto;
	}

}
