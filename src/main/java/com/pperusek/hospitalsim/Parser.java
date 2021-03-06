package com.pperusek.hospitalsim;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.pperusek.hospitalsim.interfaces.ImmutablePatientsTreatment;
import com.pperusek.hospitalsim.enums.Drug;
import com.pperusek.hospitalsim.enums.PatientState;
import com.pperusek.hospitalsim.interfaces.PatientsTreatment;

/**
 * Parsing of the passed arguments used in the patient treatment simulation.
 */
public class Parser {

	/**
	 * Parses the received arguments to PatientsTreatment. The arguments should be
	 * of format: "H,F" "As"
	 */
	public static PatientsTreatment parse(List<String> args) {
		argumentsLengthIsValid(args.size());

		return ImmutablePatientsTreatment.of(parsePatientsStates(args.get(0)), parseDrug(args.get(1)));
	}

	/**
	 * Verifies if the number of the passed parameters is valid. In a negative case
	 * an exception is thrown.
	 * 
	 * @param length
	 *            of the passed parameters
	 */
	private static void argumentsLengthIsValid(int length) {
		int numberOfParameters = 2;

		if (length != numberOfParameters) {
			throw new InvalidParameterException(
					String.format("Number of passed agruments is %d. Valid number is %d.", length, numberOfParameters));
		}
	}

	/**
	 * Parses the string into a list of PatientStates. The string must be of a
	 * format: "A,F,A".
	 * 
	 * @param text
	 *            containing patient states
	 * @return list of the parsed patient states
	 */
	private static List<PatientState> parsePatientsStates(String text) {
		String[] splitText = text.split(",");

		return Arrays.stream(splitText).map(PatientState::fromString).collect(Collectors.toList());
	}

	/**
	 * Parses the string into a list of Drugs. The string must be of a format: "As,
	 * I".
	 * 
	 * @param text
	 *            containing drug abbreviations
	 * @return list of the parsed drugs
	 */
	private static List<Drug> parseDrug(String text) {
		String[] splitText = text.split(",");

		return Arrays.stream(splitText).map(Drug::fromString).collect(Collectors.toList());
	}

}
