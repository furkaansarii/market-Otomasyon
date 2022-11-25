
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.business.service.WholesalerService;
import com.example.market.dtos.ProductsBroughtByTheWholesaler;
import com.example.market.dtos.WholesalerCreateDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/wholesaler")
public class WholesalerController {
	
	private WholesalerService wholesalerService;

	@Autowired
	public WholesalerController(WholesalerService wholesalerService) {
		super();
		this.wholesalerService = wholesalerService;
	}
	
	@PostMapping
	public WholesalerCreateDto add(@RequestBody WholesalerCreateDto wholesalerCreateDto) {
		return this.wholesalerService.add(wholesalerCreateDto);
	}
	
	@GetMapping
	public List<WholesalerCreateDto> getAll(){
		return this.wholesalerService.getAll();
	}
	@PutMapping("{id}")
	public WholesalerCreateDto update(@PathVariable Long id, @RequestBody WholesalerCreateDto wholesalerCreateDto) {
		return this.wholesalerService.update(id, wholesalerCreateDto);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		this.wholesalerService.deleteWholesaler(id);
	}
	
	@GetMapping("/wholesaler-name")
	public List<WholesalerCreateDto> findAllByCompanyName(@RequestParam String companyName){
		return this.wholesalerService.findAllByCompanyName(companyName);
	}
	@GetMapping("/wholesaler-getPrdouct")
	public List<ProductsBroughtByTheWholesaler> findAllByWholesaler_CompanyName(@RequestParam String companyName){
		return this.wholesalerService.findAllByWholesaler_CompanyName(companyName);
	}
	@GetMapping("{id}")
	public List<WholesalerCreateDto> findAllByWholesalerId(@PathVariable Long id){
		return wholesalerService.findAllByWholesalerId(id);
	}
	
	

}
