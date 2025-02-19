package test;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import utils.UtilsClass;

public class ProductCategoriesTest extends ProjectSpecificationMethods {
	private HomePage homePage;

	@BeforeMethod(groups = "Product")
	public void setUp() {
		
		homePage = new HomePage(UtilsClass.driver);
	}

	@Test(groups = "Product")
	public void testMenuItemsDisplayed() {
		Assert.assertTrue(homePage.isHomeMenuDisplayed(), "Home menu is not dispalyed on homepage.");
		Assert.assertTrue(homePage.isContactMenuDisplayed(), "Contact menu is not dispalyed on homepage.");
		Assert.assertTrue(homePage.isAboutusMenuDisplayed(), "About us menu is not dispalyed on homepage.");
		Assert.assertTrue(homePage.isCartmenuDispalyed(), "Cart menu is not dispalyed on homepage.");
		System.out.println("All Menu items are displayed on homepage. ");
	}
	@Test(groups = "Product")
	public void testCategoriesDisplayed() {
		List<String> expectedCategories = Arrays.asList("Phones", "Laptops", "Monitors");
		Assert.assertEquals(homePage.getCategories(), expectedCategories,"Categories displayed do not match expected categories.");
		System.out.println("Categories: " + homePage.getCategories());
		System.out.println("All Categories are displayed on the homepage.");
	}
	@Test(groups = "Product")
	public void testLogoDisplayed() {
		Assert.assertTrue(homePage.isLogoDisplayed(), "Logo is not displayed on the homepage");
		System.out.println("Logo is Displayed on the homepage");
	}
	
}
