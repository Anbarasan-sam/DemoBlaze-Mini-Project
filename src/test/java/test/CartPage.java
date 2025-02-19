package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.UtilsClass;

import java.util.List;

public class CartPage extends UtilsClass {

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> cartItems;

    @FindBy(xpath = "//a[text()='Delete']")
    private List<WebElement> deleteButtons;

    @FindBy(id = "totalp")
    private WebElement totalPrice;

    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrder;

    public CartPage(WebDriver driver) {
        UtilsClass.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getCartItemCount() {
        waitForElementsVisible(cartItems, 10); 
        return cartItems.size();
    }

    public boolean isProductInCart(String productName) {
        waitForElementsVisible(cartItems, 10); 
        for (WebElement item : cartItems) {
            if (item.getText().contains(productName)) {
                return true;
            }
        }
        return false;
    }

    public CartPage deleteProduct(String productName) {
        waitForElementsVisible(cartItems, 10); 
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getText().contains(productName)) {
                deleteButtons.get(i).click();
                break;
            }
        }
        return new CartPage(driver);
    }

    public double getTotalPrice() {
        waitForElementVisible(totalPrice, 10); 
        return Double.parseDouble(totalPrice.getText().replace("$", "").trim());
    }

    public CartPage clearCart() {
        while (cartItems.size() >0) {
            WebElement deleteButton = deleteButtons.get(0);
            waitForElementClickable(deleteButton, 10);
            deleteButton.click();
        }
        return new CartPage(driver);
    }

    public OrderPage clickPlaceOrder() {
        waitForElementClickable(placeOrder, 10);
        placeOrder.click();
        return new OrderPage(driver);
    }
}
