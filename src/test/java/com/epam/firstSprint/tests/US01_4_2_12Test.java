package com.epam.firstSprint.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.epam.firstSprint.core.BaseTest;
import com.epam.firstSprint.pageObject.DriverCalendarPage;
import com.epam.firstSprint.pageObject.MainPage;
import com.epam.firstSprint.pageObject.MyRoutsPage;

public class US01_4_2_12Test extends BaseTest {
	
	final int NUMBER_OF_COLUME = 5;
	final int QTY_OF_TRIPS = 3;

	@Test(groups = { "SecondSuit" })
	public void functionalityOfFilterSeatsOccupiedTest() throws InterruptedException {
		MainPage mainPage = new MainPage();
		MyRoutsPage myRoutsPage = mainPage.clickOnMyTripTab();
		DriverCalendarPage driverCalendarPage = myRoutsPage.clickOnMyDriverCalendarTab();
		driverCalendarPage.selectAllInSeatsOccupiedFilter();
		
		int expectedResultOfAllSelectionsInSeatsOccupiedFilter = QTY_OF_TRIPS;
		int actual = driverCalendarPage.countTripsInColume(NUMBER_OF_COLUME);
		
		Assert.assertEquals(
				actual,
				expectedResultOfAllSelectionsInSeatsOccupiedFilter,
				"The results in colume \"Seats occupied\" on the page and expected from paticular user is not same!");
		
		Reporter.log("Done", 2, true);
	}
}
