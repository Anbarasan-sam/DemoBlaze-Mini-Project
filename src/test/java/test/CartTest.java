package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;

import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import utils.UtilsClass;

public class CartTest extends ProjectSpecificationMethods{

    private HomePage homePage;
    private ProductDetailsPage productPage;
    private CartPage cartPage;

	@BeforeMethod
    public void setup() {
        homePage = new HomePage(UtilsClass.driver);
        productPage = new ProductDetailsPage(UtilsClass.driver);
        cartPage = new CartPage(UtilsClass.driver); 
    }

    @Test(groups = "Cart", priority = 1)
    public void testTotalPriceCalculationAfterModification() throws InterruptedException {
        homePage.selectProduct("Samsung Galaxy S6");
        productPage.clickAddToCart();
        Thread.sleep(2000);
        acceptAlert();
        homePage.clickHomeMenu();
        homePage.selectProduct("Nokia lumia 1520");
        productPage.clickAddToCart();
        Thread.sleep(2000);
        acceptAlert();
        homePage.clickCart();
        double totalPrice = cartPage.getTotalPrice();
        Thread.sleep(6000);
        Assert.assertEquals(totalPrice, 1180, "Total price calculation is incorrect.");
    }

    @Test(groups = "Cart", priority = 2)
    public void testDeleteProductFromCart() throws InterruptedException {
    	
    	homePage.selectProduct("Samsung Galaxy S6");
        productPage.clickAddToCart();
        Thread.sleep(2000);
        acceptAlert();
        homePage.clickHomeMenu();
        homePage.selectProduct("Nokia lumia 1520");
        productPage.clickAddToCart();
        Thread.sleep(2000);
        acceptAlert();
        homePage.clickCart();
    	
        cartPage.deleteProduct("Samsung galaxy s6");
        Thread.sleep(2000);
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Cart was not cleared successfully.");
        
    }
}
