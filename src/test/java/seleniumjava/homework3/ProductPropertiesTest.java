package seleniumjava.homework3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductPropertiesTest extends BaseTest {
    private By productNameOnMainPage = By.xpath("//section[@id='box-campaign-products']//h4[@class='name']");
    private By productNameOnItemPage = By.xpath("//article[@id='box-product']//h1[@class='title']");
    private By productRegularPriceOnMainPage = By.xpath("//section[@id='box-campaign-products']//del[@class='regular-price']");
    private By productRegularPriceOnItemPage = By.xpath("//article[@id='box-product']//del[@class='regular-price']");
    private By productDiscountPriceOnMainPage = By.xpath("//section[@id='box-campaign-products']//strong[@class='campaign-price']");
    private By productDiscountPriceOnItemPage = By.xpath("//article[@id='box-product']//strong[@class='campaign-price']");
    List<String> productOnMainPage;
    List<String> productOnItemPage;

    @Test
    void name() {
        driver.get("http://35.236.6.102/litecart/");

        WebElement firstProductInCampaign = driver.findElement(By.xpath("//section[@id='box-campaign-products']//img[@alt='Yellow Duck']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstProductInCampaign);

        WebElement productNameOnMainPageElem = driver.findElement(productNameOnMainPage);
        WebElement productRegularPriceOnMainPageElem = driver.findElement(productRegularPriceOnMainPage);
        WebElement productDiscountPriceOnMainPageElem = driver.findElement(productDiscountPriceOnMainPage);

        productOnMainPage = new ArrayList<>();

        productOnMainPage.add(productNameOnMainPageElem.getText());
        productOnMainPage.add(productRegularPriceOnMainPageElem.getText());
        productOnMainPage.add(productRegularPriceOnMainPageElem.getCssValue("text-decoration-line"));
        productOnMainPage.add(productRegularPriceOnMainPageElem.getCssValue("color"));
        productOnMainPage.add(productDiscountPriceOnMainPageElem.getText());
        productOnMainPage.add(productDiscountPriceOnMainPageElem.getCssValue("font-weight"));
        productOnMainPage.add(productDiscountPriceOnMainPageElem.getCssValue("color"));

        firstProductInCampaign.click();

        WebElement productNameOnItemPageElem = driver.findElement(productNameOnItemPage);
        WebElement productRegularPriceOnItemPageElem = driver.findElement(productRegularPriceOnItemPage);
        WebElement productDiscountPriceOnItemPageElem = driver.findElement(productDiscountPriceOnItemPage);

        productOnItemPage = new ArrayList<>();

        productOnItemPage.add(productNameOnItemPageElem.getText());
        productOnItemPage.add(productRegularPriceOnItemPageElem.getText());
        productOnItemPage.add(productRegularPriceOnItemPageElem.getCssValue("text-decoration-line"));
        productOnItemPage.add(productRegularPriceOnItemPageElem.getCssValue("color"));
        productOnItemPage.add(productDiscountPriceOnItemPageElem.getText());
        productOnItemPage.add(productDiscountPriceOnItemPageElem.getCssValue("font-weight"));
        productOnItemPage.add(productDiscountPriceOnItemPageElem.getCssValue("color"));

        System.out.println(productOnMainPage);
        System.out.println(productOnItemPage);

    }
}
