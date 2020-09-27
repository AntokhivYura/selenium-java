package seleniumjava.homework6.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seleniumjava.homework6.pages.CartPage;
import seleniumjava.homework6.pages.MainPage;
import seleniumjava.homework6.pages.ProductPage;

public class CartTest extends BaseTest {

    @Test
    void addRemoveFromCartTest() {
        MainPage mainPage = new MainPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        for (int i = 1; i < 4; i++){
            mainPage.navigateToPopularProductsSection()
                    .clickRandomProductFromPopularProducts()
                    .addProductToCart()
                    .waitUntilCartCounterBecome(i)
                    .navigateToMainPage();
        }
        mainPage.openCart();

        cartPage.deleteAllProductsFromCart();

        Assertions.assertEquals(0, cartPage.getCountOfElementsInCart());

    }
}
