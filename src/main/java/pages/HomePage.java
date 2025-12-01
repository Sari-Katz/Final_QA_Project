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

    public void goToCategoryByName(String name){
        click(By.xpath("//a[contains(text(),'" + name + "')]"));
    }
}



