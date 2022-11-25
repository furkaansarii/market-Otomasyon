package com.example.market.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wholesaler")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","product"})
public class Wholesaler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long wholesalerId;
	
	private String companyName;
	
	private String phoneNumber;
	
	private String address;
	
	@OneToMany(mappedBy = "wholesaler")
	private List<Product> products;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_id")
	private Admin admin;

	
	public Wholesaler(String companyName, String phoneNumber, String address, Admin admin) {
		super();
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.admin = admin;
	}
	
	
	

}
