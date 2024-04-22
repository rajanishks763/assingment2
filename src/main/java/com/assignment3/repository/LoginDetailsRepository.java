package com.assignment3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment3.entity.LoginDetails;

public interface LoginDetailsRepository extends JpaRepository<LoginDetails, Long>{
	public Optional<LoginDetails> findByEmail(String email);

}
