package br.com.entra21.model2022.main.basemodel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Agenda {

	private int id;
	private Patient patient;
	private Doctor doctor;
	private String DateAgenda;
	private String CancellationDate;

	public Agenda() {
		super();
	}

	public Agenda(int id, Patient patient, Doctor doctor, String dateAgenda, String cancellationDate) {
		super();
		this.id = id;
		this.patient = patient;
		this.doctor = doctor;
		DateAgenda = dateAgenda;
		CancellationDate = cancellationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getDateAgenda() {
		return DateAgenda;
	}

	public void setDateAgenda(String dateAgenda) {
		DateAgenda = dateAgenda;
	}

	public String getCancellationDate() {
		return CancellationDate;
	}

	public void setCancellationDate(String cancellationDate) {
		CancellationDate = cancellationDate;
	}

	public String toString() {
		return "Doctor: " + getDoctor().getName() + "\nPatient: " + getPatient() + "\nAgenda ID: " + getId()
				+ " on: " + getDateAgenda();
	}

}