package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class Test_00B_slogout extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://ion-beta.oceanobservatories.org/");
		selenium.start();
	}

	@Test
	public void test_00B_slogout() throws Exception {
		selenium.open("https://google.com/");
		selenium.click("id=gbg4");
		selenium.click("id=gb_71");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
