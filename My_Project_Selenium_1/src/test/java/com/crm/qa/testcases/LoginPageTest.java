package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.ValidateLoginPageTitle();
		Assert.assertEquals(title,
				"Free CRM software for customer relationship management, sales, marketing campaigns and support.");
	}

	@Test(priority = 2)
	public void CRMlogoTest() {
		boolean flag = loginpage.validateCRMImage();
		Assert.assertEquals(flag, true, "CRM LOGO is visible");
	}

	@Test(priority = 3)
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
