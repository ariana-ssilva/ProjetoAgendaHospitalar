package br.com.entra21.model2022.main.enter.menu;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.entra21.model2022.main.Menu;
import br.com.entra21.model2022.main.enter.registration.menu.RegistrationMenu;

public class EnterMenu {

	public static void enter() {

		new RegistrationMenu("Registration", new ArrayList<String>(Arrays.asList("Doctors", "Patients", "Agendas")))
				.executeMenu();
	}

}