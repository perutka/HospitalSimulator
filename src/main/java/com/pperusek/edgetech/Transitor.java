package com.pperusek.edgetech;

import static com.pperusek.edgetech.enums.Drug.Antibiotic;
import static com.pperusek.edgetech.enums.Drug.Aspirin;
import static com.pperusek.edgetech.enums.Drug.Insulin;
import static com.pperusek.edgetech.enums.Drug.Paracetamol;
import static com.pperusek.edgetech.enums.PatientState.Dead;
import static com.pperusek.edgetech.enums.PatientState.Diabetes;
import static com.pperusek.edgetech.enums.PatientState.Fever;
import static com.pperusek.edgetech.enums.PatientState.Healthy;
import static com.pperusek.edgetech.enums.PatientState.Tuberculosis;
import static com.pperusek.edgetech.interfaces.ImmutableTransition.of;
import static java.util.Arrays.asList;

import java.util.List;
import java.util.Random;

import com.pperusek.edgetech.enums.Drug;
import com.pperusek.edgetech.enums.PatientState;
import com.pperusek.edgetech.interfaces.Transition;

public class Transitor {

	/** List of possible transitions. */
	private static final List<Transition> transitions = asList(
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

	// TODO the Predicate from Transition should be changed to custom functional
	// interface
	/**
	 * Makes a transition from the passed initState to a new state based on drugs
	 * used in treatment and defined transitions.
	 * 
	 * @param initState
	 *            to be transitioned from
	 * @return transitioned state
	 */
	public PatientState toNewPatientState(PatientState initState) {
		return transitions.stream()
				// First get all transitions with equal initial state
				.filter(t -> t.getInitStateMatcher().matches(initState))
				// Get all transitions that accept our drugs
				.filter(t -> t.getDrugMatcher().matches(drugs))
				// Sort the possible transitions by their end state health severity (most severe
				// first)
				.sorted()
				// Transform to end states
				.map(t -> t.getEndState()).findFirst()
				// If there is no state, then return the initial state
				.orElse(initState);
	}
}
