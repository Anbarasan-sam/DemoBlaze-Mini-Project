package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import utils.UtilsClass;

public class ProductDetailsTest extends ProjectSpecificationMethods {

	private HomePage homePage;
	private ProductDetailsPage productPage;
	private CartPage cartPage;

	@BeforeMethod(groups = "Product")
	public void setUp() {
		
		homePage = new HomePage(UtilsClass.driver);
		productPage = new ProductDetailsPage(UtilsClass.driver);
		cartPage = new CartPage(UtilsClass.driver);
	}

    @Test(groups = "Product",priority=1)
    public void testRedirectionToProductDetailsPage()throws InterruptedException  {
       
       Thread.sleep(2000);
        homePage.selectProduct("Samsung galaxy s6");
        Assert.assertTrue(productPage.isProductDetailsDisplayed(), "Product details page is not displayed.");
    }
    
    @Test(groups = "Product",priority=2)
    public void verifyProductDetailsPage() throws InterruptedException{
    	
    	 Thread.sleep(2000);
         homePage.selectProduct("Samsung galaxy s6");
     
    	Assert.assertEquals(productPage.getProductName(), "Samsung galaxy s6", "Product name is incorrect.");
        Assert.assertTrue(productPage.getProductPrice().contains("360"), "Product price is incorrect.");
        Assert.assertEquals(productPage.getProductDescription(),productPage.getProductDescription(),"Product description is incorrect.");
    }
    
    @Test(groups = "Product",priority=3)
    public void testAddToCart()throws InterruptedException {
    	Thread.sleep(2000);
        homePage.selectProduct("Samsung galaxy s6");
        productPage.clickAddToCart();
        Thread.sleep(2000);
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertTrue(alertMessage.contains("Product added"), "Product not added to cart.");
        driver.switchTo().alert().accept();
    }
    
    @Test(groups = "Product",priority=4)
    public void testCartCount()throws InterruptedException {
    	Thread.sleep(2000);
        homePage.selectProduct("Samsung galaxy s6");
        productPage.clickAddToCart();
        Thread.sleep(2000);
        acceptAlert();
        homePage.clickCart();
        Thread.sleep(3000);
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Cart item count is incorrect.");
        Assert.assertTrue(cartPage.isProductInCart("Samsung galaxy s6"), "Product is not in the cart.");
    }
}
