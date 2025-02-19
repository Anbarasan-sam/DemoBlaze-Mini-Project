package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.UtilsClass;

public class SignUpPage extends UtilsClass{

    @FindBy(id = "sign-username")
    private WebElement usernameField;

    @FindBy(id = "sign-password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElement signUpSubmitButton;

    @FindBy(xpath = "(//div[@class='modal-content'])[2]")
    private WebElement signUpModal;
    
    @FindBy(xpath="(//button[text()='Close'])[2]")
	private WebElement closeSignUp;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isSignUpModalDisplayed() {
    	waitForElementVisible(signUpModal, 10);
        return signUpModal.isDisplayed();
    }

    public SignUpPage enterUsername(String username) {
        usernameField.sendKeys(username);
        return new SignUpPage(driver);
    }

    public SignUpPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return new SignUpPage(driver);
    }

    public HomePage clickSignUpSubmit() {
        signUpSubmitButton.click();
        return new HomePage(driver);
    }
    
    public SignUpPage closeSignUpPage() {
		 closeSignUp.click();
		 return new SignUpPage(driver);
	 }
}
