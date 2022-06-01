package tests;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import pages.SauceCheckoutPage;
import pages.SauceDemoLandingPage;
import pages.SauceInventoryPage;

public class SauceDemoTest {

	private static WebDriver driver;
	private SauceInventoryPage invePage;
	private SauceCheckoutPage checkPage;

	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);
		driver = new ChromeDriver(options);
	}

	@Before
	public void setup() {
		driver.get(SauceDemoLandingPage.URL);
	}

	@Test
	public void addItemsToBasketTest() {
		this.invePage = PageFactory.initElements(driver, SauceInventoryPage.class);
		this.checkPage = PageFactory.initElements(driver, SauceCheckoutPage.class);
		SauceDemoLandingPage landingPage = new SauceDemoLandingPage(driver);
		
		landingPage.login("standard_user", "secret_sauce");
		invePage.addToBasket();
		
		invePage.clickCart();

		assertEquals(6, checkPage.getCartItems().size());
	}

	@AfterClass
	public static void cleanup() {
		driver.quit();
	}
}


//Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
//.withTimeout(Duration.ofSeconds(30))
//.pollingEvery(Duration.ofSeconds(5))
//.ignoring(NoSuchElementException.class);
//
//fluentWait.until(ExpectedConditions.elementToBeClickable(By.id("addsasda")));
