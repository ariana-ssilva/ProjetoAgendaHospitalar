package br.com.entra21.model2022.main.enter.registration.menu;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.entra21.model2022.main.Menu;
import br.com.entra21.model2022.main.enter.registration.menu.crud.CRUDAgenda;
import br.com.entra21.model2022.main.enter.registration.menu.crud.CRUDDoctor;
import br.com.entra21.model2022.main.enter.registration.menu.crud.CRUDPatient;


public class RegistrationMenu extends Menu{

	public RegistrationMenu(String title, ArrayList<String> options) {
		super(title, options);
		
	}
	@Override
	public byte captureOption() {
		byte option = super.captureOption();

		switch (option) {
		case 1:
			new CRUDDoctor().executeMenu();
			break;

		case 2:
			new CRUDPatient().executeMenu();
			break;
			
		case 3:
			new CRUDAgenda().executeMenu();
			break;

		default:
			break;
		}
		return option;
	}
	
	
	
}
