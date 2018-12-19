package com.pperusek.hospitalsim.enums;

import java.util.Arrays;

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
	
	public static int compareSeverity(PatientState stateX, PatientState stateY) {
		// The parameters are switched to have higher severity at the beginning of the sorted list.
		return Integer.compare(stateY.severityLevel, stateX.severityLevel);
	}

	public static PatientState fromString(String text) {
		return Arrays.stream(PatientState.values()).filter(v -> v.textRepresentation.equals(text)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("unknown Patient state value: " + text));
	}
	
	public String toTextRepresentation() {
		return this.textRepresentation;
	}
	
}
