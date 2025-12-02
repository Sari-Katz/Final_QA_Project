package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.CategoryPage;
import pages.CartPage;
import pages.ProductPage;

public class CartTest extends BaseTest {

    @Test
    public void testCartFlow(){

        HomePage home = new HomePage(driver);
        CategoryPage category = new CategoryPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cart = new CartPage(driver);

        home.open();
        home.goToCategory("BOYS");
        category.openProduct("black-star-sweaters");
        productPage.selectSize("8Y");
        //productPage.setQuantity(2);
        productPage.addToCart("product-buy-btn-7375785427078-template--17695874285702__main---MainSection");
        home.goToCategory("BABY");
        category.openProduct("black-star-terry-sweaters");
        productPage.selectSize("6Y");
        //productPage.setQuantity(2);
        productPage.addToCart("product-buy-btn-7375785328774-template--17695874285702__main---MainSection");
        home.goToCategory("GIRLS");
        category.openProduct("black-dress");
        productPage.selectSize("7Y");
        productPage.setQuantity(3);
        productPage.addToCart("product-buy-btn-7375778906246-template--17695874285702__main---MainSection");
        cart.openCart();;
        int count = cart.getCartItemsCount();
        System.out.println("Items in cart: " + count);
//
//        assert count >= 0;
    }
}
