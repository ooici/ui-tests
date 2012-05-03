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
		selenium.select("id=providerId", "label=University of California-San Diego");
		selenium.click("id=keepidp");
		selenium.click("id=keepidp");
		selenium.click("id=wayflogonbutton");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=urn:mace:ucsd.edu:sso:actsso:password", "");
		selenium.type("id=urn:mace:ucsd.edu:sso:actsso:username", "mmoniza@ucsd.edu");
		selenium.type("id=urn:mace:ucsd.edu:sso:actsso:password", "Xyz01345");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
