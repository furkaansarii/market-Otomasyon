package com.example.market.business.service;

import java.util.List;

import com.example.market.dtos.EmployeeDto;


public interface EmployeeService {
	
	EmployeeDto addEmployee(EmployeeDto employeeDto);
	List<EmployeeDto> getAll();
	EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
	void deleteEmployee(Long id);
	List<EmployeeDto> getBySalary(Double salary);
	List<EmployeeDto> getByMission(String mission);
	List<EmployeeDto> getByBranchOffice(String branchOffice);
	List<EmployeeDto> findByEmployeeId(Long id);

}
