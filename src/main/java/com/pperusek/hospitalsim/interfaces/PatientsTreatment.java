package com.pperusek.hospitalsim.interfaces;

import java.util.List;

import org.immutables.value.Value;

import com.pperusek.hospitalsim.enums.Drug;
import com.pperusek.hospitalsim.enums.PatientState;

/**
 * Hospital simulation input data (PatientStates and Drugs used in the treatment
 * of the PatientStates).
 */
@Value.Immutable(builder = false)
public interface PatientsTreatment {

	/**
	 * States of patients that are going through the treatment.
	 * 
	 * @return States of patients
	 */
	@Value.Parameter
	public List<PatientState> getPatientsStates();

	/**
	 * Drugs to be used in the treatment.
	 * 
	 * @return Drugs
	 */
	@Value.Parameter
	public List<Drug> getTretmentDrug();
}
