package com.pperusek.hospitalsim;

import static com.pperusek.hospitalsim.enums.PatientState.Dead;
import static com.pperusek.hospitalsim.enums.PatientState.Diabetes;
import static com.pperusek.hospitalsim.enums.PatientState.Fever;
import static com.pperusek.hospitalsim.enums.PatientState.Healthy;
import static com.pperusek.hospitalsim.enums.PatientState.Tuberculosis;
import static java.util.Arrays.asList;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.pperusek.hospitalsim.enums.Drug;
import com.pperusek.hospitalsim.enums.PatientState;
import com.pperusek.hospitalsim.interfaces.ImmutablePatientsTreatment;
import com.pperusek.hospitalsim.interfaces.PatientsTreatment;

/**
 * A test of the {@link Transitor#treatPatients(PatientsTreatment)} method. As the
 * transitions are already tested in {@link SingleTransitionTest}, here we only
 * test if it works when passing multiple patients.
 */
public class SimulateTest {

	@Test
	public void testSimulation() {
		List<PatientState> initPatientsStates = asList(Dead, Healthy, Tuberculosis, Diabetes, Fever);
		List<PatientState> endPatientsStates = asList(Dead, Healthy, Tuberculosis, Dead, Healthy);

		PatientsTreatment treatmentData = ImmutablePatientsTreatment.of(initPatientsStates, asList(Drug.Aspirin));

		Assert.assertEquals(endPatientsStates, Transitor.treatPatients(treatmentData));
	}
}
