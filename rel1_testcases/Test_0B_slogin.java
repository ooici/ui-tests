package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class Test_0B_slogin extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://ion-beta.oceanobservatories.org/");
		selenium.start();
	}

	@Test
	public void test_0B_slogin() throws Exception {
		selenium.open("https://www.google.com/");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("A faster way to browse the web")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		Thread.sleep(5000);
		selenium.open("/");
		Thread.sleep(5000);
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
			try { if (selenium.isTextPresent("for some information from your Google Account.")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.type("id=Email", "U_S_E_R-N_A_M_E");
		selenium.type("id=Passwd", "P_A_S_S-W_O_R_D");
		Thread.sleep(1000);
		selenium.click("id=PersistentCookie");
		selenium.click("id=signIn");
		selenium.waitForPageToLoad("30000");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Showing 1 to")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.selectWindow("null");
		selenium.click("id=logout_link");
		selenium.waitForPageToLoad("30000");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Getting Started")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		Thread.sleep(5000);
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
