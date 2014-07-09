package com.epam.firstSprint.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.epam.firstSprint.core.BaseTest;
import com.epam.firstSprint.pageObject.DriverCalendarPage;
import com.epam.firstSprint.pageObject.MainPage;
import com.epam.firstSprint.pageObject.MyRoutsPage;

public class US01_4_2_14Test extends BaseTest {

	@Test(groups = { "SecondSuit" })
	public void functionalityOfFilterRequestsTest() throws InterruptedException {
		MainPage mainPage = new MainPage();
		MyRoutsPage myRoutsPage = mainPage.clickOnMyTripTab();
		DriverCalendarPage driverCalendarPage = myRoutsPage
				.clickOnMyDriverCalendarTab();
		driverCalendarPage
				.clickOnFilter(driverCalendarPage.locatorForRequestsFilter);
		driverCalendarPage
				.selectAllInFilter(driverCalendarPage.locatorForRequestsFilter);
		int expectedResultOfAllSelectionsInFromFilter = 3;
		int actual = driverCalendarPage.countTripsInFromColume();
		Assert.assertEquals(
				actual,
				expectedResultOfAllSelectionsInFromFilter,
				"The results in colume \"Requests\" on the page and expected from paticular user is not same!");
		Reporter.log("Done", 2, true);
	}
}
