package com.pperusek.edgetech.interfaces;

import java.util.List;
import java.util.function.Predicate;

import org.immutables.value.Value;

import com.pperusek.edgetech.enums.Drug;
import com.pperusek.edgetech.enums.PatientState;

@Value.Immutable(builder = false)
public abstract class Transition implements Comparable<Transition> {

	@Value.Parameter
	public abstract Matcher<PatientState> getInitStateMatcher();

	@Value.Parameter
	public abstract Matcher<List<Drug>> getDrugMatcher();

	@Value.Parameter
	public abstract PatientState getEndState();
	
	// TODO refactor comaprator to just sort in the stream
	@Override
	public int compareTo(Transition other) {
	    return this.getEndState().isMoreSevereThan(other.getEndState());
	}
	
	@FunctionalInterface
	public interface Matcher<T> {
		public boolean matches(T parameter);
	}
}
