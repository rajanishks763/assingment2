package com.assignment3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assignment3.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
	@Query(value = "select * from user where email=:email", nativeQuery = true)
	Optional <User> findByEmail(@Param("email") String email);
	Optional<User> findByEmailOrMobile(String email, String mobile);
	Optional<User> findByMobile(String mobile);
	Boolean existsByEmail(String email);
	Boolean existsByMobile(String mobile);
	@Query(value = "select * from user where id=:id", nativeQuery = true)
	Optional<List<User>> findByUserId(long id);
	
}
