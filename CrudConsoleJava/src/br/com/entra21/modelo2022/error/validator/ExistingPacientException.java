package br.com.entra21.modelo2022.error.validator;

public class ExistingPacientException extends Exception{
	public ExistingPacientException() {
		super("\"Nao e possivel utilizar esse CPF, pois ja esta em uso.");
	}

}
