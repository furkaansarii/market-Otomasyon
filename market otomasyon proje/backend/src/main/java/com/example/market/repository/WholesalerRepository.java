package com.example.market.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.market.entities.Wholesaler;

public interface WholesalerRepository extends JpaRepository<Wholesaler, Long>{
	
	List<Wholesaler> findAllByCompanyName(String companyName);
	List<Wholesaler> findAllByWholesalerId(Long id);
	
	

}
