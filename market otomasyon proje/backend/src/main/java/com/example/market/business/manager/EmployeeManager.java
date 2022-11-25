package com.example.market.business.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.business.service.EmployeeService;
import com.example.market.dtos.EmployeeDto;
import com.example.market.entities.Admin;
import com.example.market.entities.Employee;
import com.example.market.repository.AdminRepository;
import com.example.market.repository.EmployeeRepository;
@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	private AdminRepository adminRepository;
	
	@Autowired
	public EmployeeManager(EmployeeRepository employeeRepository, AdminRepository adminRepository) {
		this.employeeRepository = employeeRepository;
		this.adminRepository = adminRepository;
	}


	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		Admin admin = adminRepository.getById(employeeDto.getAdminId());
		Employee employee = employeeRepository.save(new Employee(employeeDto.getEmployeeFirstName(), employeeDto.getEmployeeLastName(),
				employeeDto.getEmployeePhoneNumber(), employeeDto.getBranchOffice(), employeeDto.getSalary(),employeeDto.getMission(), admin));		
		return EmployeeDto.of(employee);
	}

	
	@Override
	public List<EmployeeDto> getAll() {		
		return this.employeeRepository.findAll().stream().map(EmployeeDto::of).collect(Collectors.toList());
	}
	

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
		Employee employee = employeeRepository.getById(id);
		employee.setEmployeeFirstName(employeeDto.getEmployeeFirstName());
		employee.setEmployeeLastName(employeeDto.getEmployeeLastName());
		employee.setEmployeePhoneNumber(employeeDto.getEmployeePhoneNumber());
		employee.setBranchOffice(employeeDto.getBranchOffice());
		employee.setSalary(employeeDto.getSalary());
		employee.setMission(employeeDto.getMission());
		Employee updateEmploye = employeeRepository.save(employee);
		
		return EmployeeDto.of(updateEmploye);
	}

	
	
	@Override
	public void deleteEmployee(Long id) {
		Employee employee = employeeRepository.getById(id);
		employeeRepository.delete(employee);
		
	}


	@Override
	public List<EmployeeDto> getBySalary(Double salary) {
		
		return this.employeeRepository.getBySalary(salary).stream().map(EmployeeDto::of).collect(Collectors.toList());
	}


	@Override
	public List<EmployeeDto> getByMission(String mission) {
		
		return this.employeeRepository.getByMission(mission).stream().map(EmployeeDto::of).collect(Collectors.toList());
	}


	@Override
	public List<EmployeeDto> getByBranchOffice(String branchOffice) {
		
		return this.employeeRepository.getByBranchOffice(branchOffice).stream().map(EmployeeDto::of).collect(Collectors.toList());
	}


	@Override
	public List<EmployeeDto> findByEmployeeId(Long id) {
		
		return employeeRepository.findAllByEmployeeId(id).stream().map(EmployeeDto::of).collect(Collectors.toList());
	}

}
