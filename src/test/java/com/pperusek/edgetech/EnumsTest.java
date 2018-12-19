package com.pperusek.edgetech;

import org.junit.Assert;
import org.junit.Test;

import com.pperusek.edgetech.enums.Drug;
import com.pperusek.edgetech.enums.PatientState;

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
