package com.example.market.dtos;

import com.example.market.entities.Wholesaler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WholesalerCreateDto {
	
	private Long wholesalerId;
	
	private String companyName;
	
	private String phoneNumber;
	
	private String address;
	
	private Long adminId;
	
	
	public static WholesalerCreateDto of (Wholesaler wholesaler) {
		WholesalerCreateDto wholesalerCreateDto = new WholesalerCreateDto();
		wholesalerCreateDto.setWholesalerId(wholesaler.getWholesalerId());
		wholesalerCreateDto.setCompanyName(wholesaler.getCompanyName());
		wholesalerCreateDto.setPhoneNumber(wholesaler.getPhoneNumber());
		wholesalerCreateDto.setAddress(wholesaler.getAddress());
		wholesalerCreateDto.setAdminId(wholesaler.getAdmin().getAdminId());
		return wholesalerCreateDto;
	}

}
