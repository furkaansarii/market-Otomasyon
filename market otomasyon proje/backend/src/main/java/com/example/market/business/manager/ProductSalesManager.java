package com.example.market.business.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.business.service.ProductSalesService;
import com.example.market.dtos.DateProductSalesDto;
import com.example.market.dtos.ProductSalesCreateDto;
import com.example.market.dtos.TopSellingProduct;
import com.example.market.entities.Admin;
import com.example.market.entities.Product;
import com.example.market.entities.ProductSales;
import com.example.market.repository.AdminRepository;
import com.example.market.repository.ProductRepository;
import com.example.market.repository.ProductSalesRepository;
@Service
public class ProductSalesManager implements ProductSalesService{

	private ProductSalesRepository productSalesRepository;
	private ProductRepository productRepository;
	private AdminRepository adminRepository;
	
	
	@Autowired
	public ProductSalesManager(ProductSalesRepository productSalesRepository, ProductRepository productRepository, AdminRepository adminRepository) {
		super();
		this.productSalesRepository = productSalesRepository;
		this.productRepository = productRepository;
		this.adminRepository = adminRepository;
	}



	@Override
	public ProductSalesCreateDto add(ProductSalesCreateDto productSalesCreateDto) {
		Admin admin = adminRepository.getById(productSalesCreateDto.getAdminId());
		Product product = productRepository.getById(productSalesCreateDto.getProductId());
		final ProductSales productSales = productSalesRepository.save(new ProductSales(productSalesCreateDto.getPriceDate(),productSalesCreateDto.getSaleQuantity(),product, admin));
		return ProductSalesCreateDto.of(productSales);
	}

	
	@Override
	public ProductSalesCreateDto update(Long id, ProductSalesCreateDto productSalesCreateDto) {
		ProductSales productSales = productSalesRepository.getById(id);
		Product product = productRepository.getById(productSalesCreateDto.getProductId());
	//	productSales.setSalePrice(productSalesCreateDto.getSalePrice());
		productSales.setPriceDate(productSalesCreateDto.getPriceDate());
		productSales.setSaleQuantity(productSalesCreateDto.getSaleQuantity());
		productSales.setProduct(product);
		ProductSales updateProductSales = productSalesRepository.save(productSales);
		return ProductSalesCreateDto.of(updateProductSales);
		
	}



	@Override
	public List<DateProductSalesDto> getAll() {
		
		return this.productSalesRepository.findAll().stream().map(DateProductSalesDto::of).collect(Collectors.toList());
	}



	@Override
	public void delete(Long id) {
		ProductSales productSales = productSalesRepository.getById(id);
		productSalesRepository.delete(productSales);
		
	}



	@Override
	public List<DateProductSalesDto> findAllByPriceDate(String priceDate) {
		
		return this.productSalesRepository.findAllByPriceDate(priceDate).stream().map(DateProductSalesDto::of).collect(Collectors.toList());
	}



	@Override
	public List<TopSellingProduct> findAllByOrderBySaleQuantityDesc() {
		
		return this.productSalesRepository.findAllByOrderBySaleQuantityDesc().stream().map(TopSellingProduct::of).collect(Collectors.toList());
	}



	@Override
	public List<ProductSalesCreateDto> findAllByProductSalesId(Long id) {
		
		return productSalesRepository.findAllByProductSalesId(id).stream().map(ProductSalesCreateDto::of).collect(Collectors.toList());
	}



	
	


	



	
	
	



	
}
