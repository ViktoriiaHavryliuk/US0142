package com.epam.firstSprint.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.epam.firstSprint.core.BaseTest;
import com.epam.firstSprint.pageObject.DriverCalendarPage;
import com.epam.firstSprint.pageObject.MainPage;
import com.epam.firstSprint.pageObject.MyRoutsPage;

public class US01_4_2_7Test extends BaseTest {

	@Test(groups = { "FirstSuit" })
	public void checkPresenceOfFilterRequestsTest() {
		MainPage mainPage = new MainPage();
		MyRoutsPage myRoutsPage = mainPage.clickOnMyTripTab();
		DriverCalendarPage driverCalendarPage = myRoutsPage
				.clickOnMyDriverCalendarTab();
		Assert.assertTrue(driverCalendarPage.isFilterRequestsPresent(),
				"Filter \"Requests\" is not on the page!");
		Reporter.log("Done", 2, true);
	}
}
