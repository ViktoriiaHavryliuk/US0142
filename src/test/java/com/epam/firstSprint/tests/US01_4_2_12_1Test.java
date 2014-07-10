package com.epam.firstSprint.tests;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.epam.firstSprint.core.BaseTest;
import com.epam.firstSprint.pageObject.DriverCalendarPage;
import com.epam.firstSprint.pageObject.MainPage;
import com.epam.firstSprint.pageObject.MyRoutsPage;

public class US01_4_2_12_1Test extends BaseTest {

	final int NUMBER_OF_COLUME = 5;
	final int QTY_OF_SEATSOCCUPIED = 3;

	@Test(groups = { "SecondSuit" })
	public void selectionOfParticularSeatsOccupiedTest() throws SQLException {
		MainPage mainPage = new MainPage();
		MyRoutsPage myRoutsPage = mainPage.clickOnMyTripTab();
		DriverCalendarPage driverCalendarPage = myRoutsPage
				.clickOnMyDriverCalendarTab();
		driverCalendarPage
				.paticularSelectionInFilter(driverCalendarPage.locatorForSeatsOccupiedFilter);
		
		// this user has two trip with 5 total seats
		int expectedResultOfPaticularSelectionInSeatsOccupiedFilter = QTY_OF_SEATSOCCUPIED;		
		int actual = driverCalendarPage
				.countTripsInColume(NUMBER_OF_COLUME);
		
		Assert.assertEquals(actual,
				expectedResultOfPaticularSelectionInSeatsOccupiedFilter,
				"The results in colume on the page and expected is not same!");
		
		Reporter.log("Done", 2, true);
	}
}
