package com.example.market.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.market.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findAllByWholesaler_CompanyName(String companyName);
	List<Product> findAllByOrderByBuyingQuantityDesc();
	List<Product> findAllByOrderByBuyingPriceAsc();
	List<Product> findAllByProductId(Long id);

}
