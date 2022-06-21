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
	private HashMap<String, Patient> listaPaciente = Database.pacientes;
	private HashMap<String, Doctor> listaMedico = Database.medicos;
	private HashMap<String, Agenda> lista = Database.agendas;

	public CRUDAgenda() {
		super(" Agenda  ", opcoes);
	}

	public byte capturarOpcao() {
		byte opcao = super.capturarOpcao();

		switch (opcao) {

		case 0:
			System.out.println("Voltando ao menu Cadastro...");
			break;
		case 1:
			listar(lista);
			break;
		case 2:
			adicionar();
			break;
		case 3:
			exibirDetalhes(buscar(capturarChave()));
			break;
		case 4:
			editar(capturarChave());
			break;
		case 5:
			deletar(capturarChave());
			break;

		default:
			System.out.println("Opcao invalida para o menu de " + super.getTitulo());
			break;

		}

		return opcao;
	}

	public CRUDAgenda(String titulo, ArrayList<String> opcoes) {
		super(titulo, opcoes);

	}

	@Override
	public void listar(HashMap<String, Agenda> lista) {
		System.out.println(
				"|------------------------------- LISTA " + getTitulo() + "---------------------------------|");
		System.out.println("\t|-------- PACIENTE ------  DATA ------ MEDICO-----|");
		for (Agenda agenda : lista.values()) {
			System.out.println("\t" + agenda.getId() + " - " + agenda.getPaciente().getName() + " - "
					+ agenda.getDataAgendamento() + " - " + agenda.getMedico().getName());
		}
		System.out.println("|------------------------------- QUANTIDADE (" + lista.size()
				+ ") ---------------------------------|");
		System.out.println("|--------------------------------------------------------------------------------|\n");
	}

	@Override
	public void adicionar() {
		Agenda agenda = capturarValores();
		if (buscar(agenda) == null) {
			lista.put(String.valueOf(agenda.getId()), agenda);
		} else {
			System.out.println("Ja existe um registro com essa CHAVE: " + agenda.getId());
		}
	}

	@Override
	public Agenda buscar(Agenda chave) {
		return lista.get(String.valueOf(chave.getId()));
	}

	@Override
	public void editar(Agenda chave) {
		Agenda agendaAtual = buscar(chave);
		if (agendaAtual == null) {
			System.out.println("Nao existe um registro com essa CHAVE: " + agendaAtual.getId());
		} else {
			lista.put(String.valueOf(chave.getId()), capturarValoresEditar());
			System.out.println("Dados Atualizados");
		}
	}

	@Override
	public void deletar(Agenda chave) {
		Agenda agendaAtual = buscar(chave);
		if (agendaAtual == null) {
			System.out.println("Nao existe um registro com essa CHAVE: " + agendaAtual.getId());
		} else {
			lista.remove(String.valueOf(chave.getId()));
			System.out.println("Item excluido");
		}
	}

	@Override
	public Agenda capturarChave() {
		Agenda agenda = new Agenda();
		System.out.println("Informe a CHAVE: ");
		agenda.setId(super.getEntrada().nextInt());

		return agenda;
	}

	public Doctor capturarChaveMedico() {
		Doctor agenda = new Doctor();
		System.out.println("Informe o cpf do medico: ");
		agenda.setCpf(super.getEntrada().next().replaceAll("\\p{Punct}", ""));

		return agenda;
	}

	public Patient capturarChavePaciente() {
		Patient agenda = new Patient();
		System.out.println("Informe o cpf do paciente: ");
		agenda.setCpf(super.getEntrada().next().replaceAll("\\p{Punct}", ""));

		return agenda;
	}

	public Agenda capturarValoresEditar() {

		Agenda agenda = buscar(capturarChave());
		Scanner input = new Scanner(System.in);

		byte option;
		do {
			System.out.println("Informe qual dado deseja alterar do agendamento: " + agenda.getId());
			System.out.println("0 - Sair");
			System.out.println("1 - Medico");
			System.out.println("2 - Paciente");
			System.out.println("3 - Data");
			option = input.nextByte();

			switch (option) {
			case 1:
				agenda.setMedico(buscarMedico(capturarChaveMedico()));
				System.out.println("Medico alterado com sucesso!");
				break;
			case 2:
				agenda.setPaciente(buscarPaciente(capturarChavePaciente()));
				System.out.println("Paciente alterado com sucesso!");
				break;
			case 3:
				agenda.setDataAgendamento(getEntrada().next());
				System.out.println("Data alterada com sucesso!");
				break;

			default:
				System.out.println("Selecione uma opcao valida");
				break;
			}

		} while (option != 0);

		agenda.setMedico(buscarMedico(capturarChaveMedico()));
		agenda.setPaciente(buscarPaciente(capturarChavePaciente()));
		System.out.println("Informe a data do Agendamento: ");
		agenda.setDataAgendamento(super.getEntrada().next());

		System.out.println("Foi agendando uma consulta: \nCodigo: " + agenda.getId() + "\nCom o medico: "
				+ agenda.getMedico().getName() + "\nNo dia: " + agenda.getDataAgendamento() + "\nCom o paciente: "
				+ agenda.getPaciente().getName());

		return agenda;
	}

	@Override
	public Agenda capturarValores() {

		Agenda agenda = new Agenda();

		if (agenda.getId() < lista.size()) {
			agenda.setId(lista.size() + 1);
		} else {

		}
		listarMedico(listaMedico);

		agenda.setMedico(buscarMedico(capturarChaveMedico()));
		agenda.setPaciente(buscarPaciente(capturarChavePaciente()));
		System.out.println("Informe a data do Agendamento: ");
		agenda.setDataAgendamento(super.getEntrada().next());

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
		System.out.println("------------- LISTA " + getTitulo() + "-----------------");
		System.out.println("|---------- CPF ----------  NOME ------ ESPECIALIDADE---|");
		for (Doctor medico : listaMedico.values()) {

			System.out.println("\t" + medico.getCpf() + " - " + medico.getName() + " - " + medico.getEspecialidade());

		}
		System.out.println("|------------------------------- QUANTIDADE (" + listaMedico.size()
				+ ") ---------------------------------|");
		System.out.println("|--------------------------------------------------------------------------------|\n");

	}

	public Doctor buscarMedico(Doctor chave) {
		return listaMedico.get(chave.getCpf());
	}

	public Patient buscarPaciente(Patient chave) {
		return listaPaciente.get(chave.getCpf());
	}
}
