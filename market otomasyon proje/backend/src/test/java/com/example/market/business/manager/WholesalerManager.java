package com.example.market.business.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.market.business.service.WholesalerService;

import com.example.market.dtos.ProductsBroughtByTheWholesaler;
import com.example.market.dtos.WholesalerCreateDto;
import com.example.market.entities.Admin;
import com.example.market.entities.Wholesaler;
import com.example.market.repository.AdminRepository;
import com.example.market.repository.ProductRepository;
import com.example.market.repository.WholesalerRepository;
@Service
public class WholesalerManager implements WholesalerService{

	private WholesalerRepository wholesalerRepository;
	private ProductRepository productRepository;
	private AdminRepository adminRepository;
	
	
	@Autowired
	public WholesalerManager(WholesalerRepository wholesalerRepository, ProductRepository productRepository, AdminRepository adminRepository) {
		super();
		this.wholesalerRepository = wholesalerRepository;
		this.productRepository = productRepository;
		this.adminRepository = adminRepository;
	}



	@Override
	public WholesalerCreateDto add(WholesalerCreateDto wholesalerCreateDto) {
		 Admin admin = adminRepository.getById(wholesalerCreateDto.getAdminId());
		 Wholesaler wholesaler = wholesalerRepository.save(new Wholesaler(wholesalerCreateDto.getCompanyName(),
				wholesalerCreateDto.getPhoneNumber(),wholesalerCreateDto.getAddress(), admin));
		
		return WholesalerCreateDto.of(wholesaler);
	}



	@Override
	public List<WholesalerCreateDto> getAll() {
		
		return this.wholesalerRepository.findAll().stream().map(WholesalerCreateDto::of).collect(Collectors.toList());
	}



	@Override
	public WholesalerCreateDto update(Long id, WholesalerCreateDto wholesalerCreateDto) {
		Wholesaler wholesaler = wholesalerRepository.getById(id);
		wholesaler.setCompanyName(wholesalerCreateDto.getCompanyName());
		wholesaler.setPhoneNumber(wholesalerCreateDto.getPhoneNumber());
		wholesaler.setAddress(wholesalerCreateDto.getAddress());
		Wholesaler updateWholesaler = wholesalerRepository.save(wholesaler);
		return WholesalerCreateDto.of(updateWholesaler);
	}



	@Override
	public void deleteWholesaler(Long id) {
		Wholesaler wholesaler = wholesalerRepository.getById(id);
		wholesalerRepository.delete(wholesaler);
		
	}



	@Override
	public List<WholesalerCreateDto> findAllByCompanyName(String companyName) {
		
		return this.wholesalerRepository.findAllByCompanyName(companyName).stream().map(WholesalerCreateDto::of).collect(Collectors.toList());
	}



	@Override
	public List<ProductsBroughtByTheWholesaler> findAllByWholesaler_CompanyName(String companyName) {
		
		return this.productRepository.findAllByWholesaler_CompanyName(companyName).stream().map(ProductsBroughtByTheWholesaler::of).collect(Collectors.toList());
	}



	@Override
	public List<WholesalerCreateDto> findAllByWholesalerId(Long id) {
		
		return wholesalerRepository.findAllByWholesalerId(id).stream().map(WholesalerCreateDto::of).collect(Collectors.toList());
	}



	
	
	

}
