package swag.qa.testclasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import swag.qa.base.TestBase;
import swag.qa.pages.LoginPage;
import swag.qa.pages.ProductsPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	ProductsPage productsPage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initBrowser();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void validateTitleTest() {
		String actualTitle = loginPage.validateTitle();
		Assert.assertEquals(actualTitle, "Swag Labs");
	}

	@Test(priority = 2)
	public void validateSwagLogoTest() {
		boolean flag = loginPage.validateSwagLogo();
		Assert.assertEquals(flag, true, "swag logo is visible");
	}

	@Test(priority = 3)
	public void validateBotTest() {
		boolean flag = loginPage.validateBotColumn();
		Assert.assertEquals(flag, true, " bot is visible");
	}

	@Test(priority = 4)
	public void validatePasswordHint() {
		boolean flag = loginPage.validatePasswordHint();
		Assert.assertEquals(flag, true, " password is visible");
	}

	@Test(priority = 5, dependsOnMethods = "validatePasswordHint")
	public void validateLoginTest() {
		productsPage = loginPage.loginSwag(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
