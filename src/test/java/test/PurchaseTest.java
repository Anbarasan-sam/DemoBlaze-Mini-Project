package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.CartPage;
import pages.HomePage;
import pages.OrderPage;
import pages.ProductDetailsPage;
import utils.UtilsClass;

public class PurchaseTest extends ProjectSpecificationMethods{
	private HomePage homePage;
	private ProductDetailsPage productPage;
	private CartPage cartPage;
	private OrderPage orderPage;

	@BeforeMethod(groups = "Purchase")
	public void setUp() {
		
		homePage = new HomePage(UtilsClass.driver);
		productPage = new ProductDetailsPage(UtilsClass.driver);
		cartPage = new CartPage(UtilsClass.driver);
		orderPage = new OrderPage(UtilsClass.driver);
	}

	@Test(groups = "Purchase")
	public void testRedirectionToPlaceOrderWindow() throws InterruptedException {

		homePage.selectProduct("Samsung galaxy s6");
		productPage.clickAddToCart();
		Thread.sleep(2000);
		acceptAlert();
		homePage.clickCart();
		Thread.sleep(2000);
		cartPage.clickPlaceOrder();
	}

	@Test(groups = "Purchase",priority=2)
	public void VerifyThePresenceOfTheUserDetailsSections() throws InterruptedException {
		
		homePage.selectProduct("Samsung galaxy s6");
		productPage.clickAddToCart();
		Thread.sleep(2000);
		acceptAlert();
		homePage.clickCart();
		Thread.sleep(2000);
		cartPage.clickPlaceOrder();
		Thread.sleep(2000);
		Assert.assertTrue(orderPage.isNameFieldVisible(), "Name field is not visible.");
		Assert.assertTrue(orderPage.isCountryFieldVisible(), "Country field is not visible.");
		Assert.assertTrue(orderPage.isCityFieldVisible(), "City field is not visible.");
	}

	@Test(groups = "Purchase",priority=3)
	public void testPurchaseByEnteringValidDetails() throws InterruptedException {
		
		homePage.selectProduct("Samsung galaxy s6");
		productPage.clickAddToCart();
		Thread.sleep(2000);
		acceptAlert();
		homePage.clickCart();
		Thread.sleep(2000);
		cartPage.clickPlaceOrder();

		orderPage.enterName("John Doe");
		orderPage.enterCountry("USA");
		orderPage.enterCity("New York");
		orderPage.enterCreditCard("1234 5678 9012 3456");
		orderPage.enterMonth("12");
		orderPage.enterYear("2025");

		orderPage.clickPurchaseButton();
	}

	@Test(groups = "Purchase",priority=4)
	public void verifySuccessfullPurchase() throws InterruptedException {
		
		homePage.selectProduct("Samsung galaxy s6");
		productPage.clickAddToCart();
		Thread.sleep(2000);
		acceptAlert();
		homePage.clickCart();
		Thread.sleep(2000);
		cartPage.clickPlaceOrder();

		orderPage.enterName("John Doe");
		orderPage.enterCountry("USA");
		orderPage.enterCity("New York");
		orderPage.enterCreditCard("1234 5678 9012 3456");
		orderPage.enterMonth("12");
		orderPage.enterYear("2025");

		orderPage.clickPurchaseButton();

		Assert.assertTrue(orderPage.isConfirmationModalDisplayed(), "Confirmation modal not displayed.");
		String confirmation = orderPage.getConfirmationMessage();
		Thread.sleep(2000);
		Assert.assertTrue(confirmation.contains("Thank you for your purchase!"),
				"Purchase confirmation not successful.");
	}
}
