package com.jiangjian.learning.junit.chap2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class CalculatorTest {
	private double expectedValue;
	private double a;
	private double b;
	
	public CalculatorTest(double expectedValue, double a, double b) {
		this.expectedValue = expectedValue;
		this.a = a;
		this.b = b;
	}
	
	@Parameters
	public static Collection<Integer[]> getParameters() {
		return Arrays.asList(new Integer[][] {
				{3, 1, 2},
				{5, 2, 3}
		});
	}
	
	@Test
	public void testAdd() {
		assertEquals(expectedValue, Calculator.add(a, b), 0);
	}

}
