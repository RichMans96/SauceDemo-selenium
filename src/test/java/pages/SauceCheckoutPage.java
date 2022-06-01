package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceCheckoutPage {

	
	@FindBy(className = "cart_item")
	private List<WebElement> cartItems;

	public List<WebElement> getCartItems() {
		return cartItems;
	}

	
	
}
