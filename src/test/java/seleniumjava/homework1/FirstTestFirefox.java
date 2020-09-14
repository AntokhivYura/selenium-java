package seleniumjava.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirstTestFirefox {
    public FirefoxDriver driver;


    @BeforeEach
    void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test
    public void firstTest() {
        driver.get("http://google.com");
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
