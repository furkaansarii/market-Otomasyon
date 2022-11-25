package com.example.market.dtos;



import java.util.ArrayList;

import com.example.market.entities.ProductSales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSalesCreateDto {


	
	

	private String priceDate;

	private Double saleQuantity;

	private Long productId;
	
	private Long adminId;
	
	public static ProductSalesCreateDto of(ProductSales productSales) {
		ProductSalesCreateDto productSalesCreateDto = new ProductSalesCreateDto();

		
		productSalesCreateDto.setPriceDate(productSales.getPriceDate());
		productSalesCreateDto.setSaleQuantity(productSales.getSaleQuantity());
		productSalesCreateDto.setProductId(productSales.getProduct().getProductId());
		productSalesCreateDto.setAdminId(productSales.getAdmin().getAdminId());
		return productSalesCreateDto;
	}
	

}
