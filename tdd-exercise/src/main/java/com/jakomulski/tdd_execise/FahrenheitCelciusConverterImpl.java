package com.jakomulski.tdd_execise;

public class FahrenheitCelciusConverterImpl implements FahrenheitCelciusConverter {

	@Override
	public int toFahrenheit(int i) {		
		return i*9/5+32;
	}

	@Override
	public int toCelcius(int i) {
		return (i-32)*5/9;
	}
}
