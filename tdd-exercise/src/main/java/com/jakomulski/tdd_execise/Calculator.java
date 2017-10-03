package com.jakomulski.tdd_execise;

import java.util.Arrays;
import java.util.List;

public class Calculator {

	public int calculate(String string) {
		List<String> splitedValues = Arrays.asList(string.split("[,\n]"));
		return splitedValues.stream().map(this::parseToNumber).reduce(0, Integer::sum);
	}

	private int parseToNumber(String string) {
		if ("".equals(string))
			return 0;
		int numericValue = Integer.parseInt(string);
		if (numericValue < 0)
			throw new RuntimeException();
		else if (numericValue > 1000)
			return 0;
		return numericValue;
	}
}
