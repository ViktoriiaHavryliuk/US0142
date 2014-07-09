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

		/*
		 * //locate the menu to hover over using its xpath WebElement menu =
		 * Driver.get().findElement(locatorForItemInFromFilter);
		 * 
		 * //Initiate mouse action using Actions class Actions builder = new
		 * Actions(Driver.get());
		 * 
		 * // move the mouse to the earlier identified menu option
		 * builder.moveToElement(menu).build().perform();
		 * 
		 * // wait for max of 5 seconds before proceeding. This allows sub menu
		 * appears properly before trying to click on it WebDriverWait wait =
		 * new WebDriverWait(Driver.get(), 5);
		 * wait.until(ExpectedConditions.presenceOfElementLocated
		 * (locatorForPaticularItemInFromFilter)); // until this submenu is
		 * found
		 * 
		 * //identify menu option from the resulting menu display and click
		 * WebElement menuOption =
		 * Driver.get().findElement(locatorForPaticularItemInFromFilter);
		 * menuOption.click(); Thread.sleep(5000);
		 */

		// String valueToSelect=
		// "Киевская область, Киев, Оболонский район, Вербная улица";
		Select select = new Select(Driver.get().findElement(
				locatorForFromFilter));
		// finding the number of option using size() function
		int i = select.getOptions().size();
		// printing the size
		System.out.print("number of options = " + i + "\n");
		// selecting option in Drop-down using Visible Text
		select.selectByIndex(2);
		Thread.sleep(10000);

		// selecting option in Drop-down using value attribute
		// select.selectByValue("4");
		// selecting option in Drop-down using value attribute
		// select.selectByIndex(1);

//		String valueToSelect = "Киевская область, Киев, Оболонский район, Вербная улица";
//		WebElement select = Driver.get()
//				.findElement(locatorForItemInFromFilter);
//		Select dropDown = new Select(select);
//		String selected = dropDown.getFirstSelectedOption().getText();
//		if (selected.equals(valueToSelect)) {// do stuff already selected}
//			List<WebElement> Options = dropDown.getOptions();
//			for (WebElement option : Options) {
//				if (option.getText().equals(valueToSelect)) {
//					option.click();
//				}
//			}
//		}
//
//		WebElement dropDownListBox = Driver.get().findElement(
//				locatorForItemInFromFilter);
//		Select clickThis = new Select(dropDownListBox);
//		clickThis
//				.selectByVisibleText("Киевская область, Киев, Оболонский район, Вербная улица");
//		Thread.sleep(8000);
//
//		WebElement select = Driver.get()
//				.findElement(locatorForItemInFromFilter);
//		List<WebElement> options = select.findElements(By.tagName("option"));
//		Actions builder = new Actions(Driver.get());
//		for (WebElement option : options) {
//			if ("Киевская область, Киев, Оболонский район, Вербная улица"
//					.equals(option.getText())) {
//				Action click = builder.click(option).build();
//				click.perform();
//				Thread.sleep(8000);
//			}
//
//		}

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
