package com.example.market.dtos;

import com.example.market.entities.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	private Long employeeId;
	private String employeeFirstName;
	private String employeeLastName;
	private String employeePhoneNumber;
	private String branchOffice;
	private Double salary;
	private String mission;
	private Long adminId;
	
	public static EmployeeDto of(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmployeeId(employee.getEmployeeId());
		employeeDto.setEmployeeFirstName(employee.getEmployeeFirstName());
		employeeDto.setEmployeeLastName(employee.getEmployeeLastName());
		employeeDto.setEmployeePhoneNumber(employee.getEmployeePhoneNumber());
		employeeDto.setBranchOffice(employee.getBranchOffice());
		employeeDto.setSalary(employee.getSalary());
		employeeDto.setMission(employee.getMission());
		employeeDto.setAdminId(employee.getAdmin().getAdminId());
		return employeeDto;
	}

}
