package com.epam.firstSprint.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.firstSprint.core.Driver;

public class BeforeLoginPage {

	@FindBy(id = "inputUsername")
	WebElement username;

	@FindBy(id = "inputPassw")
	WebElement password;

	@FindBy(name = "submit")
	WebElement button;

	public BeforeLoginPage() {
		PageFactory.initElements(Driver.get(), this);
	}

	public void enterUserName() {
		this.username.sendKeys(System.getProperty("test.login"));
	}

	public void enterPassord() {
		this.password.sendKeys(System.getProperty("test.password"));
	}

	public void pressEnterButton() {
		this.button.click();

	}

	public MainPage loginIntoSystem() {
		enterUserName();
		enterPassord();
		pressEnterButton();
		return new MainPage();
	}

	public static BeforeLoginPage open() {
		Driver.get().get(System.getProperty("test.baseURL"));
		return new BeforeLoginPage();
	}
}
