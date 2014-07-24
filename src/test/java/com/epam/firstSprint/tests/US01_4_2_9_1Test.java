package com.epam.firstSprint.tests;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.epam.firstSprint.core.BaseTest;
import com.epam.firstSprint.pageObject.DriverCalendarPage;
import com.epam.firstSprint.pageObject.MainPage;
import com.epam.firstSprint.pageObject.MyRoutsPage;

public class US01_4_2_9_1Test extends BaseTest {
	
	final int NUMBER_OF_COLUME = 2;

	@Test(groups = { "SecondSuit" })
	public void selectionOfParticularToTripTest() throws SQLException {
		MainPage mainPage = new MainPage();
		MyRoutsPage myRoutsPage = mainPage.clickOnMyTripTab();
		DriverCalendarPage driverCalendarPage = myRoutsPage.clickOnMyDriverCalendarTab();
		driverCalendarPage.particularSelectionInToFilter();
		
		int expectedResultOfPaticularSelectionInToFilter = countRecordsInColumnFromDb(System.getProperty("test.queryTo"));//countRecordsFromDb();
		int actual = driverCalendarPage.countTripsInColume(NUMBER_OF_COLUME);
		
		Assert.assertEquals(actual, expectedResultOfPaticularSelectionInToFilter,
				"The results in colume on the page and from DB is not same!");
		
		Reporter.log("Done", 2, true);
	}
}
