package com.gabriel.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.main.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
