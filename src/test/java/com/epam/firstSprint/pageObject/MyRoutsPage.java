package com.epam.firstSprint.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.firstSprint.core.Driver;

public class MyRoutsPage {

	@FindBy(xpath = ".//*[@id='li_driverCalendar']/a")	
	//.//*[@id='li_driver']/a
	WebElement driverCalendar;

	public MyRoutsPage() {
		PageFactory.initElements(Driver.get(), this);
	}

	public DriverCalendarPage clickOnMyDriverCalendarTab() {
		this.driverCalendar.click();
		return new DriverCalendarPage();
	}

}
