package org.aadi.jacocoDemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMessages {

	@Test
	public void testNameDailyCodeBuffer()
	{
		Messages obj = new Messages();
		Assertions.assertEquals("Welcome Mr. Aaditya!!", obj.getMessage("Mr. Aaditya"));
	}

	@Test
	public void testNameBlank()
	{
		Messages obj = new Messages();
		Assertions.assertEquals("Kindly insert any name!!", obj.getMessage(""));
	}

	@Test
	public void testNameNull()
	{
		Messages obj = new Messages();
		Assertions.assertEquals("Kindly insert any name!!", obj.getMessage(null));
	}

}