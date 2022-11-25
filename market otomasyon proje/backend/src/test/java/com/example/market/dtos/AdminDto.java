package com.example.market.dtos;

import com.example.market.entities.Admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
	
	private String userName;
	private String password;
	
	public static AdminDto of(Admin admin) {
		AdminDto adminDto = new AdminDto();
		adminDto.setUserName(admin.getUserName());
		adminDto.setPassword(admin.getPassword());
		return adminDto;
	}

}
