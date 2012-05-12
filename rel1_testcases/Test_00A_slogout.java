package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class Test_00A_slogout extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://ion-beta.oceanobservatories.org/");
		selenium.start();
	}

	@Test
	public void test_00A_slogout() throws Exception {
		selenium.open("https://google.com/");
		Thread.sleep(5000);
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Zoo Tester")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		Thread.sleep(5000);
		selenium.click("id=gbg4");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("zootester63@gmail.com")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		Thread.sleep(5000);
		selenium.click("id=gb_71");
		selenium.waitForPageToLoad("5000");
		Thread.sleep(5000);
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
