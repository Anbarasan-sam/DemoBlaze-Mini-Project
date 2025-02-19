package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.LoginPage;
import utils.UtilsClass;

public class LogoutTest extends ProjectSpecificationMethods {

	private HomePage homePage;
	private LoginPage loginPage;

	@BeforeMethod
	public void setup() {
		homePage = new HomePage(UtilsClass.driver);
		loginPage = new LoginPage(UtilsClass.driver);
	}

	@Test(groups = "Logout")
	public void testLogoutButtonVisibility() {
		homePage.clickLoginButton();
		loginPage.enterUsername("testusername00001");
		loginPage.enterPassword("testuser1");
		loginPage.clickLoginSubmit();

		Assert.assertTrue(homePage.isLogoutButtonVisible(), "Logout button is not visible after login.");
	}

	@Test(groups = "Logout")
	public void testLogoutRedirectionToHomePage() throws InterruptedException {

		homePage.clickLoginButton();
		loginPage.enterUsername("testusername00001");
		loginPage.enterPassword("testuser1");
		loginPage.clickLoginSubmit();

		homePage.clickLogoutButton();
		Thread.sleep(2000);
		String currentUrl = driver.getCurrentUrl();
		Thread.sleep(2000);
		Assert.assertTrue(homePage.isLoginButtonVisible(), "Login button is not visible after logout.");
		System.out.println("Current url ::" + currentUrl);
	}

}
