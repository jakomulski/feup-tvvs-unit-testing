package com.jakomulski.tdd_execise;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/*
1-An empty string returns zero
2-A single number returns the value
3-Two numbers, comma delimited, returns the sum
4-Two numbers, newline delimited, returns the sum
5-Three numbers, delimited either way, returns the sum
6-Negative numbers throw an exception
7-Numbers greater than 1000 are ignored
*/

@RunWith(JUnitPlatform.class)
public class CalculatorTest {

	private Calculator target;

	@BeforeEach
	public void setUp() {
		target = new Calculator();
	}

	@Test
	public void shouldAnEmptyStringReturnsZero() {
		assertEquals(target.calculate(""), 0);
	}

	@Test
	public void shouldASingleNumberReturnsTheValue(){
		assertEquals(target.calculate("12"), 12);
		assertEquals(target.calculate("354"), 354);
	}

	@Test
	public void shouldTwoNumbersCommaDelimitedReturnsTheSum() {
		assertEquals(target.calculate("12,32"), 44);
		assertEquals(target.calculate("121,3"), 124);
	}

	@Test
	public void shouldTwoNumbersNewlineDelimitedReturnsTheSum() {
		assertEquals(target.calculate("12\n32"), 44);
		assertEquals(target.calculate("121\n3"), 124);
	}

	@Test
	public void shouldThreeNumbersDelimitedReturnsTheSum() {
		assertEquals(target.calculate("12\n32,2"), 46);
		assertEquals(target.calculate("121,3,100"), 224);
		assertEquals(target.calculate("121\n3\n1"), 125);
	}

	@Test
	public void shouldNegativeNumbersThrowAnException() {
		assertThrows(RuntimeException.class, () -> target.calculate("12\n32,-2"));
		assertThrows(RuntimeException.class, () -> target.calculate("-45"));
	}

	@Test
	public void shouldNumbersGreaterThan1000BeIgnored() {
		assertEquals(target.calculate("12\n32,2000"), 44);
		assertEquals(target.calculate("121,3,1001"), 124);
		assertEquals(target.calculate("121\n3\n1000"), 1124);
	}
}
