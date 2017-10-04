package com.jakomulski.tdd_execise;

import java.util.Arrays;

public class CalculatorImpl implements Calculator {
	@Override
	public int calculate(String string) {
		return Arrays.asList(string.split("[,\n]")).stream()
				.map(this::parseToNumber)
				.reduce(1,(a,b)->a*b);
		
	}
	
	private int parseToNumber(String value){
		if(value.isEmpty())
			return 0;
		
		int numValue = Integer.parseInt(value);
		if(numValue< 0)
			throw new RuntimeException();
		else if(numValue > 1000)
			return 1;
		return numValue;
	}
}
