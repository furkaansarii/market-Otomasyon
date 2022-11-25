package com.example.market.business.service;

import java.util.List;

import com.example.market.dtos.CheapBuyingPrice;
import com.example.market.dtos.ProductCreateDto;
import com.example.market.dtos.ProductListDto;
import com.example.market.dtos.ProductsDto;




public interface ProductService {

	List<ProductsDto> getAll();
	ProductCreateDto add(ProductCreateDto productCreateDto);
	Double deleteProduct(Long id);
	ProductCreateDto update(Long id, ProductCreateDto productCreateDto);
	List<ProductListDto> findAllByOrderByBuyingQuantityDesc();
	List<CheapBuyingPrice> findAllByOrderByBuyingPriceAsc();
	List<ProductsDto> findAllById(Long id);
}
