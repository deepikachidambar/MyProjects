package swag.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swag.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//create object repository
	
	@FindBy(xpath = "//div[@class='login_logo']")
	WebElement swagLogo;

	@FindBy(xpath = "// input[@id='user-name']")
	WebElement userName;
	
	@FindBy(xpath = "//*[@id=\'password\']")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\'login-button\']")
	WebElement loginButton;

	@FindBy(xpath = "//div[@class='bot_column']")
	WebElement botColumn;

	@FindBy(xpath = "//div[contains(text(),'secret_sauce')]")
	WebElement passwordHint;

	// initialize page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public String validateTitle() {
		String title = driver.getTitle();
		return title;
	}
	public boolean validateSwagLogo() {
		return swagLogo.isDisplayed();
	}

	public boolean validateBotColumn() {
		return botColumn.isDisplayed();
	}

	public boolean validatePasswordHint() {
		return passwordHint.isDisplayed();
	}

	public ProductsPage loginSwag(String un, String pwd) {
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		return new ProductsPage();
	}

}
