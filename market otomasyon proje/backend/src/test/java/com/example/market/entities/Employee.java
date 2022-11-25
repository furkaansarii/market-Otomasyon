package com.example.market.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	@Column(name = "employee_first_name")
	private String employeeFirstName;
	
	@Column(name = "employee_last_name")
	private String employeeLastName;
	
	@Column(name = "employee_phone_number")
	private String employeePhoneNumber;

	@Column(name = "branch_office")
	private String branchOffice;
	
	@Column(name = "salary")
	private Double salary;
	
	@Column(name = "mission")
	private String mission;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_id")
	private Admin admin;

	public Employee(String employeeFirstName, String employeeLastName, String employeePhoneNumber, String branchOffice,
			Double salary, String mission, Admin admin) {

		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeePhoneNumber = employeePhoneNumber;
		this.branchOffice = branchOffice;
		this.salary = salary;
		this.mission = mission;
		this.admin = admin;
	}
	
	
	
	
	
	
}
