package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator) {
        retryClick(locator, 3);
    }

    private void retryClick(By locator, int tries) {
        for (int i = 0; i < tries; i++) {
            try {
                waitForClickable(locator).click();
                return;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                System.out.println("Retry click: " + (i + 1));
            }
        }
        // ניסיון אחרון — אם נכשל זורק
        waitForClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement el = waitForVisible(locator);
        el.clear();
        el.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForVisible(locator).getText();
    }

    protected void jsClick(By locator) {
        WebElement el = waitForVisible(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    protected void waitForDomStable() {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(web -> ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState").equals("complete"));
    }

}
