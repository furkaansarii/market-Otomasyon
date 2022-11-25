package com.example.market.dtos;



import com.example.market.entities.Product;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDto {
	
	private Long productId;
	private String productName;
	private Double buyingPrice;
	private Double salePrice;
	//private List<ProductSales> salePrice;
	private String companyName;
	
	public static ProductsDto of(Product product) {
		ProductsDto productsDto = new ProductsDto();
		productsDto.setProductId(product.getProductId());
		productsDto.setProductName(product.getProductName());
		productsDto.setBuyingPrice(product.getBuyingPrice());
		productsDto.setSalePrice(product.getSalePrice());
	//	productsDto.setProductSale(product.getProductSales().getSalePrice());
	//	productsDto.setSalePrice(product.getProductSales());
		productsDto.setCompanyName(product.getWholesaler().getCompanyName());
		return productsDto;
		
		
	}

}
