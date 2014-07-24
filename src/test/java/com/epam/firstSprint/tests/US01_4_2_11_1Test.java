package com.epam.firstSprint.tests;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.epam.firstSprint.core.BaseTest;
import com.epam.firstSprint.pageObject.DriverCalendarPage;
import com.epam.firstSprint.pageObject.MainPage;
import com.epam.firstSprint.pageObject.MyRoutsPage;

public class US01_4_2_11_1Test extends BaseTest {

	final int NUMBER_OF_COLUME = 4;
	final int QTY_OF_SEATSTOTAL = 1;

	@Test(groups = { "SecondSuit" })
	public void selectionOfParticularTotalSeatsTest() throws SQLException {
		MainPage mainPage = new MainPage();
		MyRoutsPage myRoutsPage = mainPage.clickOnMyTripTab();
		DriverCalendarPage driverCalendarPage = myRoutsPage.clickOnMyDriverCalendarTab();
		driverCalendarPage.particularSelectionInSeatsTotalFilter();
		
		// this user has one trip with 5 total seats
		int expectedResultOfPaticularSelectionInSeatsTotalFilter = QTY_OF_SEATSTOTAL;		
		int actual = driverCalendarPage.countTripsInColume(NUMBER_OF_COLUME);
		
		Assert.assertEquals(actual,
				expectedResultOfPaticularSelectionInSeatsTotalFilter,
				"The results in colume on the page and expected is not same!");
		
		Reporter.log("Done", 2, true);
	}
}
