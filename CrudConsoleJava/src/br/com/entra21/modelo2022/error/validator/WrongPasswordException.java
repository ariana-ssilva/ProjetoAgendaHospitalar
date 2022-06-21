package br.com.entra21.modelo2022.error.validator;

public class WrongPasswordException extends Exception {

	public WrongPasswordException() {
		super("A senha informada esta incorreta, tente novamente.");
	}
}
