package br.com.entra21.model2022.main.enter.registration.menu.crud;

import static br.com.entra21.model2022.main.enter.registration.menu.crud.ICrud.opcoes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import br.com.entra21.model2022.main.Database;
import br.com.entra21.model2022.main.Menu;
import br.com.entra21.model2022.main.basemodel.Doctor;
import br.com.entra21.model2022.main.basemodel.Patient;
import br.com.entra21.model2022.main.basemodel.Person;

public class CRUDPatient extends Menu implements ICrud<Patient> {

	private HashMap<String, Patient> lista = Database.pacientes;

	public CRUDPatient() {
		super("Pacientes", opcoes);
	}

	@Override
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

	public CRUDPatient(String titulo, ArrayList<String> opcoes) {
		super(titulo, opcoes);
	}

	@Override
	public void listar(HashMap<String, Patient> lista) {
		System.out.println("|------------------------------ LISTA " + getTitulo() + " ----------------------------------|");
		System.out.println("|--------------------------------------------------------------------------------|\n");
		for (Patient paciente : lista.values()) {

			System.out.println("\t" + paciente.getName() + " - " + paciente.getPatologia() + " - " + paciente.getCpf());

		}

		System.out.println("|------------------------------- QUANTIDADE (" + lista.size() + ") ---------------------------------|");
		System.out.println("|--------------------------------------------------------------------------------|\n");
	}

	@Override
	public void adicionar() {
		Patient novo = capturarValoresAdd();
		if (buscar(novo) == null) {
			lista.put(novo.getCpf(), novo);
		} else {
			System.out.println("Ja existe um registro com CHAVE:" + novo.getName());

		}
	}

	@Override
	public Patient buscar(Patient chave) {
		return lista.get(chave.getCpf());

	}

	@Override
	public void editar(Patient chave) {
		Patient PacienteAtual = buscar(chave);
		if (PacienteAtual == null) {
			System.out.println("Nao existe um registro com CHAVE:" + chave.getCpf());
		} else {
			lista.put(chave.getCpf(), capturarValoresEditar());
			System.out.println("Dados atualizados");
		}

	}

	@Override
	public void deletar(Patient chave) {

		Patient PacienteAtual = buscar(chave);
		if (PacienteAtual == null) {
			System.out.println("Nao existe um registro com CHAVE:" + chave.getCpf());
		} else {
			lista.remove(chave.getCpf());
			System.out.println("Item excluido");
		}

	}

	@Override
	public Patient capturarChave() {
		Patient paciente = new Patient();
		System.out.println("Informe a CHAVE");
		paciente.setCpf(super.getEntrada().next().replaceAll("\\p{Punct}", ""));
		return paciente;

	}

	public Patient capturarValoresAdd() {

		Patient formulario = new Patient();

		System.out.println("Informe o Nome:");
		formulario.setName(super.getEntrada().next());

		System.out.println("Informe o Idade:");
		formulario.setAge(super.getEntrada().nextByte());

		System.out.println("Informe o Sexo:");
		formulario.setSex(super.getEntrada().next());

		System.out.println("Informe o CPF:");
		formulario.setCpf(super.getEntrada().next());
		
		System.out.println("Informe a Patologia");
		formulario.setPatologia(super.getEntrada().next());

		return formulario;

	}

	@Override
	public Patient capturarValores() {

		Scanner input = new Scanner(System.in);
		Patient formulario = buscar(capturarChave());
		byte option;

		do {
			System.out.println("Escolha qual informacao deseja alterar: ");
			System.out.println("0-Retornar");
			System.out.println("1-Nome");
			System.out.println("2-Idade");
			System.out.println("3-Sexo");
			System.out.println("4-Cpf");
			System.out.println("5-Nome da mae");
			System.out.println("6-Nome do pai");
			System.out.println("7-e-mail");
			System.out.println("8-Telefone");
			System.out.println("9-Nome da rua");
			System.out.println("10-Numero da casa");
			System.out.println("11-Codigo Postal");
			System.out.println("12-Cidade");
			System.out.println("13-Estado");
			System.out.println("14-Pais");
			option = input.nextByte();

			switch (option) {
			case 0:
				break;

			case 1:
				System.out.println("Informe o novo Nome:");
				formulario.setName(super.getEntrada().next());
				break;

			case 2:
				System.out.println("Informe o Idade:");
				formulario.setAge(super.getEntrada().nextByte());
				break;
			case 3:
				System.out.println("Informe o Sexo:");
				formulario.setSex(super.getEntrada().next());
				break;
			case 4:
				System.out.println("Informe o Cpf:");
				formulario.setCpf(super.getEntrada().next());
				break;
			case 5:
				System.out.println("Informe o Nome da Mae:");
				formulario.setNameMother(super.getEntrada().next());
				break;
			case 6:
				System.out.println("Informe o Nome do Pai:");
				formulario.setNameFather(super.getEntrada().next());
				break;
			case 7:
				System.out.println("Informe o e-mail:");
				formulario.setEmail(super.getEntrada().next());
				break;
			case 8:
				System.out.println("Informe o Telefone:");
				formulario.setTelephone(super.getEntrada().next());
				break;
			case 9:
				System.out.println("Informe o Nome da Rua:");
				formulario.setStreetAddress(super.getEntrada().next());
				break;
			case 10:
				System.out.println("Informe o Número da Casa:");
				formulario.setNumberAddress(super.getEntrada().next());
				break;
			case 11:
				System.out.println("Informe o Código Postal");
				formulario.setZipCode(super.getEntrada().next());
				break;
			case 12:
				System.out.println("Informe a Cidade:");
				formulario.setCity(super.getEntrada().next());
				break;
			case 13:
				System.out.println("Informe o Estado:");
				formulario.setState(super.getEntrada().next());
				break;
			case 14:
				System.out.println("Informe o Pais:");
				formulario.setCountry(super.getEntrada().next());

				break;

			default:
				System.out.println("Digite uma opcao valida!");
				break;
			}
		} while (option != 0);
		return formulario;

	}
	
	public Patient capturarValoresEditar() {

		Scanner input = new Scanner(System.in);
		Patient formulario = buscar(capturarChave());
		byte option;

		do {
			System.out.println("========================================");
			System.out.println("Escolha qual inforção deseja alterar: ");
			System.out.println("0-Retornar");
			System.out.println("1-Nome");
			System.out.println("2-Patologia");
			System.out.println("3-Idade");
			System.out.println("4-Sexo");
			System.out.println("5-Cpf");
			System.out.println("6-Nome da mãe");
			System.out.println("7-Nome do pai");
			System.out.println("8-e-mail");
			System.out.println("9-Telefone");
			System.out.println("10-Nome da rua");
			System.out.println("11-Numero da casa");
			System.out.println("12-Codigo Postal");
			System.out.println("13-Cidade");
			System.out.println("14-Estado");
			System.out.println("15-Pais");
			option = input.nextByte();

			switch (option) {
			case 0:
				System.out.println("Voltando...");
				break;
				
			case 1:
				System.out.println("Informe o novo Nome:");
				formulario.setName(super.getEntrada().next());
				break;
			case 2:
				System.out.println("Informe a Patologia:");
				formulario.setPatologia(super.getEntrada().next());
				break;
			case 3:
				System.out.println("Informe o Idade:");
				formulario.setAge(super.getEntrada().nextByte());
				break;
			case 4:
				System.out.println("Informe o Sexo:");
				formulario.setSex(super.getEntrada().next());
				break;
			case 5:
				System.out.println("Informe o Cpf:");
				formulario.setCpf(super.getEntrada().next());
				break;
			case 6:
				System.out.println("Informe o Nome da M�e:");
				formulario.setNameMother(super.getEntrada().next());
				break;
			case 7:
				System.out.println("Informe o Nome do Pai:");
				formulario.setNameFather(super.getEntrada().next());
				break;
			case 8:
				System.out.println("Informe o e-mail:");
				formulario.setEmail(super.getEntrada().next());
				break;
			case 10:
				System.out.println("Informe o Telefone:");
				formulario.setTelephone(super.getEntrada().next());
				break;
			case 11:
				System.out.println("Informe o Nome da Rua:");
				formulario.setStreetAddress(super.getEntrada().next());
				break;
			case 12:
				System.out.println("Informe o Número da Casa:");
				formulario.setNumberAddress(super.getEntrada().next());
				break;
			case 13:
				System.out.println("Informe o Código Postal");
				formulario.setZipCode(super.getEntrada().next());
				break;
			case 14:
				System.out.println("Informe a Cidade:");
				formulario.setCity(super.getEntrada().next());
				break;
			case 15:
				System.out.println("Informe o Estado:");
				formulario.setState(super.getEntrada().next());
				break;
			case 16:
				System.out.println("Informe o Pais:");
				formulario.setCountry(super.getEntrada().next());
				break;

			default:
				System.out.println("Digite uma opção valida!");
				break;
			}

		} while (option != 0);

		return formulario;

	}

	@Override
	public void exibirDetalhes(Patient completo) {
		if (completo == null) {
			System.out.println("Nao foi possivel exibir os detalhes");
		} else {
			System.out.println(completo.toString());
		}

	}

}
