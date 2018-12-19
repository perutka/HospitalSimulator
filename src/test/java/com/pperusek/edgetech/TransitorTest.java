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
import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.pperusek.edgetech.enums.Drug;
import com.pperusek.edgetech.enums.PatientState;

@RunWith(Parameterized.class)
public class TransitorTest {
	
	@Parameterized.Parameter(0)
	public PatientState initState;
	@Parameterized.Parameter(1)
	public List<Drug> drugs;
	@Parameterized.Parameter(2)
	public PatientState endState;
	
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
				{Fever, asList(Aspirin), Healthy},
				{Tuberculosis, asList(Antibiotic), Healthy},
				{Diabetes, asList(Antibiotic), Dead},
				{Diabetes, asList(Insulin), Diabetes},
				{Healthy, asList(Antibiotic, Insulin), Fever},
				{Fever, asList(Paracetamol), Healthy},
				{Healthy, asList(Paracetamol, Aspirin), Dead},
				{Healthy, asList(Paracetamol, Aspirin, Insulin), Dead},
				{Healthy, asList(Paracetamol, Aspirin, Antibiotic, Insulin), Dead},
			};
		return asList(data);
	}

	@Test
	public void testTransitor() {
		Transitor t = new Transitor(drugs);
		Assert.assertEquals(endState,t.toNewPatientState(initState));
	}
}
