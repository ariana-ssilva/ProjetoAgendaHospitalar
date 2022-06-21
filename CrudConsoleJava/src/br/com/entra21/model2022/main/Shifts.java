package br.com.entra21.model2022.main;

import java.text.SimpleDateFormat;

public enum Shifts {

	MORNING("08:30"), MORNING_END("12:50"), AFTERNOON("12:51"), AFTERNOON_END("18:50"), NIGHT("18:51"), NIGHT_END("23:50");

	private final String SHIFT;

	private Shifts(String SHIFT) {
		this.SHIFT = SHIFT;
	}

	public String getSHIFT() {
		return this.SHIFT;
	}

}
