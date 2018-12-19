package com.pperusek.hospitalsim;

import static com.pperusek.hospitalsim.enums.Drug.Antibiotic;
import static com.pperusek.hospitalsim.enums.Drug.Aspirin;
import static com.pperusek.hospitalsim.enums.Drug.Insulin;
import static com.pperusek.hospitalsim.enums.Drug.Paracetamol;
import static com.pperusek.hospitalsim.enums.PatientState.Dead;
import static com.pperusek.hospitalsim.enums.PatientState.Diabetes;
import static com.pperusek.hospitalsim.enums.PatientState.Fever;
import static com.pperusek.hospitalsim.enums.PatientState.Healthy;
import static com.pperusek.hospitalsim.enums.PatientState.Tuberculosis;
import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.pperusek.hospitalsim.Transitor;
import com.pperusek.hospitalsim.enums.Drug;
import com.pperusek.hospitalsim.enums.PatientState;

/**
 * A parameterized test of the {@link Transitor#transition2NewPatientState(PatientState)} method.
 */
@RunWith(Parameterized.class)
public class SingleTransitionTest {
	
	/** A state that is going to be transitioned. */
	@Parameterized.Parameter(0)
	public PatientState initState;
	
	/** Drugs used in the treatment/transition. */
	@Parameterized.Parameter(1)
	public List<Drug> drugs;
	
	/** Target state after the transition. */
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
				// 2 possible transitions are here. The more severe must be returned.
				{Healthy, asList(Paracetamol, Aspirin, Antibiotic, Insulin), Dead},
			};
		return asList(data);
	}

	@Test
	public void testTransitor() {
		Transitor t = new Transitor(drugs);
		Assert.assertEquals(endState,t.transition2NewPatientState(initState));
	}
}
