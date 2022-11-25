package com.example.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.business.service.AdminService;
import com.example.market.dtos.AdminDto;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	private AdminService adminService;

	@Autowired
	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	@PostMapping("/admin")
	public AdminDto addAdmin(@RequestBody AdminDto adminDto) {
		return this.adminService.addAdmin(adminDto);
	}
	
	@GetMapping("/admin/")
	public List<AdminDto> getAll(){
		return this.adminService.getAll();
	}
	
	@PutMapping("/admin/{id}")
	AdminDto updateAdmin(@PathVariable Long id, @RequestBody AdminDto adminDto) {
		return this.adminService.updateAdmin(id, adminDto);
	}
	
	@DeleteMapping("/admin/{id}")
	public void deleteAdmin(@PathVariable Long id) {
		this.adminService.deleteAdmin(id);
	}
	
	

}
