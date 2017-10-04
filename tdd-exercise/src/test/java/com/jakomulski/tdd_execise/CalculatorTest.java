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
3-Two numbers, comma delimited, returns the product
4-Two numbers, newline delimited, returns the product
5-Three numbers, delimited either way, returns the product
6-Negative numbers throw an exception
7-Numbers greater than 1000 are ignored

*/

@RunWith(JUnitPlatform.class)
public class CalculatorTest {

	private Calculator target;

	@BeforeEach
	public void setUp() {
		target = new CalculatorImpl();
	}

	@Test
	public void shouldAnEmptyStringReturnsZero() {
		assertEquals(target.calculate(""), 0);
	}

	@Test
	public void shouldASingleNumberReturnsTheValue() {
		assertEquals(target.calculate("12"), 12);
		assertEquals(target.calculate("354"), 354);
	}

	@Test
	public void shouldTwoNumbersCommaDelimitedReturnsTheProduct() {
		assertEquals(target.calculate("10,10"), 100);
		assertEquals(target.calculate("12,2"), 24);
	}

	@Test
	public void shouldTwoNumbersNewlineDelimitedReturnsTheProduct() {
		assertEquals(target.calculate("12\n12"), 144);
		assertEquals(target.calculate("20\n3"), 60);
	}

	@Test
	public void shouldThreeNumbersDelimitedReturnsTheProduct() {
		assertEquals(target.calculate("12\n12,2"), 288);
		assertEquals(target.calculate("2,3,100"), 600);
		assertEquals(target.calculate("5\n5\n1"), 25);
	}

	@Test
	public void shouldNegativeNumbersThrowAnException() {
		assertThrows(RuntimeException.class, () -> target.calculate("12\n32,-2"));
		assertThrows(RuntimeException.class, () -> target.calculate("-45"));
	}

	@Test
	public void shouldNumbersGreaterThan1000BeIgnored() {
		assertEquals(target.calculate("12\n2,2000"), 24);
		assertEquals(target.calculate("2,3,1001"), 6);
		assertEquals(target.calculate("2\n2\n1000"), 4000);
	}
}
