package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}
//testcases should be separate , independent with each other, so its a good practice to launch the browser each time.
	// to avoid browser performance,crash, blank page,cookie issues.
	// before each testlaunch browser, login
	// after each test close the browser.

	@BeforeMethod
	public void setUp() {
		initialization();

		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "HomePage Title not matched");
	}

	@Test(priority = 2)
	public void verifyLoginUserNameTest() {
		boolean flag = homePage.verifyUserName();
		Assert.assertEquals(flag, true, "user name is not matching");
	}

	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		contactsPage = homePage.clickOnContactsLink();
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
