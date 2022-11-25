package com.example.market.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.market.entities.ProductSales;

public interface ProductSalesRepository extends JpaRepository<ProductSales, Long>{

	List<ProductSales> getByProductSalesId(Long productSalesId);
	List<ProductSales> findAllByPriceDate(String priceDate);
	List<ProductSales> findAllByOrderBySaleQuantityDesc();
	List<ProductSales> findAllByProductSalesId(Long id);
	//boolean findByProductSalesId(Long id);
	//Long countBySaleQuantity();
	//List<ProductSales> getByProductSalesIdAndProduct_Id(Long productId);
	
}
