package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	// Page Factory- Object Repository
	@FindBy(xpath = "//b[contains(text(),'Deepika')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[@href='/contacts']")
	WebElement contactsLink;

	@FindBy(xpath = "//a[@href='/deals']")
	WebElement dealsLink;

	@FindBy(xpath = "//a[@href='/tasks']")
	WebElement tasksLink;

	@FindBy(xpath = "//button[contains(text(),'Create')]/i")
	WebElement newContactLink;

	// create Constructor ofHomePage
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}

	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}

	public void createNewContactLink() {
		newContactLink.click();
	}
}
