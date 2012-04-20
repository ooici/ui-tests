package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class Test_R2_Scen2 extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://67.58.40.163:3000/");
		selenium.start();
	}

	@Test
	public void test_R2_Scen2() throws Exception {
		selenium.open("/data_process_definitions/");
		Thread.sleep(2000);
		selenium.click("link=Observatory");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("New Observatory")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		Thread.sleep(2000);
		selenium.click("link=Frame of Reference");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("New Frame of Reference")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		Thread.sleep(2000);
		selenium.click("link=Data Products");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Collection: Data Products")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		Thread.sleep(2000);
		selenium.click("link=CTDBP-1012-REC1 Parsed Endurance OR Offshore Benthic Pkg Demo");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Data Product")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		Thread.sleep(2000);
		selenium.click("link=Observatory");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("New Observatory")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
