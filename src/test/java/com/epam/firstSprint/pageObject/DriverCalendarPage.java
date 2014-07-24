package com.epam.firstSprint.pageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.epam.firstSprint.core.Driver;

public class DriverCalendarPage {

	private By locatorForFromFilter = By.id("from_id");
	private By locatorForToFilter = By.id("to_id");
	private By locatorForTripStatusFilter = By.id("trip_status_id");
	private By locatorForSeatsTotalFilter = By.id("total_seats_id");
	private By locatorForSeatsOccupiedFilter = By.id("occupied_seats");
	private By locatorForSeatsFreeFilter = By.id("free_seats");
	private By locatorForRequestsFilter = By.id("requests");
	private By logout = By.cssSelector(".btn.btn-default");

	public boolean isElementPresent(By locator) {
		Driver.get().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		List<WebElement> elements = Driver.get().findElements(locator);
		Driver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return elements.size() > 0 && elements.get(0).isDisplayed();
	}
	
	public boolean isFilterFromPresent() {
		return isElementPresent(locatorForFromFilter);
	}
	
	public boolean isFilterToPresent() {
		return isElementPresent(locatorForToFilter);
	}
	
	public boolean isFilterTripStatusPresent() {
		return isElementPresent(locatorForTripStatusFilter);
	}
	
	public boolean isFilterSeatsTotalPresent() {
		return isElementPresent(locatorForSeatsTotalFilter);
	}
	
	public boolean isFilterSeatsOccupiedPresent() {
		return isElementPresent(locatorForSeatsOccupiedFilter);
	}
	
	public boolean isFilterSeatsFreePresent() {
		return isElementPresent(locatorForSeatsFreeFilter);
	}
	
	public boolean isFilterRequestsPresent() {
		return isElementPresent(locatorForRequestsFilter);
	}

//	public void clickOnFilter(By locator) {
//		Driver.get().findElement(locator).click();
//	}

	public void selectAllInFilter(By locator) {
		Select select = new Select(Driver.get().findElement(locator));
		// selecting option in Drop-down using Index
		select.selectByIndex(0);
	}
	
	public void selectAllInFromFilter(){
		selectAllInFilter(locatorForFromFilter);
	}
	
	public void selectAllInToFilter(){
		selectAllInFilter(locatorForToFilter);
	}
	
	public void selectAllInTripStatusFilter(){
		selectAllInFilter(locatorForTripStatusFilter);
	}
	
	public void selectAllInSeatsTotalFilter(){
		selectAllInFilter(locatorForSeatsTotalFilter);
	}
	
	public void selectAllInSeatsOccupiedFilter(){
		selectAllInFilter(locatorForSeatsOccupiedFilter);
	}
	
	public void selectAllInSeatsFreeFilter(){
		selectAllInFilter(locatorForSeatsFreeFilter);
	}
	
	public void selectAllInRequestsFilter(){
		selectAllInFilter(locatorForRequestsFilter);
	}

	public void particularSelectionInFilter(By locator) {
		Select select = new Select(Driver.get().findElement(locator));
		// selecting option in Drop-down using Index
		select.selectByIndex(1);
	}
	
	public void particularSelectionInFromFilter(){
		particularSelectionInFilter(locatorForFromFilter);
	}
	
	public void particularSelectionInToFilter(){
		particularSelectionInFilter(locatorForToFilter);
	}
	
	public void particularSelectionInTripStatusFilter(){
		particularSelectionInFilter(locatorForTripStatusFilter);
	}
	
	public void particularSelectionInSeatsTotalFilter(){
		particularSelectionInFilter(locatorForSeatsTotalFilter);
	}
	
	public void particularSelectionInSeatsOccupiedFilter(){
		particularSelectionInFilter(locatorForSeatsOccupiedFilter);
	}
	
	public void particularSelectionInSeatsFreeFilter(){
		particularSelectionInFilter(locatorForSeatsFreeFilter);
	}
	
	public void particularSelectionInRequestsFilter(){
		particularSelectionInFilter(locatorForRequestsFilter);
	}

	public int countTripsInColume(int num) {

		int n = 1;
		int count = 0;
		
		while (isElementPresent(By
				.xpath(".//*[@id='routeResults']/div/table/tbody/tr[" + n
						+ "]/td["+num+"]"))) {
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
