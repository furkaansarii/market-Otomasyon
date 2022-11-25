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

import com.example.market.business.service.ProductService;
import com.example.market.dtos.CheapBuyingPrice;
import com.example.market.dtos.ProductCreateDto;
import com.example.market.dtos.ProductListDto;
import com.example.market.dtos.ProductsDto;
import com.example.market.entities.Product;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/product")

public class ProductController {

	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@PostMapping
	public ProductCreateDto add(@RequestBody ProductCreateDto productCreateDto) {
		return this.productService.add(productCreateDto);
	}
	
	@GetMapping
	public List<ProductsDto> getAll(){
		return this.productService.getAll();
	}
	
	@DeleteMapping("{id}")
	public Double deleteProduct(@PathVariable Long id) {
		return this.productService.deleteProduct(id);
	}
	@PutMapping("{id}")
	public ProductCreateDto update(@PathVariable Long id,@RequestBody ProductCreateDto productCreateDto) {
		return this.productService.update(id, productCreateDto);
	}
	
	@GetMapping("/products/desc")
	public List<ProductListDto> findAllByOrderByBuyingQuantityAsc(){
		return this.productService.findAllByOrderByBuyingQuantityDesc();
	}
	
	@GetMapping("/product/asc")
	public List<CheapBuyingPrice> findAllByOrderByBuyingPriceAsc(){
		return this.productService.findAllByOrderByBuyingPriceAsc();
	}
	
	@GetMapping("{id}")
	public List<ProductsDto> findAllById(@PathVariable Long id){
		return productService.findAllById(id);
	}

}
