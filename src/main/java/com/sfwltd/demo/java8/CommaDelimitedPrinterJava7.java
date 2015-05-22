package com.sfwltd.demo.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CommaDelimitedPrinterJava7 {

	public static class LengthComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return o1.length() - o2.length();
		}

	}

	private static final String DELIMITER = ",";
	private static final Comparator<String> LENGTH_COMPARATOR = new LengthComparator();

	public String delimit(String... tokens) {
		
		List<String> filteredTokens = new ArrayList<>();	
		
		for (String token : tokens) {
			if (token.length() > 1) {
				filteredTokens.add(token);
			}
		}
		
		if (filteredTokens.size() == 0) {
			return "";
		}
		
		Collections.sort(filteredTokens, LENGTH_COMPARATOR);

		StringBuilder builder = new StringBuilder();
		
		for (String token: filteredTokens) {
			if (token.length() > 1) {
				builder.append(token).append(DELIMITER);
			}
		}
		
		return builder
				.deleteCharAt(builder.length()-1)
				.toString();
	}
}
