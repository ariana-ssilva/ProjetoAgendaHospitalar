package br.com.entra21.model2022.main.enter.registration.menu.crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import br.com.entra21.model2022.main.Database;
import br.com.entra21.model2022.main.Menu;
import br.com.entra21.model2022.main.basemodel.Admin;
import br.com.entra21.model2022.main.basemodel.Doctor;

public class CRUDAdmin extends Menu implements ICrud<Admin> {

	
	private HashMap<String, Admin> list = Database.admin;

	public CRUDAdmin() {
		super("Admins", options);
	}

	@Override
	public byte captureOption() {
		byte option = super.captureOption();

		switch (option) {
		case 0:
			System.out.println("Back to Registration Menu...");
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
			System.out.println("Enter a valid option " + super.getTitle());
			break;
		}
		return option;
	}

	public CRUDAdmin(String title, ArrayList<String> options) {
		super(title, options);

	}

	@Override
	public void list(HashMap<String, Admin> list) {
		System.out
				.println("---------------------------- LIST " + getTitle() + "------------------------------------");
		System.out.println("\n|--------------------------------------------------------------------------------|");

		for (Admin admin : list.values()) {

			System.out.println("\t" + admin.getLogin());

		}

		System.out.println("|------------------------------- QUANTITY (" + list.size()
				+ ") ---------------------------------|");
		System.out.println("|--------------------------------------------------------------------------------|\n");

	}

	@Override
	public void add() {

		Admin theNew = captureValuesAdd();
		if (search(theNew) == null) {
			list.put(theNew.getLogin(), theNew);
		} else {
			System.out.println("A registry with the key " + theNew.getLogin() + "already exists.");
		}

	}

	@Override
	public Admin search(Admin key) {

		return list.get(key.getLogin());
	}

	@Override
	public void edit(Admin key) {

		Admin currentAdmin = search(key);
		if (currentAdmin == null) {
			System.out.println("There's not a registry with the key: "+ key.getLogin());
		} else {
			list.put(key.getLogin(), captureValue());
			System.out.println("Updated");
		}
	}

	@Override
	public void delete(Admin key) {

		Admin currentAdmin = search(key);
		if (currentAdmin == null) {
			System.out.println("There's not a registry with the key: "+ key.getLogin());
		} else {
			list.remove(key.getLogin());
			System.out.println("Deleted");
		}

	}

	@Override
	public Admin captureKey() {

		Admin form = new Admin();
		System.out.println("Enter the KEY");
		form.setLogin(super.getInput().next().replaceAll("\\p{Punct}", ""));
		return form;

	}

	public Admin captureValuesAdd() {

		Admin form = new Admin();

		System.out.println("Enter the name:");
		form.setLogin(super.getInput().next());

		System.out.println("Enter the CRM:");
		form.setPassword(super.getInput().next());

		return form;

	}

	@Override
	public Admin captureValue() {

		Admin form = new Admin();

		// System.out.println("Informe o theNew login:");
		// form.setLogin(super.getEntrada().next());

		// System.out.println("Informe a senha:");
		// form.setSenha(super.getEntrada().next());

		return form;

	}

	@Override
	public void showDetails(Admin complete) {

		if (complete == null) {
			System.out.println("It's not possible show details, item not found!");
		} else {
			System.out.println(complete.toString());
		}

	}

}
