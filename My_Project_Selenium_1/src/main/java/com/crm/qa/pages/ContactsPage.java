package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	// Page Factory

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//div/input[@name='first_name']")
	WebElement first_name;

	@FindBy(xpath = "//input[@name='last_name']")
	WebElement last_name;

	@FindBy(xpath = "//div/input[@class='search']")
	WebElement company;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement Savebtn;

	// constructor
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	// actions
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void selectContactsByName(String name) {
		Actions action = new Actions(driver);
		WebElement contactlist = driver.findElement(By.xpath("//td/a[1][contains(text(),'" + name + "')] "));
		action.moveToElement(contactlist).build().perform();
	}

	public void createNewContact(String fname, String lname, String comp) {
		first_name.sendKeys(fname);
		last_name.sendKeys(lname);
		company.sendKeys(comp);
		Savebtn.click();
	}

}
