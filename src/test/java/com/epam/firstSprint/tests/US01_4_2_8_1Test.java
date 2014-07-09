package com.epam.firstSprint.tests;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.epam.firstSprint.core.BaseTest;
import com.epam.firstSprint.pageObject.DriverCalendarPage;
import com.epam.firstSprint.pageObject.MainPage;
import com.epam.firstSprint.pageObject.MyRoutsPage;

public class US01_4_2_8_1Test extends BaseTest {

	@Test(groups = { "SecondSuit" })
	public void selectionOfParticularTripTest() throws InterruptedException, SQLException {
		MainPage mainPage = new MainPage();
		MyRoutsPage myRoutsPage = mainPage.clickOnMyTripTab();
		DriverCalendarPage driverCalendarPage = myRoutsPage
				.clickOnMyDriverCalendarTab();
		driverCalendarPage
				.clickOnFilter(driverCalendarPage.locatorForFromFilter);
		driverCalendarPage.paticularSelectionInFromFilter();
		int expectedResultOfAllSelectionsInFromFilter = countRecordsInFromColumnFromDb();//countRecordsFromDb();
		int actual = driverCalendarPage.countTripsInFromColume();
		Assert.assertEquals(actual, expectedResultOfAllSelectionsInFromFilter,
				"The results in colume on the page and from DB is not same!");
		Reporter.log("Done", 2, true);
	}
}
