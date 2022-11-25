package com.example.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.market.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

}
