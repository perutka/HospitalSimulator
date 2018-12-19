package com.pperusek.edgetech;

import static com.pperusek.edgetech.interfaces.ImmutablePatientsTreatment.of;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.pperusek.edgetech.enums.Drug;
import com.pperusek.edgetech.enums.PatientState;
import com.pperusek.edgetech.interfaces.PatientsTreatment;

@RunWith(Parameterized.class)
public class ParserTest {

	@Parameterized.Parameter(0)
	public List<String> arguments;
	@Parameterized.Parameter(1)
	public PatientsTreatment result;

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
				{ Arrays.asList("T", "As"), of(Arrays.asList(PatientState.Tuberculosis), Arrays.asList(Drug.Aspirin)) },
				{ Arrays.asList("T", "I"), of(Arrays.asList(PatientState.Tuberculosis), Arrays.asList(Drug.Insulin)) },
				{ Arrays.asList("T", "P"), of(Arrays.asList(PatientState.Tuberculosis),
						Arrays.asList(Drug.Paracetamol)) },
				{ Arrays.asList("F,H,D,T,X", "An"),
						of(Arrays.asList(PatientState.Fever, PatientState.Healthy, PatientState.Diabetes,
								PatientState.Tuberculosis, PatientState.Dead), Arrays.asList(Drug.Antibiotic)) } };
		return Arrays.asList(data);
	}

	@Test
	public void testParser() {
		Parser parser = new Parser();
		Assert.assertEquals("Result", result, parser.parse(arguments));
	}

}
