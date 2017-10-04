package com.jakomulski.tdd_execise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class TemperatureCalculatorServiceTest {
	private TemperatureCalculatorService target; 
	private Calculator calculator =  mock(Calculator.class);
	private FahrenheitCelciusConverter converter = mock(FahrenheitCelciusConverter.class);
	
	@BeforeEach
	public void setUp(){
		target = new TemperatureCalculatorService(calculator, converter);
	}
	
	@Test
	public void shouldCalculateAndConvertToCelcius(){
		String inputArgument = "3,5\n1";
		int calculatorResult = 15;
		int expectedResult = -9;
		
		when(calculator.calculate(inputArgument)).thenReturn(calculatorResult);
		when(converter.toCelcius(calculatorResult)).thenReturn(expectedResult);
		
		assertEquals(target.calculateAndCovertToCelcius(inputArgument),expectedResult);
	}
	
	@Test
	public void shouldCalculateAndConvertToFahrenheit(){
		String inputArgument = "3,5\n1";
		int calculatorResult = 15;
		int expectedResult = 59;
		
		when(calculator.calculate(inputArgument)).thenReturn(calculatorResult);
		when(converter.toFahrenheit(calculatorResult)).thenReturn(expectedResult);
		
		assertEquals(target.calculateAndCovertToFahrenheit(inputArgument),expectedResult);
	}
}
