package com.example.market.business.service;

import java.util.List;

import com.example.market.dtos.DateProductSalesDto;
import com.example.market.dtos.ProductSalesCreateDto;

import com.example.market.dtos.TopSellingProduct;





public interface ProductSalesService {
	
	ProductSalesCreateDto add(ProductSalesCreateDto productSalesCreateDto);
//	List<SellProductDto> getByProductSalesId(Long productSalesId);
	ProductSalesCreateDto update(Long id, ProductSalesCreateDto productSalesCreateDto);
	List<DateProductSalesDto> getAll();
	void delete(Long id);
	List<DateProductSalesDto> findAllByPriceDate(String priceDate);
	List<TopSellingProduct> findAllByOrderBySaleQuantityDesc();
	List<ProductSalesCreateDto> findAllByProductSalesId(Long id);


	
}
