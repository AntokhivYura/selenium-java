package seleniumjava.homework6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    public boolean isElementDisplayed(By by) {
        return driver.findElement(by).isDisplayed();
    }

    public void waitForElementLocatedByToBeDisplay(By by, int timeout) {
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementToBeDisplay(WebElement element, int timeout) {
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void navigateToElement(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitUntilElementTextChanges(By by, String text) {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
    }

    public void waitForElementToDisappear(By by) {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

    }

}
