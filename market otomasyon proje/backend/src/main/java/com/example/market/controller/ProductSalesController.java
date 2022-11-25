package com.example.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.market.business.service.ProductSalesService;
import com.example.market.dtos.DateProductSalesDto;
import com.example.market.dtos.ProductSalesCreateDto;
import com.example.market.dtos.TopSellingProduct;
import com.example.market.entities.ProductSales;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/productSales")

public class ProductSalesController {
	
	private ProductSalesService productSalesService;

	@Autowired
	public ProductSalesController(ProductSalesService productSalesService) {
		super();
		this.productSalesService = productSalesService;
	}
	
	@PostMapping
	public ProductSalesCreateDto add(@RequestBody ProductSalesCreateDto productSalesCreateDto) {
		return this.productSalesService.add(productSalesCreateDto);
	}
	@PutMapping("{id}")
	public ProductSalesCreateDto update(@PathVariable Long id, @RequestBody ProductSalesCreateDto productSalesCreateDto) {
		return this.productSalesService.update(id, productSalesCreateDto);
	}
	@GetMapping
	public List<DateProductSalesDto> getAll(){
		return this.productSalesService.getAll();
	}
	@DeleteMapping("{id}")
		public void delete(@PathVariable Long id) {
			this.productSalesService.delete(id);
		}
	
	@GetMapping("/productSales-priceDate")
	public List<DateProductSalesDto> findAllByPriceDate(String priceDate){
		return this.productSalesService.findAllByPriceDate(priceDate);
	}
	
	@GetMapping("/productSales-getTopSelling-desc")
	public List<TopSellingProduct> findAllByOrderBySaleQuantityDesc(){
		return productSalesService.findAllByOrderBySaleQuantityDesc();
	}
	
	@GetMapping("{id}")
	public List<ProductSalesCreateDto> findAllByProductSalesId(@PathVariable Long id){
		return productSalesService.findAllByProductSalesId(id);
	}
	
	
	
	}
	
	//@GetMapping("/productSales/{productSalesId}")
	//public List<SellProductDto> getByProductSalesId(@PathVariable Long productSalesId){
		//return this.productSalesService.getByProductSalesId(productSalesId);
	//}
	//BU metoda daha sonra bak ve iyileştir
	


