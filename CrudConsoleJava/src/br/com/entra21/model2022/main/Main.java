package br.com.entra21.model2022.main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.entra21.model2022.main.enter.menu.EnterMenu;

public class Main {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<String> options;
	private static final byte ATTEMPT_LIMIT = 3;

	public static void main(String[] args) {

		Database.generateDataBase();

		byte option;
		do {
			System.out.println(generateMenu());
			try {
				option = input.nextByte();
			} catch (InputMismatchException e) {
				option = -2;
				input = new Scanner(System.in);
			}
			switch (option) {
			case 0:
				System.out.println("Until next time!");
				break;
			case 1:
				Login.enter(ATTEMPT_LIMIT);
				break;
			case 2:
				Login.register(ATTEMPT_LIMIT);
				break;
			case 3:
				Login.showInfoAbout();
				break;
			default:
				System.out.println("Choose a valid option");
				break;
			}
		} while (option != 0);
		System.out.println("Come back soon...");

	}

	private static String generateMenu() {
		if (options == null) {
			options = new ArrayList<>(Arrays.asList("Enter", "Register", "About"));
		}

		String menu = "|------------------ Welcome to the Hospital Agenda ------------------| ";
		menu += "\n Choose an option:";
		menu += "\n\t0 - Exit ";

		for (int option = 0; option < options.size(); option++) {
			menu += "\n\t" + (option + 1) + " - " + options.get(option);
		}

		menu += "\n|--------------------------------------------------------------------------------|";

		return menu;

	}

}
