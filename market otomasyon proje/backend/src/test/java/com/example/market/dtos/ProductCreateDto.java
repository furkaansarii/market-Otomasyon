package com.example.market.dtos;

import com.example.market.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDto {

	private String productName;

	private Double buyingPrice;

	private Double buyingQuantity;
	
	private Double salePrice;

	private Long wholesalerId;
	
	private Long adminId;
	
	public static ProductCreateDto of(Product product) {
		ProductCreateDto productCreateDto = new ProductCreateDto();
		productCreateDto.setProductName(product.getProductName());
		productCreateDto.setBuyingPrice(product.getBuyingPrice());
		productCreateDto.setBuyingQuantity(product.getBuyingQuantity());
		productCreateDto.setWholesalerId(product.getWholesaler().getWholesalerId());
		productCreateDto.setSalePrice(product.getSalePrice());
		productCreateDto.setAdminId(product.getAdmin().getAdminId());
		return productCreateDto;
	}

}
