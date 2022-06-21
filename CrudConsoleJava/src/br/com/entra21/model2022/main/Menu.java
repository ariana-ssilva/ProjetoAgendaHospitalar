package br.com.entra21.model2022.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private Scanner input;
	private String title;
	private ArrayList<String> option;

	public Menu(String title, ArrayList<String> options) {
		super();
		this.input = new Scanner(System.in);
		this.title = title;
		this.option = options;
	}

	public void executeMenu() {
		do {
			System.out.println("|----------------------------- " + this.title + " MENU -----------------------------------|");
			System.out.println("\n|--------------------------------------------------------------------------------|");
			System.out.println("-1 = Close the program");
			System.out.println(" 0 = Back");

			if (option != null && !option.isEmpty()) {
				for (int counter = 0; counter < option.size(); counter++) {
					System.out.println(" " + (counter + 1) + " = " + option.get(counter));
				}
			} else {
				System.out.println("There are no itens for this menu");
			}

		} while (captureOption() != 0);
	}
	
	public void executeMainMenu() {
		do {
			System.out.println("|---------------------------- " + this.title + " MENU ------------------------------------|");
			System.out.println("\n|--------------------------------------------------------------------------------|");
			System.out.println(" 0 = Close the program");

			if (option != null && !option.isEmpty()) {
				for (int counter = 0; counter < option.size(); counter++) {
					System.out.println(" " + (counter + 1) + " = " + option.get(counter));
				}
			} else {
				System.out.println("There are no itens for this menu");
			}

		} while (captureOption() != 0);
	}

	public byte captureOption() {
		byte option;
		option = input.nextByte();

		switch (option) {

		case -1:
			System.exit(-1);
			break;
		case 0:
			System.out.println(this.title + " MENU finished");
			break;
		}
		return option;
	}

	public String getTitle() {
		return title;
	}

	public Scanner getInput() {
		return input;
	}
}
