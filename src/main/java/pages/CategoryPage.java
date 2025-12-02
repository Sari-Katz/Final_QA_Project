package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage extends BasePage {

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    // בחירת מוצר לפי חלק מה-href (יציב, קצר, מומלץ)
    public void openProduct(String partialHref) {
        click(By.cssSelector("a[href*='" + partialHref + "']"));
    }
}

