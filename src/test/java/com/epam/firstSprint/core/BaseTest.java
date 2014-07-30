package com.epam.firstSprint.core;

import org.testng.annotations.*;

import com.epam.firstSprint.pageObject.BeforeLoginPage;
import com.epam.firstSprint.pageObject.DriverCalendarPage;

public class BaseTest {

	@BeforeSuite
	public void init() {
		Driver.init();
		BeforeLoginPage beforeLoginPage = BeforeLoginPage.open();
		beforeLoginPage.loginIntoSystem();
	}

	@AfterSuite
	public void cleanup() {
		DriverCalendarPage dcal = new DriverCalendarPage();
		dcal.logout();
		Driver.tearDown();
	}
}
