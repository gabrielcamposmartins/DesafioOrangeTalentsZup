package com.gabriel.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.main.domain.User;
import com.gabriel.main.domain.Vaccine;
import com.gabriel.main.dto.VaccineDto;
import com.gabriel.main.repositories.UserRepository;
import com.gabriel.main.repositories.VaccineRepository;
import com.gabriel.main.services.exception.BadRequestException;
import com.gabriel.main.services.exception.ObjectNotFoundException;

@Service
public class VaccineService {
	
	@Autowired
	VaccineRepository vaccineRepo;
	@Autowired
	UserRepository userRepo;
	
	public Vaccine insert(VaccineDto vaccineDto) {
		System.out.println(vaccineDto.toString());
		if(vaccineDto.getUser_id() == 0) {
			throw new BadRequestException("User id must not be null");
		}
		Vaccine vaccine = new Vaccine(vaccineDto.getName(), vaccineDto.getDate());
		User user = new User();
		try {
			user = userRepo.findById(vaccineDto.getUser_id()).get();
		} catch (Exception e) {
			throw new ObjectNotFoundException("Not Found");
		}
		
		user.addVaccine(vaccine);
		System.out.println(user.getVaccines().toString());
		try {
			vaccine = vaccineRepo.save(vaccine);
			userRepo.save(user);			
		} catch (Exception e) {
			throw new BadRequestException("Could not save objects");
		}
		return vaccine;
	}
}
