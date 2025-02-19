package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.UtilsClass;

public class LoginPage extends UtilsClass{

    @FindBy(id = "loginusername")
    private WebElement usernameField;

    @FindBy(id = "loginpassword")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginSubmitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage enterUsername(String username) {
    	waitForElementVisible(usernameField, 10);
        usernameField.sendKeys(username);
        return new LoginPage(driver);
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return new LoginPage(driver);
    }

    public LoginPage clickLoginSubmit() {
        loginSubmitButton.click();
        return new LoginPage(driver);
    }
}
