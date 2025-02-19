package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.UtilsClass;

public class OrderPage extends UtilsClass{

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "country")
    private WebElement countryField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "card")
    private WebElement creditCardField;

    @FindBy(id = "month")
    private WebElement monthField;

    @FindBy(id = "year")
    private WebElement yearField;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement purchaseButton;

    @FindBy(xpath = "//div[contains(@class,'sweet-alert')]")
    private WebElement confirmationModal;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    private WebElement confirmationMessage;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public boolean isNameFieldVisible() {
		return nameField.isDisplayed();
    }
    
    public OrderPage enterName(String name) {
    	waitForElementVisible(nameField, 10);
        nameField.sendKeys(name);
        return new OrderPage(driver);
    }
    
    public boolean isCountryFieldVisible() {
		return countryField.isDisplayed();
    }
    
    public OrderPage enterCountry(String country) {
    	waitForElementVisible(countryField, 10);
        countryField.sendKeys(country);
        return new OrderPage(driver);
    }
    
    public boolean isCityFieldVisible() {
		return cityField.isDisplayed();
    }
    
    public OrderPage enterCity(String city) {
    	waitForElementVisible(cityField, 10);
        cityField.sendKeys(city);
        return new OrderPage(driver);
    }

    public boolean isCreditCardFieldVisible() {
		return creditCardField.isDisplayed();
    }
    
    public OrderPage enterCreditCard(String cardNumber) {
    	waitForElementVisible(creditCardField, 10);
        creditCardField.sendKeys(cardNumber);
        return new OrderPage(driver);
    }

    public boolean isMonthFieldVisible() {
		return monthField.isDisplayed();
    }
    
    public OrderPage enterMonth(String month) {
    	waitForElementVisible(monthField, 10);
        monthField.sendKeys(month);
        return new OrderPage(driver);
    }

    public boolean isYearFieldVisible() {
		return yearField.isDisplayed();
    }
    
    public OrderPage enterYear(String year) {
    	waitForElementVisible(yearField, 10);
        yearField.sendKeys(year);
        return new OrderPage(driver);
    }
    
    
    public PurchasePage clickPurchaseButton() {
    	waitForElementClickable(purchaseButton, 10);
        purchaseButton.click();
        return new PurchasePage(driver);
    }

    public boolean isConfirmationModalDisplayed() {
    	waitForElementVisible(confirmationModal, 10);
        return confirmationModal.isDisplayed();
    }

    public String getConfirmationMessage() {
    	waitForElementVisible(confirmationMessage, 10);
        return confirmationMessage.getText();
    }
}
