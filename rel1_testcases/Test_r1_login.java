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
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Remember this selection:".equals(selenium.getText("//p[4]/label"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.select("id=providerId", "label=Google");
		selenium.uncheck("id=keepidp");
		selenium.click("id=wayflogonbutton");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Sign in".equals(selenium.getText("css=h2"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

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
