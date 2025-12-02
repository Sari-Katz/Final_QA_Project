package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By categoryLinkTemplate = By.cssSelector("a.category-link");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get("https://www.petitclair.com/");
    }

    public void goToCategory(String name) {
        click(By.cssSelector("a.header__item[aria-label='" + name + "']"));
    }

}



