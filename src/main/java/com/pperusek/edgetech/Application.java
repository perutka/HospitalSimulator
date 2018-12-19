package com.pperusek.edgetech;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.pperusek.edgetech.enums.PatientState;
import com.pperusek.edgetech.interfaces.PatientsTreatment;

public class Application {

	public static void main(String[] args) {
		System.out.println("HelloWorld");
		
		// TODO Exception handling
		Parser parser = new Parser();
		PatientsTreatment treatmentInput = parser.parse(Arrays.asList(args));
		
		simulate(treatmentInput);
		
	}
	
	private static List<PatientState> simulate(PatientsTreatment treatmentInput) {
		Transitor transitor = new Transitor(treatmentInput.getTretmentDrug());
		return treatmentInput.getPatientsStates()
				.stream()
				.map(transitor::toNewPatientState)
				.collect(Collectors.toList());
	}
}
