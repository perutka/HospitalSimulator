package com.pperusek.hospitalsim;

import java.security.InvalidParameterException;

import org.junit.Assert;
import org.junit.Test;

import com.pperusek.hospitalsim.enums.Drug;
import com.pperusek.hospitalsim.enums.PatientState;

public class EnumsTest {
	
	/**
	 * Test {@link String} to {@link Drug} positive cases.
	 */
	@Test
	public void testDrugParsing() {
		Assert.assertEquals(Drug.Aspirin, Drug.fromString("As"));
		Assert.assertEquals(Drug.Antibiotic, Drug.fromString("An"));
		Assert.assertEquals(Drug.Insulin, Drug.fromString("I"));
		Assert.assertEquals(Drug.Paracetamol, Drug.fromString("P"));
	}
	
	/**
	 * Test {@link String} to {@link Drug} negative case.
	 */
	@Test(expected = InvalidParameterException.class)
	public void testBadDrugString() {
		Drug.fromString("Banana");
	}
	
	/**
	 * Test {@link String} to {@link PatientState} positive cases.
	 */
	@Test
	public void testPatientState() {
		Assert.assertEquals(PatientState.Healthy, PatientState.fromString("H"));
		Assert.assertEquals(PatientState.Fever, PatientState.fromString("F"));
		Assert.assertEquals(PatientState.Diabetes, PatientState.fromString("D"));
		Assert.assertEquals(PatientState.Tuberculosis, PatientState.fromString("T"));
		Assert.assertEquals(PatientState.Dead, PatientState.fromString("X"));
	}
	
	/**
	 * Test {@link String} to {@link PatientState} negative case.
	 */
	@Test(expected = InvalidParameterException.class)
	public void testBadPatientStateString() {
		PatientState.fromString("Banana");
	}
}
