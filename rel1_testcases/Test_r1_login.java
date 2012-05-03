package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class Test_r1_login extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://ion-beta.oceanobservatories.org/");
		selenium.start();
	}

	@Test
	public void test_r1_login() throws Exception {
		selenium.open("/");
		selenium.click("id=login_button");
		selenium.waitForPageToLoad("30000");
		selenium.select("id=providerId", "label=Google");
		selenium.click("id=keepidp");
		selenium.click("id=keepidp");
		selenium.click("id=wayflogonbutton");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		selenium.type("id=Email", "zootester63");
		selenium.type("id=Passwd", "zootester63");
		selenium.click("id=PersistentCookie");
		selenium.click("id=signIn");
		selenium.waitForPageToLoad("30000");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Showing 1 to")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}