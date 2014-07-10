package com.epam.firstSprint.tests;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.epam.firstSprint.core.BaseTest;
import com.epam.firstSprint.pageObject.DriverCalendarPage;
import com.epam.firstSprint.pageObject.MainPage;
import com.epam.firstSprint.pageObject.MyRoutsPage;

public class US01_4_2_13_1Test extends BaseTest {

	final int NUMBER_OF_COLUME = 6;
	final int QTY_OF_FREESEATS = 2;

	@Test(groups = { "SecondSuit" })
	public void selectionOfParticularFreeSeatsTest() throws SQLException {
		MainPage mainPage = new MainPage();
		MyRoutsPage myRoutsPage = mainPage.clickOnMyTripTab();
		DriverCalendarPage driverCalendarPage = myRoutsPage
				.clickOnMyDriverCalendarTab();
		driverCalendarPage
				.paticularSelectionInFilter(driverCalendarPage.locatorForSeatsFreeFilter);
		
		// this user has two trip with 5 free seats
		int expectedResultOfPaticularSelectionInFreeSeatsFilter = QTY_OF_FREESEATS;		
		int actual = driverCalendarPage
				.countTripsInColume(NUMBER_OF_COLUME);
		
		Assert.assertEquals(actual,
				expectedResultOfPaticularSelectionInFreeSeatsFilter,
				"The results in colume on the page and expected is not same!");
		
		Reporter.log("Done", 2, true);
	}
}
