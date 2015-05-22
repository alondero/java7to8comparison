package com.sfwltd.demo.java8;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class CommaDelimitedPrinterTest {

	CommaDelimitedPrinterJava7 printer = new CommaDelimitedPrinterJava7();
	
	@Test
	public void returnsEmptyStringWithNoTokens() {
		assertThat(printer.delimit(), is(equalTo("")));
	}
	
	@Test
	public void returnsSingleStringWithNoDelimiterWith1Token() {
		assertThat(printer.delimit("token"), is(equalTo("token")));
	}
	
	@Test
	public void delimitsMultipleTokens() {
		assertThat(printer.delimit("token", "anotherToken"), is(equalTo("token,anotherToken")));
	}
	
	@Test
	public void ordersTokensByLength() {
		assertThat(printer.delimit("looooonnnnnnggg", "tiny", "short"), is(equalTo("tiny,short,looooonnnnnnggg")));
	}
	
	@Test
	public void filters1CharacterTokens() {
		assertThat(printer.delimit("Bob", "a"), is(equalTo("Bob")));
		assertThat(printer.delimit("a"), is(equalTo("")));
	}
	
}