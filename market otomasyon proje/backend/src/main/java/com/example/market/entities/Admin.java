package com.example.market.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long adminId;
	private String userName;
	private String password;
	
	@OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
	private List<Employee> employees;
	
	@OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
	private List<Product> products;
	
	@OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
	private List<ProductSales> productSales;
	
	@OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
	private List<Wholesaler> wholesalers;
	
	public Admin(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

}
