package com.gabriel.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.main.domain.User;
import com.gabriel.main.repositories.UserRepository;
import com.gabriel.main.services.exception.BadRequestException;

@Service

public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public User insert (User user) {
		
		if(user.getCpf() == null || user.getEmail() == null) {
			throw new BadRequestException("cpf and email must not be null");
		}
		
		try {
			user = repo.save(user);
		} catch (Exception e) {
			throw new BadRequestException("Unique key violation");
		}
		return user;
	}
}
