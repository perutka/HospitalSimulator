package com.pperusek.edgetech.enums;

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
	
	public int isMoreSevereThan(PatientState otherState) {
		return Integer.compare(this.severityLevel, otherState.severityLevel);
	}

	public static PatientState fromString(String text) {
		return Arrays.stream(PatientState.values()).filter(v -> v.textRepresentation.equals(text)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("unknown Patient state value: " + text));
	}
	
}
