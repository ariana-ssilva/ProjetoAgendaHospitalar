package br.com.entra21.model2022.main.basemodel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

import br.com.entra21.model2022.main.Shifts;

public class Doctor extends Person {
	private String specialty;
	private String crm;
	private Shifts shift;
	private Shifts shiftFinal;

	public Doctor() {
		super();

	}

	public Doctor(String name, byte age, String cpf) {
		super(name, age, cpf);

	}

	public Doctor(String specialty, String crm, Shifts shift, Shifts shiftFinal) {
		super();
		this.specialty = specialty;
		this.crm = crm;
		this.shift = shift;
		this.shiftFinal = shiftFinal;
	}

	public Doctor(String name, byte age, String sex, String cpf, String nameMother, String nameFather, String email,
			String telephone, String streetAddress, String numberAddress, String zipCode, String city, String state,
			String country, String specialty, String crm, Shifts shift, Shifts shiftFinal) {
		super(name, age, sex, cpf, nameMother, nameFather, email, telephone, streetAddress, numberAddress, zipCode,
				city, state, country);
		this.specialty = specialty;
		this.crm = crm;
		this.shift = shift;
		this.shiftFinal = shiftFinal;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Shifts getShift() {
		return shift;
	}

	public Shifts getShiftFinal() {
		return shiftFinal;
	}

	public void setShiftFinal(Shifts shiftFinal) {
		this.shiftFinal = shiftFinal;
	}

	public void setShift(Shifts string) {
		this.shift = string;

	}

	@Override
	public String toString() {
		return getName() + ":\n specialty: " + getSpecialty() + "\n crm: " + getCrm() + "\n shift: "
				+ getShift().getSHIFT() + " until " + getShiftFinal().getSHIFT() + "\n CPF: " + getCpf();
	}

}
