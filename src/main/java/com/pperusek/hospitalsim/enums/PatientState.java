package com.pperusek.hospitalsim.enums;

import java.security.InvalidParameterException;
import java.util.Arrays;

/**
 * Health state of a patient.
 */
public enum PatientState {
	Healthy("H", 0), Fever("F", 1), Diabetes("D", 2), Tuberculosis("T", 3), Dead("X", 4);

	/** Used when parsing from arguments. */
	private String textRepresentation;

	/** The higher the more severe. */
	private int severityLevel;

	private PatientState(String text, int severity) {
		this.textRepresentation = text;
		this.severityLevel = severity;
	}

	/**
	 * Compares severity level of 2 PatientStates. 
	 * 
	 * @param stateX
	 * @param stateY
	 * @return the value 0 if x == y;a value less than 0 if y < x; and a value
	 *         greater than 0 if y > x
	 */
	public static int compareSeverity(PatientState stateX, PatientState stateY) {
		// The parameters are switched to have higher severity at the beginning of the
		// sorted list.
		return Integer.compare(stateY.severityLevel, stateX.severityLevel);
	}

	/**
	 * Gets {@link PatientState} based on a string.
	 * 
	 * @param text
	 *            representation
	 * @return patient state represented by the text
	 */
	public static PatientState fromString(String text) {
		return Arrays.stream(PatientState.values())
				.filter(v -> v.textRepresentation.equals(text))
				.findFirst()
				.orElseThrow(() -> new InvalidParameterException("Unknown PatientState value received: " + text));
	}

	/**
	 * Text representation getter.
	 * 
	 * @return Text representation
	 */
	public String getTextRepresentation() {
		return this.textRepresentation;
	}

}
