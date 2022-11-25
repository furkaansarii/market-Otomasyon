package com.example.market.business.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.market.business.service.ProductService;
import com.example.market.dtos.CheapBuyingPrice;
import com.example.market.dtos.DateProductSalesDto;
import com.example.market.dtos.ProductCreateDto;
import com.example.market.dtos.ProductListDto;
import com.example.market.dtos.ProductsDto;
import com.example.market.entities.Admin;
import com.example.market.entities.Product;
import com.example.market.entities.ProductSales;
import com.example.market.entities.Wholesaler;
import com.example.market.repository.AdminRepository;
import com.example.market.repository.ProductRepository;
import com.example.market.repository.WholesalerRepository;
@Service
public class ProductManager implements ProductService{

	private ProductRepository productRepository;
	private WholesalerRepository wholesalerRepository;
	private AdminRepository adminRepository;


	
	
	@Autowired
	public ProductManager(ProductRepository productRepository, WholesalerRepository wholesalerRepository, AdminRepository adminRepository) {
		super();
		this.productRepository = productRepository;
		this.wholesalerRepository = wholesalerRepository;
		this.adminRepository = adminRepository;
		
		
	}

	@Override
	public List<ProductsDto> getAll() {
		
		return this.productRepository.findAll().stream().map(ProductsDto::of).collect(Collectors.toList());
		
	}

	@Override
	public ProductCreateDto add(ProductCreateDto productCreateDto) {
		Admin admin = adminRepository.getById(productCreateDto.getAdminId());
		Wholesaler wholesaler = wholesalerRepository.getById(productCreateDto.getWholesalerId());
		final Product product = productRepository.save(new Product(productCreateDto.getProductName()
				,productCreateDto.getBuyingPrice(),productCreateDto.getBuyingQuantity(),productCreateDto.getSalePrice(),wholesaler, admin));
		return ProductCreateDto.of(product);
		
	}

	@Override
	public Double deleteProduct(Long id) {
		Product product = productRepository.getById(id);
		productRepository.delete(product);
		ProductSales productSales = new ProductSales();
		return (double) 5;
		/*
		Double message = productSales.getSalePrice();
		return message;
		*/
	}

	@Override
	public ProductCreateDto update(Long id, ProductCreateDto productCreateDto) {
		Product product = productRepository.getById(id);
		Wholesaler wholesaler = wholesalerRepository.getById(productCreateDto.getWholesalerId());
		product.setProductName(productCreateDto.getProductName());
		product.setBuyingPrice(productCreateDto.getBuyingPrice());
		product.setBuyingQuantity(productCreateDto.getBuyingQuantity());
		product.setWholesaler(wholesaler);
		Product updateProduct = productRepository.save(product);
		return ProductCreateDto.of(updateProduct);
		
	}

	@Override
	public List<ProductListDto> findAllByOrderByBuyingQuantityDesc() {
		
		return this.productRepository.findAllByOrderByBuyingQuantityDesc().stream().map(ProductListDto::of).collect(Collectors.toList());
	}

	@Override
	public List<CheapBuyingPrice> findAllByOrderByBuyingPriceAsc() {
		
		return this.productRepository.findAllByOrderByBuyingPriceAsc().stream().map(CheapBuyingPrice::of).collect(Collectors.toList());
	}

	@Override
	public List<ProductsDto> findAllById(Long id) {
		
		return this.productRepository.findAllByProductId(id).stream().map(ProductsDto::of).collect(Collectors.toList());
	}
	
	

}
