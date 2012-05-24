package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class Test_R2_Base extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:3000/");
		selenium.start();
	}

	@Test
	public void test_R2_Base() throws Exception {
		selenium.open("https://www.google.com/doodles/finder/2012/All%20doodles");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Doodles")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		Thread.sleep(2000);
		selenium.open("/data_products/");
		selenium.click("link=Data Products");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Data Products")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("link=Observatories");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Observatories")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("link=Platforms");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Platforms")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("link=Platform Models");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Platform Models")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("link=Instrument Agents");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Instrument Agents")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("link=Data Process Definitions");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Data Process Definitions")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("link=Frame Of References");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Frame of References")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("link=Users");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Users")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("link=Observatory");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("New Observatory")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("link=Platform Model");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("New Platform Model")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("link=Platform Device");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("New Platform Device")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("link=Intrument Model");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("New Instrument Model")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("link=Instrument Device");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("New Instrument Device")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("link=Frame of Reference");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("New Frame of Reference")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.open("http://google.com");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("I'm Feeling Lucky")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.open("https://www.google.com/doodles/finder/2012/All%20doodles");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Doodles")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
