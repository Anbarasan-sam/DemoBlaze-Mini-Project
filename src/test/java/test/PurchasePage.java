package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.UtilsClass;

public class PurchasePage extends UtilsClass {

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

    @FindBy(xpath = "//div[@class='sweet-alert  showSweetAlert visible']")
    private WebElement confirmationModal;

    @FindBy(xpath = "//p[contains(@class, 'lead text-muted')]")
    private WebElement confirmationMessage;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PurchasePage enterName(String name) {
        waitForElementVisible(nameField, 10);
        nameField.sendKeys(name);
        return new PurchasePage(driver);
    }

    public PurchasePage enterCountry(String country) {
        waitForElementVisible(countryField, 10);
        countryField.sendKeys(country);
        return new PurchasePage(driver);
    }

    public PurchasePage enterCity(String city) {
        waitForElementVisible(cityField, 10);
        cityField.sendKeys(city);
        return new PurchasePage(driver);
    }

    public PurchasePage enterCreditCard(String cardNumber) {
        waitForElementVisible(creditCardField, 10);
        creditCardField.sendKeys(cardNumber);
        return new PurchasePage(driver);
    }

    public PurchasePage enterMonth(String month) {
        waitForElementVisible(monthField, 10);
        monthField.sendKeys(month);
        return new PurchasePage(driver);
    }

    public PurchasePage enterYear(String year) {
        waitForElementVisible(yearField, 10);
        yearField.sendKeys(year);
        return new PurchasePage(driver);
    }

    public PurchasePage clickPurchaseButton() {
        waitForElementVisible(purchaseButton, 10);
        purchaseButton.click();
        return new PurchasePage(driver);
    }

    public boolean isConfirmationModalDisplayed() {
        waitForElementVisible(confirmationModal, 10);
        return confirmationModal.isDisplayed();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }
}
