package com.pperusek.hospitalsim;

import java.util.Arrays;
import java.util.List;

import com.pperusek.hospitalsim.enums.PatientState;
import com.pperusek.hospitalsim.interfaces.PatientsTreatment;

public class Application {

	public static void main(String[] args) {
		
		// TODO Exception handling
		// Parse treatment data from the arguments 
		PatientsTreatment treatmentInput = Parser.parse(Arrays.asList(args));
		
		// Execute the simulation
		List<PatientState> treatmentOutput = Transitor.simulate(treatmentInput);
		
		// Display the results
		String outputText = Display.makeStringOfPatientStatesOccurrences(treatmentOutput);
		System.out.println(outputText);
	}
}
