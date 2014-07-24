package com.epam.firstSprint.tests;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.epam.firstSprint.core.BaseTest;
import com.epam.firstSprint.pageObject.DriverCalendarPage;
import com.epam.firstSprint.pageObject.MainPage;
import com.epam.firstSprint.pageObject.MyRoutsPage;

public class US01_4_2_10_1Test extends BaseTest {

	final int NUMBER_OF_COLUME = 3;
	final int QTY_OF_CONFIRMEDTRIPSTATUS = 1;

	@Test(groups = { "SecondSuit" })
	public void selectionOfParticularTripStatusTest() throws SQLException {
		MainPage mainPage = new MainPage();
		MyRoutsPage myRoutsPage = mainPage.clickOnMyTripTab();
		DriverCalendarPage driverCalendarPage = myRoutsPage.clickOnMyDriverCalendarTab();
		driverCalendarPage.particularSelectionInTripStatusFilter();
		
		// this user has one trip with Confirmed status
		int expectedResultOfPaticularSelectionInTripStatusFilter = QTY_OF_CONFIRMEDTRIPSTATUS;		
		int actual = driverCalendarPage.countTripsInColume(NUMBER_OF_COLUME);
		
		Assert.assertEquals(actual,
				expectedResultOfPaticularSelectionInTripStatusFilter,
				"The results in colume on the page and expected is not same!");
		
		Reporter.log("Done", 2, true);
	}
}
