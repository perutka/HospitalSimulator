package com.pperusek.edgetech.interfaces;

import java.util.List;

import org.immutables.value.Value;

import com.pperusek.edgetech.enums.Drug;
import com.pperusek.edgetech.enums.PatientState;

@Value.Immutable(builder = false)
public interface PatientsTreatment {
	
	@Value.Parameter
	public List<PatientState> getPatientsStates();
	
	@Value.Parameter
	public List<Drug> getTretmentDrug();
}
