package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class Test_Sample extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://ion-beta.oceanobservatories.org/");
		selenium.start();
	}

	@Test
	public void test_Sample() throws Exception {
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
			try { if (selenium.isTextPresent("Showing 1 to")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("//tr[@id='2512EE08-9627-4B90-B938-CF96E116F2C0']/td[1]");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("CGSN_AS02CPSM real time data from 3dmgx3")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("radioAltitudeDefined");
		selenium.type("ge_altitude_ub", "8");
		selenium.click("apply_filter_button");
		Thread.sleep(10000);
		selenium.click("radioAllPubRes");
		Thread.sleep(10000);
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Showing 1 to 20 of 77 entries")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
