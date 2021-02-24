package com.gabriel.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.main.domain.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer>{

}
