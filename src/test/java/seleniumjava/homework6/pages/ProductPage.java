package seleniumjava.homework6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
    private final By button_addToCart = By.xpath("//button[@name='add_cart_product']");
    private final By productCartCounter = By.xpath("//div[@class='badge quantity']");
    private final By logo = By.xpath("//a[@class='logotype']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage addProductToCart(){
        click(button_addToCart);
        return this;
    }

    public ProductPage waitUntilCartCounterBecome(int counterValue){
        waitUntilElementTextChanges(productCartCounter, String.valueOf(counterValue));
        return this;
    }

    public MainPage navigateToMainPage(){
        driver.findElement(logo).click();
        return new MainPage(driver);
    }

}