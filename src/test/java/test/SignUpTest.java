package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.SignUpPage;
import utils.UtilsClass;


public class SignUpTest extends ProjectSpecificationMethods {
	
    private HomePage homePage;
    private SignUpPage signUpPage;

    @BeforeMethod(groups = "signUp")
    public void setUp() {
        
        homePage = new HomePage(UtilsClass.driver);
        signUpPage = new SignUpPage(UtilsClass.driver);
    }

    @Test(groups = "signUp")
    public void testSignUpButtonVisibility() {
        Assert.assertTrue(homePage.isSignUpButtonVisible(), "Sign up button is not visible.");
    }
    @Test(groups = "signUp")
    public void testSignUpButtonClickable() {
        Assert.assertTrue(homePage.isSignUpButtonClickable(), "Sign Up button is not clickable.");
    }
    @Test(groups = "signUp")
    public void testSignUpButtonModalVisible() {
        homePage.clickSignUpButton();
        Assert.assertTrue(signUpPage.isSignUpModalDisplayed(), "Sign up modal did not open.");
        signUpPage.closeSignUpPage();
    }
}
