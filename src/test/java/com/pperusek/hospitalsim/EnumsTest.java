package com.pperusek.hospitalsim;

import org.junit.Assert;
import org.junit.Test;

import com.pperusek.hospitalsim.enums.Drug;
import com.pperusek.hospitalsim.enums.PatientState;

public class EnumsTest {
	
	@Test
	public void testDrugParsing() {
		Assert.assertEquals(Drug.Aspirin, Drug.fromString("As"));
	}
	
	@Test
	public void testPatientState() {
		Assert.assertEquals(PatientState.Fever, PatientState.fromString("F"));
	}
}
