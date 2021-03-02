package com.gabriel.main.dto;

import java.time.LocalDate;

import com.gabriel.main.domain.Vaccine;

public class VaccineDto {
	private int id;
	private long user_id;
	private String name;
	private LocalDate date;
		
	public VaccineDto() {}

	public VaccineDto(long user_id, String name, LocalDate date) {
		this.user_id = user_id;
		this.name = name;
		this.date = date;
	}
	
	public VaccineDto(String name, LocalDate date) {
		this.name = name;
		this.date = date;
	}

	public VaccineDto(Vaccine vaccine) {
		this.id = vaccine.getId();
		this.name = vaccine.getName();
		this.date = vaccine.getDate();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "VaccineDto [id=" + id + ", user_id=" + user_id + ", name=" + name + ", date="
				+ date + "]";
	}
	
	
}
