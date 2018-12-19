package com.pperusek.hospitalsim.interfaces;

import java.util.List;

import org.immutables.value.Value;

import com.pperusek.hospitalsim.enums.Drug;
import com.pperusek.hospitalsim.enums.PatientState;

@Value.Immutable(builder = false)
public interface Transition {

	@Value.Parameter
	public abstract Matcher<PatientState> getInitStateMatcher();

	@Value.Parameter
	public abstract Matcher<List<Drug>> getDrugMatcher();

	@Value.Parameter
	public abstract PatientState getEndState();
	
	@FunctionalInterface
	public interface Matcher<T> {
		public boolean matches(T parameter);
	}
}
