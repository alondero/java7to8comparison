package com.sfwltd.demo.java8;

import static java.util.Arrays.stream;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;

public class CommaDelimitedPrinterJava8 {

	public String delimit(String... tokens) {
		return stream(tokens)
				.filter(token -> token.length() > 1)
				.sorted(comparing(String::length))
				.collect(joining(","));
	}
}
