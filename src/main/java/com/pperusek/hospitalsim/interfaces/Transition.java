package com.pperusek.hospitalsim.interfaces;

import java.util.List;

import org.immutables.value.Value;

import com.pperusek.hospitalsim.enums.Drug;
import com.pperusek.hospitalsim.enums.PatientState;

/**
 * Data structure of one transition. Contains conditions for a transition and an
 * end {@link PatientState} after the transition.
 */
@Value.Immutable(builder = false)
public interface Transition {

	/**
	 * Initial {@link PatientState} condition getter.
	 * 
	 * @return Initial {@link PatientState} condition
	 */
	@Value.Parameter
	public abstract Matcher<PatientState> getInitStateMatcher();

	/**
	 * A condition of list of drugs getter
	 * 
	 * @return A condition of list of drugs
	 */
	@Value.Parameter
	public abstract Matcher<List<Drug>> getDrugMatcher();

	/**
	 * End {@link PatientState} of this transition getter.
	 * 
	 * @return End {@link PatientState} of this transition
	 */
	@Value.Parameter
	public abstract PatientState getEndState();

	/**
	 * A functional interface to execute matching of an argument.
	 * 
	 * @param <T>
	 *            type of object to be matched against the argument-
	 */
	@FunctionalInterface
	public interface Matcher<T> {
		public boolean matches(T parameter);
	}
}
