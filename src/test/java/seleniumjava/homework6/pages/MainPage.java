package seleniumjava.homework6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage {
    private final By productCart = By.id("cart");
    private final By popularProductsSection = By.id("box-popular-products");
    private final By allProductsFromPopularProducts = By.xpath("//section[@id='box-popular-products']/descendant::article[@class='product-column']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage navigateToPopularProductsSection(){
        navigateToElement(popularProductsSection);
        return this;
    }

    public ProductPage clickRandomProductFromPopularProducts(){
        List<WebElement> listOfProducts = driver.findElements(allProductsFromPopularProducts);
        int a = (int) (Math.random() * listOfProducts.size());
        listOfProducts.get(a).click();
        return new ProductPage(driver);
    }

    public CartPage openCart(){
        click(productCart);
        return new CartPage(driver);
    }

}