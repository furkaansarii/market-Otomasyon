package com.example.market.business.service;

import java.util.List;

import com.example.market.dtos.AdminDto;

public interface AdminService {
	
	AdminDto addAdmin(AdminDto adminDto);
	List<AdminDto> getAll();
	AdminDto updateAdmin(Long id, AdminDto adminDto);
	void deleteAdmin(Long id);
	

}
