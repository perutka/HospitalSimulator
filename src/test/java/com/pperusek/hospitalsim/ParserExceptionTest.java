package com.pperusek.hospitalsim;

import java.security.InvalidParameterException;
import java.util.Arrays;

import org.junit.Test;

public class ParserExceptionTest {

	/**
	 * Tests if the Parser throws exception in case of bad number of arguments.
	 */
	@Test(expected = InvalidParameterException.class)
	public void testBadNumberOfArguments() {
		Parser.parse(Arrays.asList("T", "As", ""));
	}
}
