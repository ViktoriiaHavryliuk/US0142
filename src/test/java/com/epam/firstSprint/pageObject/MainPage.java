package com.epam.firstSprint.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.firstSprint.core.Driver;

public class MainPage {

	@FindBy(id = "my_trips")
	WebElement tripsButton;

	public MainPage() {
		PageFactory.initElements(Driver.get(), this);
	}

	public MyRoutsPage clickOnMyTripTab() {
		this.tripsButton.click();
		return new MyRoutsPage();
	}

}
