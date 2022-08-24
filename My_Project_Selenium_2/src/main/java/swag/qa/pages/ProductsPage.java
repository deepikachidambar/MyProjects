package swag.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swag.qa.base.TestBase;

public class ProductsPage extends TestBase {

	// create page Factory object repository

	@FindBy(xpath = "//span[contains(text(),'Products')]")
	WebElement productText;

	@FindBy(xpath = "//div[@class='app_logo']")
	WebElement appLogo;

	@FindBy(xpath = "//div[@id='shopping_cart_container']")
	WebElement shoppingCartContainer;

	@FindBy(xpath = "//div/img[@Alt='Open Menu']")
	WebElement menuButton;

	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Backpack')]")
	WebElement slBackpack;
	
	@FindBy(xpath = "//img[@class='footer_robot']")
	WebElement footerRobot;

	@FindBy(xpath = "//div[@class='footer_copy']")
	WebElement footerCopy;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement addToCart;


	public ProductsPage() {
		PageFactory.initElements(driver, this);
	}

}
