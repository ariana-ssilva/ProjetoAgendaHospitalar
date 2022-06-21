package br.com.entra21.model2022.main.enter.menu.logado;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.entra21.model2022.main.Menu;
import br.com.entra21.model2022.main.enter.registration.menu.RegistrationMenu;


public class MainMenu extends Menu {

	public MainMenu(String title, ArrayList<String> options) {
		super(title, options); 
	}
	
	@Override
	public byte captureOption() {

		byte option = super.captureOption();
		switch (option) {
		case 0:
			System.exit(option);
			break;
		
		case 1: 

			new RegistrationMenu("REGISTRATION", new ArrayList<String>(Arrays.asList("Doctor", "Patient", "Agenda"))).executeMenu(); 
			break;
		case 2:
		//	new Menu
		default:
			System.out.println("Option invalid to menu " + super.getTitle());
			break;
		}
		return option;
	}



}
