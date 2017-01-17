package com.sfwltd.demo.java8;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import com.sfwltd.demo.CommaDelimitedPrinterKotlin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CommaDelimitedPrinterTest {

	private CommaDelimitedPrinter printer;

	public CommaDelimitedPrinterTest(CommaDelimitedPrinter printer) {
		this.printer = printer;
	}

	@Parameterized.Parameters(name = "{0}")
	public static Collection<? super CommaDelimitedPrinter[]> data() {
		return Arrays.asList(new CommaDelimitedPrinterJava7(), new CommaDelimitedPrinterJava8(), new CommaDelimitedPrinterKotlin());
	}
	
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