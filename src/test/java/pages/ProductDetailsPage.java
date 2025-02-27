package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.UtilsClass;

public class ProductDetailsPage extends UtilsClass {

    @FindBy(xpath = "//h2[@class='name']")
    private WebElement productName;

    @FindBy(xpath = "//h3[@class='price-container']")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@id='more-information']//p")
    private WebElement productDescription;

    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement addToCartButton;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductName() {
    	waitForElementVisible(productName, 10);
        return productName.getText();
    }

    public String getProductPrice() {
    	waitForElementVisible(productPrice, 10);
        return productPrice.getText().split(" ")[0].trim();
    }

    public String getProductDescription() {
    	waitForElementVisible(productDescription, 10);
        return productDescription.getText();
    }

    public CartPage clickAddToCart() {
    	waitForElementVisible(addToCartButton, 10);
        addToCartButton.click();
        return new CartPage(driver);
    }

    public boolean isProductDetailsDisplayed() {
    	waitForElementVisible(productName, 10);
        return productName.isDisplayed() && productPrice.isDisplayed() && productDescription.isDisplayed();
    }
}
