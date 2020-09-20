package seleniumjava.homework3;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AdminPageTests extends BaseTest {
    public By usernameField = By.xpath("//input[@name='username']");
    public By passwordField = By.xpath("//input[@name='password']");
    public By menuItems = By.xpath("//*[@id='box-apps-menu']/child::*[@class = 'app']");
    public By subMenuItems = By.xpath("//*[@id='box-apps-menu']/descendant::*[@class= 'docs']/child::*");
    public By successfulLoginMessage = By.xpath("//div[@class='alert alert-success']");
    public By header = By.xpath("//div[@class='panel-heading']");
    private List<String> menuItemsList;
    private List<String> subMenuItemsList;

    private void loginToAdminPanel() {
        driver.get("http://35.236.6.102/litecart/admin");
        driver.findElement(usernameField).sendKeys("admin");
        driver.findElement(passwordField).sendKeys("gl_admin" + Keys.ENTER);
    }

    @Test()
    void name() {
        loginToAdminPanel();
        waitForElementToBeDisplay(successfulLoginMessage, 5);

        getListOfMenuItems();

        for (String a : menuItemsList) {

            boolean isMenuHeaderDisplayed = isElementDisplayed(header);
            System.out.println("Header on " + a + " menu is displayed ? " + isMenuHeaderDisplayed);

            WebElement menuItem = driver.findElement(By.xpath("//*[@id='box-apps-menu']/descendant::span[.='" + a + "']"));
            menuItem.click();

            getListOfSubMenuItems();

            if (subMenuItemsList != null) {
                for (String b : subMenuItemsList) {
                    WebElement subMenuItem = driver.findElement(
                            By.xpath("//*[@id='box-apps-menu']/descendant::span[.='" + b + "']"));
                    subMenuItem.click();
                    boolean isSubMenuHeaderDisplayed = isElementDisplayed(header);
                    System.out.println("Header on " + b + " submenu is displayed ? " + isSubMenuHeaderDisplayed);
                }
            }
            subMenuItemsList.clear();
        }

    }

    public void getListOfMenuItems() {
        menuItemsList = new ArrayList<>();
        List<WebElement> listOfElements = driver.findElements(menuItems);
        for (WebElement a : listOfElements) {
            menuItemsList.add(a.getText());
        }
    }

    public void getListOfSubMenuItems() {
        subMenuItemsList = new ArrayList<>();
        List<WebElement> listOfElements = driver.findElements(subMenuItems);
        for (WebElement a : listOfElements) {
            subMenuItemsList.add(a.getText());
        }
    }
}
