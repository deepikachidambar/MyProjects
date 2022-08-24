
package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts label is missing on the page");
	}

	@Test(priority=2)
	public void selectContactsTest() throws InterruptedException
	{
		homePage.clickOnContactsLink();
		contactsPage.selectContactsByName("deep chid");
	}

	@DataProvider
	public Object[][] getCRMTestDataTest() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;

	}

	@Test(priority = 3, dataProvider = "getCRMTestDataTest")
	public void validateCreateNewContact(String fname, String lname, String comp) {
		homePage.createNewContactLink();
		contactsPage.createNewContact(fname, lname, comp);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
