package com.jakomulski.tdd_execise;

public class TemperatureCalculatorService {

	private Calculator calculator;
	private FahrenheitCelciusConverter fahrenheitCelciusConverter;

	public TemperatureCalculatorService(Calculator calculator, FahrenheitCelciusConverter fahrenheitCelciusConverter) {
		this.calculator = calculator;
		this.fahrenheitCelciusConverter = fahrenheitCelciusConverter;
	}

	public int calculateAndCovertToCelcius(String fahrenheitValue) {
		int calculatedValue = calculator.calculate(fahrenheitValue);
		return fahrenheitCelciusConverter.toCelcius(calculatedValue);
	}

	public int calculateAndCovertToFahrenheit(String celciusValue) {
		int calculatedValue = calculator.calculate(celciusValue);
		return fahrenheitCelciusConverter.toFahrenheit(calculatedValue);
	}
}
