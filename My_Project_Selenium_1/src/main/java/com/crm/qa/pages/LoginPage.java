package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// PageFactory - Object Repository(OR)

	@FindBy(xpath = "//li/a[contains(text(),'Login')]")
	WebElement loginText;

	@FindBy(xpath = "//input[@name='email']")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//div[contains(text(),'Login') and contains(@class,'submit')]")
	WebElement loginBtn;

	@FindBy(xpath = "//li/a[text()='Sign Up']")
	WebElement SignUpBtn;

	@FindBy(xpath = "//a/img[contains(@class, 'img-responsive')]")
	WebElement crmLogo;

	// initialize page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		loginText.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}

}
