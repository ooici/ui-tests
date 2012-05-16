package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

// Marco 5/16/2012

public class Test_00AA_slogout extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "https://www.google.com/");
		selenium.start();
	}

	@Test
	public void test_00AA_slogout() throws Exception {
		selenium.open("https://google.com");
		for (int second = 0;; second++) {
			if (second >= 10) fail("timeout");
			try { if (selenium.isTextPresent("Search")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("css=span.gbmai");
		for (int second = 0;; second++) {
			if (second >= 10) fail("timeout");
			try { if (selenium.isTextPresent("Sign out")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("id=gb_71");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(3000);
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
