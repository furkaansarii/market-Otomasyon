package com.example.market.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.market.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	List<Employee> getBySalary(Double salary);
	List<Employee> getByMission(String mission);
	List<Employee> getByBranchOffice(String branchOffice);
	List<Employee> findAllByEmployeeId(Long id);

}
