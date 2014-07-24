package com.epam.firstSprint.tests;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.epam.firstSprint.core.BaseTest;
import com.epam.firstSprint.pageObject.DriverCalendarPage;
import com.epam.firstSprint.pageObject.MainPage;
import com.epam.firstSprint.pageObject.MyRoutsPage;

public class US01_4_2_14_1Test extends BaseTest {

	final int NUMBER_OF_COLUME = 7;
	final int QTY_OF_REQUESTS = 2;

	@Test(groups = { "SecondSuit" })
	public void selectionOfParticularRequestTest() throws SQLException {
		MainPage mainPage = new MainPage();
		MyRoutsPage myRoutsPage = mainPage.clickOnMyTripTab();
		DriverCalendarPage driverCalendarPage = myRoutsPage.clickOnMyDriverCalendarTab();
		driverCalendarPage.particularSelectionInRequestsFilter();
		
		// this user has two trips with 0 requests
		int expectedResultOfPaticularSelectionInRequestsFilter = QTY_OF_REQUESTS;		
		int actual = driverCalendarPage.countTripsInColume(NUMBER_OF_COLUME);
		
		Assert.assertEquals(actual,
				expectedResultOfPaticularSelectionInRequestsFilter,
				"The results in colume on the page and expected is not same!");
		
		Reporter.log("Done", 2, true);
	}
}
