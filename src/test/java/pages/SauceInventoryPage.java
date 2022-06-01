package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceInventoryPage {
	
	
	@FindBy(className = "btn")
	List<WebElement> addToCartBtns;
	
	@FindBy(className = "shopping_cart_link")
	WebElement checkoutBtn;

	public void addToBasket() {
		for(WebElement btn : addToCartBtns) {
			btn.click();
		}
	}
	
	public void clickCart() {
		checkoutBtn.click();
	}
	
}
