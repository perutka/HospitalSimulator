package com.pperusek.hospitalsim;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.pperusek.hospitalsim.enums.PatientState;

/**
 * Makes simulation output data displayable.
 */
public class Display {

	private List<PatientState> patientStates;

	private static final String ONE_PATIENT_STATE_OCCURENCES_JOIN_STRING = ":";
	private static final String MULTIPLE_PATIENT_STATE_OCCURENCES_JOIN_STRING = ",";

	/**
	 * Constructor.
	 * @param patientsStates of the treated patients
	 */
	public Display(List<PatientState> patientsStates) {
		this.patientStates = patientsStates;
	}

	/**
	 * Creates a string representation of the simulation output data. An example:
	 * "H:2,F:0,D:0,T:1,X:2".
	 * 
	 * @param patientStates
	 *            the simulation output data to be put into string
	 * @return a string representation of the simulation output data
	 */
	public static String makeStringOfPatientStatesOccurrences(List<PatientState> patientStates) {
		Display display = new Display(patientStates);

		return Arrays.asList(PatientState.values()).stream()
				// Make a string representation of number of occurrences per each PatientState.
				.map(display::patientStateOccurrences2String)
				// Create a continuous string out of it.
				.collect(Collectors.joining(MULTIPLE_PATIENT_STATE_OCCURENCES_JOIN_STRING));
	}

	/**
	 * Creates a string representation of number of occurrences of one
	 * {@link PatientState}.
	 * 
	 * @param patientState
	 *            to make a String representation of
	 * @return a string representation of number of occurrences of one
	 *         {@link PatientState}.
	 */
	private String patientStateOccurrences2String(PatientState patientState) {
		// Count occurrences of the PatientState.
		int occurrences = Collections.frequency(patientStates, patientState);
		// Create the String
		return String.join(ONE_PATIENT_STATE_OCCURENCES_JOIN_STRING, patientState.toTextRepresentation(),
				Integer.toString(occurrences));
	}
}
