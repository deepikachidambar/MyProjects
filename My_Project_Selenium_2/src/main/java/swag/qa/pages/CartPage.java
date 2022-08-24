package swag.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swag.qa.base.TestBase;

public class CartPage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Your Cart')]")
	WebElement yourCart;

	@FindBy(xpath = "//div[@class='cart_quantity_label']")
	WebElement cartQuantity;

	@FindBy(xpath = "//div[@class='cart_desc_label']")
	WebElement cartDescription;

	@FindBy(xpath = "//button[@id='continue-shopping']")
	WebElement continueShoppingBtn;

	@FindBy(xpath = "//button[@id='checkout']")
	WebElement checkOutBtn;

	@FindBy(xpath = "//div/a[@class='shopping_cart_link']")
	WebElement shoppingCartLink;

	public CartPage() {
		PageFactory.initElements(driver, this);
	}

}
