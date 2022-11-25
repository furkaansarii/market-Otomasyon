package com.example.market.business.manager;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.business.service.AdminService;
import com.example.market.dtos.AdminDto;

import com.example.market.entities.Admin;
import com.example.market.repository.AdminRepository;
@Service
public class AdminManager implements AdminService{
	
	private AdminRepository adminRepository;
	
	@Autowired
	public AdminManager(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	@Override
	public AdminDto addAdmin(AdminDto adminDto) {
		Admin admin = adminRepository.save(new Admin(adminDto.getUserName(),adminDto.getPassword()));
		return AdminDto.of(admin);
	}

	@Override
	public List<AdminDto> getAll() {
		return this.adminRepository.findAll().stream().map(AdminDto::of).collect(Collectors.toList());
	}

	@Override
	public AdminDto updateAdmin(Long id, AdminDto adminDto) {
		Admin admin = adminRepository.getById(id);
		admin.setUserName(adminDto.getUserName());
		admin.setPassword(adminDto.getPassword());
		Admin updatedAdmin = adminRepository.save(admin);
		
		return AdminDto.of(updatedAdmin);
	}

	@Override
	public void deleteAdmin(Long id) {
		Admin admin = adminRepository.getById(id);
		adminRepository.delete(admin);
		
	}
	
	

}
