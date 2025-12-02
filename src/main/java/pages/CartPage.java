package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By cartButton = By.cssSelector("a[href*='cart']");
    private By cartItems = By.cssSelector(".cart-item");
    private By totalPrice = By.cssSelector(".total .price");

    public CartPage(WebDriver driver){
        super(driver);
    }

    public void openCart(){
        click(cartButton);
    }

    public int getCartItemsCount(){
        return driver.findElements(cartItems).size();
    }

    public String getTotalPrice(){
        return getText(totalPrice);
    }
}

