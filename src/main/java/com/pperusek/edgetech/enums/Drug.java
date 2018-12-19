package com.pperusek.edgetech.enums;

import java.util.Arrays;

public enum Drug {
	Aspirin("As"), Antibiotic("An"), Insulin("I"), Paracetamol("P");

	private String textRepresentation;

	private Drug(String text) {
		this.textRepresentation = text;
	}

	public static Drug fromString(String text) {
		return Arrays.stream(Drug.values())
			.filter(v -> v.textRepresentation.equals(text))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("unknown Drug value: " + text));
		// TODO have to define better exception
	}
}
