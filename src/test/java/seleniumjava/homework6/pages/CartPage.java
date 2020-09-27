package seleniumjava.homework6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    private final By deleteProductFromCartButtons = By.xpath("//div[@class='table-responsive']/descendant::button[@name='remove_cart_item']");
    private final By productsInCart = By.xpath("//div[@class='table-responsive']//descendant::tr[@class='item']");
    private final By noItemsInCartMessage = By.xpath("//p[.='There are no items in your cart.']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void deleteAllProductsFromCart() {
        List<WebElement> emptyCartMessage = driver.findElements(noItemsInCartMessage);
       while (emptyCartMessage.isEmpty()){
           waitForElementToDisappear(By.className("loader-wrapper"));
           List<WebElement> deleteButtons = driver.findElements(deleteProductFromCartButtons);
           if (deleteButtons.isEmpty()){
               break;
           }
           deleteButtons.get(0).click();
           emptyCartMessage = driver.findElements(noItemsInCartMessage);
       }
    }


    public int getCountOfElementsInCart() {
        List<WebElement> products = driver.findElements(productsInCart);
        return products.size();
    }

}
