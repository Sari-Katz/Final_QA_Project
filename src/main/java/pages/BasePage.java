package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    protected WebElement waitForVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void click(By locator){
        waitForVisible(locator).click();
    }
    protected void type(By locator, String text){
        WebElement el = waitForVisible(locator);
        el.clear();
        el.sendKeys(text);
    }
    protected String getText(By locator){
        return waitForVisible(locator).getText();
    }
    protected void takeScreenshot(String path){
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        try { Files.copy(src.toPath(), Paths.get(path)); } catch(Exception e){ e.printStackTrace(); }
    }
}
