package com.gabriel.main.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabriel.main.domain.Vaccine;
import com.gabriel.main.dto.VaccineDto;
import com.gabriel.main.services.VaccineService;

@RestController
@RequestMapping(value="/vaccine")
public class VaccineResource {

	@Autowired
	VaccineService vaccineService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody VaccineDto vaccineDto) throws Exception{
		System.out.println(vaccineDto);
		Vaccine vaccine = vaccineService.insert(vaccineDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/vaccine").buildAndExpand(vaccine.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
