package com.pperusek.hospitalsim.interfaces;

import java.util.List;

import org.immutables.value.Value;

import com.pperusek.hospitalsim.enums.Drug;
import com.pperusek.hospitalsim.enums.PatientState;

@Value.Immutable(builder = false)
public interface PatientsTreatment {
	
	@Value.Parameter
	public List<PatientState> getPatientsStates();
	
	@Value.Parameter
	public List<Drug> getTretmentDrug();
}
