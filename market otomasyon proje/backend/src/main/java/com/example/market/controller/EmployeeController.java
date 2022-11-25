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

import com.example.market.business.service.EmployeeService;
import com.example.market.dtos.EmployeeDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {
		return this.employeeService.addEmployee(employeeDto);
	}
	
	
	
	@GetMapping
	public List<EmployeeDto> getAll(){
		return this.employeeService.getAll();
	}
	
	@PutMapping("{id}")
	public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
		return this.employeeService.updateEmployee(id, employeeDto);
	}
	
	
	@DeleteMapping("{id}")
	public void deleteEmployee(@PathVariable Long id) {
		this.employeeService.deleteEmployee(id);
	}

	@GetMapping("/employee-getBySalary")
	public List<EmployeeDto> getBySalary(@RequestParam Double salary){
		return employeeService.getBySalary(salary);
	}
	
	@GetMapping("/employee-getByMission")
	public List<EmployeeDto> getByMission(@RequestParam String mission){
		return employeeService.getByMission(mission);
	}
	
	@GetMapping("/employee-getByBranchOffice")
	public List<EmployeeDto> getByBranchOffice(@RequestParam String branchOffice){
		return employeeService.getByBranchOffice(branchOffice);
	}
	
	@GetMapping("{id}")
	public List<EmployeeDto> findByEmployeeId(@PathVariable Long id){
		return employeeService.findByEmployeeId(id);
	}

}
