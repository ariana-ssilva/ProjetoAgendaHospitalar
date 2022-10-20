package br.com.entra21.model2022.main.enter.registration.menu.crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import br.com.entra21.model2022.main.Database;
import br.com.entra21.model2022.main.Login;
import br.com.entra21.model2022.main.Menu;
import br.com.entra21.model2022.main.basemodel.Agenda;
import br.com.entra21.model2022.main.basemodel.Doctor;
import br.com.entra21.model2022.main.basemodel.Patient;

public class CRUDAgenda extends Menu implements ICrud<Agenda> {
	private HashMap<String, Patient> listPatients = Database.patients;
	private HashMap<String, Doctor> listDoctors = Database.doctors;
	private HashMap<String, Agenda> list = Database.agendas;

	public CRUDAgenda() {
		super(" Agenda  ", options);
	}

	public byte capturaroption() {
		byte option = super.captureOption();

		switch (option) {

		case 0:
			System.out.println("Back to registration menu...");
			break;
		case 1:
			list(list);
			break;
		case 2:
			add();
			break;
		case 3:
			showDetails(search(captureKey()));
			break;
		case 4:
			edit(captureKey());
			break;
		case 5:
			delete(captureKey());
			break;

		default:
			System.out.println("Invalid option to " + super.getTitle() + " menu");
			break;

		}

		return option;
	}

	public CRUDAgenda(String title, ArrayList<String> options) {
		super(title, options);

	}

	@Override
	public void list(HashMap<String, Agenda> list) {
		System.out.println(
				"|------------------------------- LIST " + getTitle() + "---------------------------------|");
		System.out.println("\t|-------- PATIENT ------  DATE ------ DOCTOR-----|");
		for (Agenda agenda : list.values()) {
			System.out.println("\t" + agenda.getId() + " - " + agenda.getPatient().getName() + " - "
					+ agenda.getDateAgenda() + " - " + agenda.getDoctor().getName());
		}
		System.out.println("|------------------------------- QUANTITY (" + list.size()
				+ ") ---------------------------------|");
		System.out.println("|--------------------------------------------------------------------------------|\n");
	}

	@Override
	public void add() {
		Agenda agenda = captureValue();
		if (search(agenda) == null) {
			list.put(String.valueOf(agenda.getId()), agenda);
		} else {
			System.out.println("A regsitry with the key: " + agenda.getId() + " already existis.");
		}
	}

	@Override
	public Agenda search(Agenda key) {
		return list.get(String.valueOf(key.getId()));
	}

	@Override
	public void edit(Agenda key) {
		Agenda currentAgenda = search(key);
		if (currentAgenda == null) {
			System.out.println("There isn't a registry with the  key: " + currentAgenda.getId());
		} else {
			list.put(String.valueOf(key.getId()), capturarValoresEditar());
			System.out.println("Data updated");
		}
	}

	@Override
	public void delete(Agenda key) {
		Agenda currentAgenda = search(key);
		if (currentAgenda == null) {
			System.out.println("There isn't a registry with the  key: " + currentAgenda.getId());
		} else {
			list.remove(String.valueOf(key.getId()));
			System.out.println("Deleted!");
		}
	}

	@Override
	public Agenda captureKey() {
		Agenda agenda = new Agenda();
		System.out.println("Enter a key: ");
		agenda.setId(super.getInput().nextInt());

		return agenda;
	}

	public Doctor captureDoctorKey() {
		Doctor agenda = new Doctor();
		System.out.println("Enter the doctor CPF: ");
		agenda.setCpf(super.getInput().next().replaceAll("\\p{Punct}", ""));

		return agenda;
	}

	public Patient capturePatientKey() {
		Patient agenda = new Patient();
		System.out.println("enter the patient CPF: ");
		agenda.setCpf(super.getInput().next().replaceAll("\\p{Punct}", ""));

		return agenda;
	}

	public Agenda captureEditValues() {

		Agenda agenda = search(captureKey());
		Scanner input = new Scanner(System.in);

		byte option;
		do {
			System.out.println("Enter the field's number to edit: " + agenda.getId());
			System.out.println("0 - Exit");
			System.out.println("1 - Doctor");
			System.out.println("2 - Patient");
			System.out.println("3 - Date");
			option = input.nextByte();

			switch (option) {
			case 1:
				agenda.setDoctor(null);
				System.out.println("Doctor changed sucessfully!");
				break;
			case 2:
				agenda.setPatient(null);
				System.out.println("Patient changed sucessfully!");
				break;
			case 3:
				agenda.setDateAgenda(getInput().next());
				System.out.println("Date changed sucessfully!");
				break;

			default:
				System.out.println("Enter a valid option!");
				break;
			}

		} while (option != 0);

		agenda.setDoctor(searchMedico(captureDoctorKey()));
		agenda.setPatient(searchPaciente(capturePatientKey()));
		System.out.println("Enter the agenda date: ");
		agenda.setDateAgenda(super.getInput().next());

		System.out.println("An appointment has been scheduled");
		System.out.println("An appointment has been scheduled: \nCode: " + agenda.getId() + "\nWith the doctor: "
				+ agenda.getDoctor().getName() + "\nin : " + agenda.getDateAgenda() + "\nWith the pacient: "
				+ agenda.getPatient().getName());

		return agenda;
	}

	@Override
	public Agenda captureValue() {

		Agenda agenda = new Agenda();

		if (agenda.getId() < list.size()) {
			agenda.setId(list.size() + 1);
		} else {

		}
		listarMedico(listaMedico);

		agenda.setMedico(searchMedico(capturarkeyMedico()));
		agenda.setPaciente(searchPaciente(capturarkeyPaciente()));
		System.out.println("Informe a data do Agendamento: ");
		agenda.setDataAgendamento(super.getInput().next());

		System.out.println("|--------------------------------------------------------------------------------|");
		System.out.println("Foi agendando uma consulta: \nCodigo: " + agenda.getId() + " \nCom o medico: "
				+ agenda.getMedico().getName() + "\nNo dia: " + agenda.getDataAgendamento() + " \nCom o paciente: "
				+ agenda.getPaciente().getName());

		return agenda;
	}

	@Override
	public void exibirDetalhes(Agenda completo) {

		if (completo == null) {
			System.out.println("Nao foi possivel exibir os detalhes, item nao localizado");
		} else {
			System.out.println(completo.toString());
		}

	}

	public void listarMedico(HashMap<String, Doctor> listaMedico) {
		System.out.println("------------- LISTA " + gettitle() + "-----------------");
		System.out.println("|---------- CPF ----------  NOME ------ ESPECIALIDADE---|");
		for (Doctor medico : listaMedico.values()) {

			System.out.println("\t" + medico.getCpf() + " - " + medico.getName() + " - " + medico.getEspecialidade());

		}
		System.out.println("|------------------------------- QUANTIDADE (" + listaMedico.size()
				+ ") ---------------------------------|");
		System.out.println("|--------------------------------------------------------------------------------|\n");

	}

	public Doctor searchMedico(Doctor key) {
		return listaMedico.get(key.getCpf());
	}

	public Patient searchPaciente(Patient key) {
		return listaPaciente.get(key.getCpf());
	}
}
