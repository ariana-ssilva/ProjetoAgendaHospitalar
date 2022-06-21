package br.com.entra21.model2022.main.basemodel;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Patient extends Person {

	private String patology;
	private LocalDate registrationDate;
	private LocalDateTime updatedDate;
	private String password;
	
	public Patient() {
	}

	public Patient(String patology, LocalDate registrationDate, LocalDateTime updatedDate, String password) {
		super();
		this.patology = patology;
		this.registrationDate = registrationDate;
		this.updatedDate = updatedDate;
		this.password = password;
	}

	public Patient(String name, byte age, String sex, String cpf, String nameMother, String nameFather, String email,
			String telephone, String streetAddress, String numberAddress, String zipCode, String city, String state,
			String country, String patology, LocalDate registrationDate, LocalDateTime updatedDate, String password) {
		super(name, age, sex, cpf, nameMother, nameFather, email, telephone, streetAddress, numberAddress, zipCode,
				city, state, country);
		this.patology = patology;
		this.registrationDate = registrationDate;
		this.updatedDate = updatedDate;
		this.password = password;
	}

	public String toString() {
		return getName() + ":\n Patology: " + getPatology() + "\n Registration date: " + registrationDate
				+ "\n Updating date:" + updatedDate + "\n CPF: " + getCpf();
	}

	public String getPatology() {
		return patology;
	}

	public void setPatology(String patology) {
		this.patology = patology;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
