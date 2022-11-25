package com.example.market.business.service;

import java.util.List;

import com.example.market.dtos.ProductsBroughtByTheWholesaler;
import com.example.market.dtos.WholesalerCreateDto;




public interface WholesalerService {
	
	WholesalerCreateDto add(WholesalerCreateDto wholesalerCreateDto);
	List<WholesalerCreateDto> getAll();
	WholesalerCreateDto update(Long id, WholesalerCreateDto wholesalerCreateDto);
	void deleteWholesaler(Long id);
	List<WholesalerCreateDto> findAllByCompanyName(String companyName);
	List<ProductsBroughtByTheWholesaler> findAllByWholesaler_CompanyName(String companyName);
	List<WholesalerCreateDto> findAllByWholesalerId(Long id);
}
