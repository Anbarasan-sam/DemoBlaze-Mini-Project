package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.LoginPage;
import utils.UtilsClass;

public class LoginTest extends ProjectSpecificationMethods{
	
    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        homePage = new HomePage(UtilsClass.driver);
        loginPage= new LoginPage(UtilsClass.driver);
    }

    @Test(groups = "Login")
    public void testLoginButtonVisibility() {
        Assert.assertTrue(homePage.isLoginButtonVisible(), "Login button is not visible on the homepage.");
    }

    @Test(groups = "Login")
    public void testLoginButtonClickable() {
        Assert.assertTrue(homePage.isLoginButtonClickable(), "Login button is not clickable.");
    }

    @Test(groups = "Login")
    public void testLoginWithValidCredentials() {
        homePage.clickLoginButton();
        loginPage.enterUsername("testusername00001");
        loginPage.enterPassword("testuser1");
        loginPage.clickLoginSubmit();
        Assert.assertTrue(homePage.isWelcomeUserDisplayed(), "Login failed. Welcome message not displayed.");
    }
}