package com.jakomulski.tdd_execise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class FahrenheitCelciusConverterTest {

	private FahrenheitCelciusConverter target;

	@BeforeEach
	public void setUp() {
		target = new FahrenheitCelciusConverterImpl();
	}

	@Test
	public void shouldConvertCelciusToFahrenheit() {
		assertEquals(32, target.toFahrenheit(0));
		assertEquals(98, target.toFahrenheit(37));
		assertEquals(212, target.toFahrenheit(100));
	}

	@Test
	public void shouldConvertFahrenheitToCelcius() {
		assertEquals(0, target.toCelcius(32));
		assertEquals(37, target.toCelcius(100));
		assertEquals(100, target.toCelcius(212));
	}
}
