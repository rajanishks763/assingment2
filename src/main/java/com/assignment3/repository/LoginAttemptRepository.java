package com.assignment3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment3.entity.LoginAttempt;

public interface LoginAttemptRepository extends JpaRepository<LoginAttempt, Long> {

	List<LoginAttempt> findByEmail(String email);

}
