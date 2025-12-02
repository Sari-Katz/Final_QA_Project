package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {



    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // מיפוי: שם מידה -> הערך מתוך for="...Size-X"
    private String getSizeAttribute(String size) {
        switch (size) {
            case "6Y": return "Size-1";
            case "7Y": return "Size-2";
            case "8Y": return "Size-3";
            case "10Y": return "Size-4";
            case "12Y": return "Size-5";
            default: throw new RuntimeException("Unknown size: " + size);
        }
    }

    public void selectSize(String size) {
        String sizeAttr = getSizeAttribute(size);
        // CSS בלבד:
        By sizeOption = By.cssSelector("label[for*='" + sizeAttr + "']");
        click(sizeOption);
    }

//    public void setQuantity(int qty) {
//        for (int i = 1; i < qty; i++) {
//            click(By.cssSelector("quantity-btn[name='plus']"));
//        }
//    }
//public void setQuantity(int qty) {
//    for (int i = 1; i < qty; i++) {
//        // בכל קליק אנחנו מאתרים מחדש את האלמנט כדי להימנע מ-StaleElement
//        By plusBtn = By.cssSelector("quantity-btn[name='plus']");
//        waitForClickable(plusBtn);  // ממתין שהכפתור החדש יהיה קליקבילי
//        click(plusBtn);             // לוחץ
//    }
//}

    public void setQuantity(int qty) {

        By plusBtn = By.cssSelector("quantity-btn[name='plus']");
        By qtyInput = By.cssSelector("input[name='quantity']");

        for (int i = 1; i < qty; i++) {
            try {
                // מאתר מחדש בכל קליק
                waitForClickable(plusBtn);
                click(plusBtn);

                // מחכה שהקומפוננטה תרונדר מחדש
                waitForVisible(qtyInput);

                // מחכה שהערך באמת השתנה לפני הקליק הבא
//                wait.until(driver -> {
//                    String value = driver.findElement(qtyInput).getAttribute("value");
//                    return Integer.parseInt(value) == (i + 1);
//                });

            } catch (Exception e) {
                System.out.println("Retry quantity click: " + i);
                i--; // חוזר על אותו סיבוב
            }
        }
    }




    public void addToCart(String id) {
        click(By.cssSelector("#"+id));
          }
}
