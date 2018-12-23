package com.pperusek.hospitalsim;

import static com.pperusek.hospitalsim.interfaces.ImmutableTransition.of;
import static com.pperusek.hospitalsim.enums.Drug.Antibiotic;
import static com.pperusek.hospitalsim.enums.Drug.Aspirin;
import static com.pperusek.hospitalsim.enums.Drug.Insulin;
import static com.pperusek.hospitalsim.enums.Drug.Paracetamol;
import static com.pperusek.hospitalsim.enums.PatientState.Dead;
import static com.pperusek.hospitalsim.enums.PatientState.Diabetes;
import static com.pperusek.hospitalsim.enums.PatientState.Fever;
import static com.pperusek.hospitalsim.enums.PatientState.Healthy;
import static com.pperusek.hospitalsim.enums.PatientState.Tuberculosis;
import static java.util.Arrays.asList;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.pperusek.hospitalsim.enums.Drug;
import com.pperusek.hospitalsim.enums.PatientState;
import com.pperusek.hospitalsim.interfaces.PatientsTreatment;
import com.pperusek.hospitalsim.interfaces.Transition;

/**
 * Executes transitions of {@link PatientState} based on List of {@link Drug}
 * used in treatment.
 */
public class Transitor {

	/** List of possible transitions. */
	private static final List<Transition> TRANSITIONS = asList(
			// Aspirin cures Fever
			of(Fever::equals, d -> d.contains(Aspirin), Healthy),
			// Antibiotic cures Tuberculosis
			of(Tuberculosis::equals, d -> d.contains(Antibiotic), Healthy),
			// Insulin prevents diabetic subject from dying, does not cure Diabetes
			of(Diabetes::equals, d -> !d.contains(Insulin), Dead),
			// If insulin is mixed with antibiotic, healthy people catch Fever
			of(Healthy::equals, d -> d.containsAll(asList(Antibiotic, Insulin)), Fever),
			// Paracetamol cures Fever
			of(Fever::equals, d -> d.contains(Paracetamol), Healthy),
			// Paracetamol kills subject if mixed with aspirin;
			of(s -> true, d -> d.containsAll(asList(Paracetamol, Aspirin)), Dead),
			// One time in a million the Flying Flying Spaghetti Monster shows his noodly
			// power and resurrects a dead patient (Dead becomes Healthy).
			of(Dead::equals, s -> new Random().nextInt(1000000) == 1, Healthy));

	/** Used in treatment */
	private List<Drug> drugs;

	public Transitor(List<Drug> treatmentDrugs) {
		drugs = treatmentDrugs;
	}

	/**
	 * Makes a transition from the passed initState to a new state based on drugs
	 * used in treatment and defined transitions.
	 * 
	 * @param initState
	 *            to be transitioned from
	 * @return transitioned state
	 */
	public PatientState transition2NewPatientState(PatientState initState) {
		return TRANSITIONS.stream()
				// First get all transitions with equal initial state
				.filter(t -> t.getInitStateMatcher().matches(initState))
				// Get all transitions that accept the treatment drugs
				.filter(t -> t.getDrugMatcher().matches(drugs))
				// Transform transitions to end states
				.map(Transition::getEndState)
				// Sort the possible end states by their health severity (most severe first)
				.sorted(PatientState::compareSeverity)
				// Take the most severe state
				.findFirst()
				// If there is no state, then return the initial state (there was no transition)
				.orElse(initState);
	}

	/**
	 * Treats patients passed in the treatmentInput argument based on drugs passed
	 * in the treatmentInput argument.
	 * 
	 * @param treatmentInput
	 *            patients to be treated with a list of drugs
	 * @return list of patients states after the treatment
	 */
	public static List<PatientState> treatPatients(PatientsTreatment treatmentInput) {
		Transitor transitor = new Transitor(treatmentInput.getTretmentDrug());
		return treatmentInput.getPatientsStates().stream().map(transitor::transition2NewPatientState)
				.collect(Collectors.toList());
	}
}
