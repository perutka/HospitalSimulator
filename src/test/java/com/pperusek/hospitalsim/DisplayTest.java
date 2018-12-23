package com.pperusek.hospitalsim;

import static com.pperusek.hospitalsim.enums.PatientState.Healthy;
import static com.pperusek.hospitalsim.enums.PatientState.Dead;
import static com.pperusek.hospitalsim.enums.PatientState.Diabetes;
import static com.pperusek.hospitalsim.enums.PatientState.Fever;
import static com.pperusek.hospitalsim.enums.PatientState.Tuberculosis;
import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.pperusek.hospitalsim.enums.PatientState;

/**
 * A parameterized test of the {@link Display#makeStringOfPatientStatesOccurrences(List)} method.
 */
@RunWith(Parameterized.class)
public class DisplayTest {
	
	@Parameterized.Parameter(0)
	public List<PatientState> states;
	@Parameterized.Parameter(1)
	public String displayString;
	
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
				{asList(Healthy,Healthy,Healthy), "H:3,F:0,D:0,T:0,X:0"},
				{asList(Dead,Tuberculosis,Diabetes, Healthy, Fever), "H:1,F:1,D:1,T:1,X:1"},
				{asList(Healthy), "H:1,F:0,D:0,T:0,X:0"},
				{asList(Dead), "H:0,F:0,D:0,T:0,X:1"},
				{asList(Diabetes), "H:0,F:0,D:1,T:0,X:0"},
				{asList(Fever), "H:0,F:1,D:0,T:0,X:0"},
				{asList(Tuberculosis), "H:0,F:0,D:0,T:1,X:0"},
			};
		return asList(data);
	}

	@Test
	public void testTransitor() {
		Assert.assertEquals(displayString, Display.makeStringOfPatientStatesOccurrences(states));
	}
}
