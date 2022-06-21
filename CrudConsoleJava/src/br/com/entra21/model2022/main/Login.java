package br.com.entra21.model2022.main;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import br.com.entra21.model2022.main.basemodel.Admin;
import br.com.entra21.model2022.main.basemodel.Patient;
import br.com.entra21.model2022.main.enter.menu.logado.MainMenu;
import br.com.entra21.model2022.main.enter.registration.menu.crud.CRUDAdmin;
import br.com.entra21.model2022.main.enter.registration.menu.crud.CRUDPatient;
import br.com.entra21.modelo2022.error.validator.WrongPasswordException;

public class Login {

	static Scanner input = new Scanner(System.in);

	public static Admin loggedIn = null;

	public static void enter(byte attempt) {
		if (attempt == 0) {
			System.out.println("Is not possible to login, all the attemps failed");
			return;
		} else {
			System.out.println((attempt > 1 ? "Remain " : "Resta ") + attempt + (attempt > 1 ? " attempts" : " attempt")
					+ " de login:");
		}
		try {
			System.out.println("Enter the user login:");
			Admin admin = Database.admin.get(input.next().trim());

			System.out.println("User found : " + admin.getLogin());
			System.out.println("Enter the password to release access:");

			if (!admin.getPassword().equals(input.next())) {
				throw new WrongPasswordException();
			} else {
				checkPassword(admin);
				return;
			}
		} catch (NullPointerException e) {
			System.out.println("No users found with this login ");
			enter(--attempt);
			return;
		} catch (WrongPasswordException e) {
			System.out.println(e.getMessage());
			enter(--attempt);
			return;
		}

	}

	public static void register(byte attempt) {

		String login;
		String password;
		if (attempt == 0) {
			System.out.println("It was'nt possible to registrate, all the attempts failed!");
			return;
		} else {
			System.out.println((attempt > 1 ? "Remains " : "Remain ") + attempt
					+ (attempt > 1 ? " attempts" : " attempt") + " to registrate:");
		}
		try {
			System.out.println("Enter the new user's login:");
			login = input.next().trim();
			Admin admin = Database.admin.get(login);

			if (admin != null) {
				throw new WrongPasswordException();
			} else {

				admin = new CRUDAdmin().captureValue();
				admin.setLogin(login);
				System.out.println("Enter the password:");
				password = input.next();
				admin.setPassword(password);

				Database.admin.put(login, admin);
			}

			System.out.println("User registered, please login!");

			return;

		} catch (WrongPasswordException e) {
			System.out.println(e.getMessage());
			register(--attempt);
			return;
		}

	}

	public static void recoverPassword(byte attempt) {

		if (attempt == 0) {
			System.out.println("It was'nt possible to recover the password, all the attemps failed");
			return;
		} else {
			System.out.println((attempt > 1 ? "Remains " : "Remain ") + attempt
					+ (attempt > 1 ? " attempts" : " attempt") + " to recover the password:");
		}
		try {
			System.out.println("Enter the admin login:");
			Admin admin = Database.admin.get(input.next().trim());

			System.out.println("User found :" + admin.getLogin());
			Database.admin.put(admin.getLogin(), admin);
			System.out.println("The password was updated");

			System.out.println("User Admin updated, please, login again");

		} catch (NullPointerException e) {
			System.out.println("User not found with this CPF ");
			recoverPassword(--attempt);
			return;
		}
	}

	public static void checkPassword(Admin admin) {

		defineAdminLogged(admin);

		new MainMenu("MAIN", new ArrayList<String>(Arrays.asList("Crud"))).executeMainMenu();

		defineAdminLogged(null);
	}

	public static void defineAdminLogged(Admin admin) {

		if (admin != null) {

			System.out.println("\nWelcome,, " + admin.getLogin());
		} else {
			System.out.println("Until next time " + admin.getLogin() + ", come back whenever you need.");
		}
		loggedIn = admin;

	}

	private static void updatePassword(Admin admin) {

		System.out.println("Update your password");
		admin.setPassword(input.next());
		checkPassword(admin);

	}

	public static void showInfoAbout() {
		System.out.println("|---------------------------------- ABOUT ---------------------------------------|");

		System.out.println("The program comes to smooth the way for scheduling of medical appointments for the\n"
				+ " patient with professionals from different areas of health.\r\n"
				+ "We will initially have three profiles, the Patient, the Doctor (which can be any\n"
				+ " health professional) and the Admin.\n"
				+ " To use the program, you just need to register, informing common data such as\n"
				+ " name, CPF (for the health professional, you will also need the CRM, CRE, CRO or CRP number for\n"
				+ " example), address for example.\r\n"
				+ "Both profiles will be able to register and log in to the platform. Patients will be able \n"
				+ "to look for which doctor will be available at the time they need, they will be able to see their own\n"
				+ " appointments, change their dates and times, change professionals or even cancel an appointment.\n"
				+ " The doctor, on the other hand, will be able to share schedules and days available for patient care,\n"
				+ " view their appointments for the day and cancel a pre-scheduled appointment.\r\n");
		System.out.println("\n|--------------------------------------------------------------------------------|\n");

	}

}
