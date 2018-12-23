package com.pperusek.hospitalsim.enums;

import java.security.InvalidParameterException;
import java.util.Arrays;

/**
 * A drug type that can be used in a treatment.
 */
public enum Drug {
	Aspirin("As"), Antibiotic("An"), Insulin("I"), Paracetamol("P");

	/** Used when parsing from arguments. */
	private String textRepresentation;

	private Drug(String text) {
		this.textRepresentation = text;
	}

	/**
	 * Gets {@link Drug} based on a string.
	 * @param text representation
	 * @return drug represented by the text
	 */
	public static Drug fromString(String text) {
		return Arrays.stream(Drug.values())
			.filter(v -> v.textRepresentation.equals(text))
			.findFirst()
			.orElseThrow(() -> new InvalidParameterException("Unknown Drug value received: " + text));
	}
}
