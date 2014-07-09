package com.epam.firstSprint.pageObject;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import com.epam.firstSprint.core.Driver;

public class DriverCalendarPage {

	public By locatorForFromFilter = By.id("from_id");
	public By locatorForToFilter = By.id("to_id");
	public By locatorForTripStatusFilter = By.id("trip_status_id");
	public By locatorForSeatsTotalFilter = By.id("total_seats_id");
	public By locatorForSeatsOccupiedFilter = By.id("occupied_seats");
	public By locatorForSeatsFreeFilter = By.id("free_seats");
	public By locatorForRequestsFilter = By.id("requests");
		
	
	
	
	
	public By locatorForPaticularItemInFromFilter = By
			
			.xpath(".//*[@id='from_id']/option[2]");

	private By logout = By.cssSelector(".btn.btn-default");
	

	public boolean isElementPresent(By locator) {
		Driver.get().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		List<WebElement> elements = Driver.get().findElements(locator);
		Driver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return elements.size() > 0 && elements.get(0).isDisplayed();
	}

	public void clickOnFilter(By locator) {
		Driver.get().findElement(locator).click();
	}

	public void selectAllInFilter(By locator) {
		WebElement select = Driver.get().findElement(locator);
		List<WebElement> options = select.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if ("All".equals(option.getText()))
				option.click();

		}
	}

	public void paticularSelectionInFromFilter() throws InterruptedException {

		Select select = new Select(Driver.get().findElement(
				locatorForFromFilter));
		// finding the number of option using size() function
		int i = select.getOptions().size();
		// printing the size
		System.out.print("number of options = " + i + "\n");
		// selecting option in Drop-down using Visible Text
		select.selectByIndex(1);
	}

	public int countTripsInFromColume() {

		int n = 1;
		int count = 0;
		while (isElementPresent(By
				.xpath(".//*[@id='routeResults']/div/table/tbody/tr[" + n
						+ "]/td[1]"))) {
			count++;
			n++;
		}
		return count;
	}

	public BeforeLoginPage logout() {
		Driver.get().findElement(logout).click();
		return new BeforeLoginPage();
	}
}
