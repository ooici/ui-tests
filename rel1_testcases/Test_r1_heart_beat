package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class Test_r1_heart_beat extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://ion-beta.oceanobservatories.org/");
		selenium.start();
	}

	@Test
	public void test_r1_heart_beat() throws Exception {
		selenium.open("http://ion-beta.oceanobservatories.org/");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Release 1 (R1) provides an operat")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("guest_button");
		selenium.waitForPageToLoad("30000");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("XYZ")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
